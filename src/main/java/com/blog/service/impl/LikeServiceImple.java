package com.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.Like;
import com.blog.entities.Post;
import com.blog.entities.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.repositories.PostRepo;
import com.blog.repositories.UserRepo;
import com.blog.repositories.likeRepo;
import com.blog.service.LikeService;
import com.blog.service.NotificationService;

import io.swagger.v3.oas.annotations.servers.Server;

@Service
public class LikeServiceImple implements LikeService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private likeRepo likeRepo;
	@Autowired
	private  NotificationService notificationService;
	
	
	@Override
	public Like likePost(Integer userId, Integer postId) {
		
		 if( likeRepo.existsByUser_UserIdAndPost_PostId(userId, postId)) {
	            throw new IllegalStateException("User has already liked this post.");
	        }
		 
		User user= this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User ","not found with id: ", userId));
		Post post= this.postRepo.findById(postId)
				.orElseThrow(()-> new ResourceNotFoundException("Post", "Post Not found :", postId));
		
		
		Like like=new Like();
		like.setUser(user);
		like.setPost(post);
		
		
		this.likeRepo.save(like);
		// Send notification (avoid self notifications)
		Integer postOwnerId = post.getUser().getUserId();
	    if (!postOwnerId.equals(userId)) {
	        notificationService.sendLikeNotification(userId, postOwnerId, postId);
	    }
        
		return like;

	}

	@Override
	public Like unlikePost(Integer userId, Integer postId) {
		
		if( !this.likeRepo.existsByUser_UserIdAndPost_PostId(userId, postId) )
		{
			 throw new IllegalStateException("User has Not liked this post.");
			
		}
		
		this.likeRepo.deleteByUser_UserIdAndPost_PostId(userId, postId);
		return null;
		
	}

	@Override
	public long countLikesByPostId(Integer postId) {
		
		Post post=this.postRepo.findById(postId)
		.orElseThrow(()-> new ResourceNotFoundException("Post", "postID :", postId));
		
		return this.likeRepo.countByPost_PostId(postId);
		
	}
	
	

}
