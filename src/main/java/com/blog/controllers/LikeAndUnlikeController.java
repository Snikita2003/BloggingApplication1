package com.blog.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entities.Like;
import com.blog.payloads.ApiResponse;
import com.blog.payloads.LikeResponseDto;
import com.blog.service.LikeService;

@RestController
@RequestMapping("/api/likes")
public class LikeAndUnlikeController {

    @Autowired
    private LikeService likeService;
	@Autowired
	ModelMapper modelMapper;
	    
    // ------------------ LIKE ------------------
    @PostMapping("/{userId}/{postId}")
    public ResponseEntity<LikeResponseDto> likePost(
            @PathVariable Integer userId,
            @PathVariable Integer postId
    ) {
        Like like= this.likeService.likePost(userId, postId);
        LikeResponseDto dto = new LikeResponseDto(
        	    like.getId(),                     
        	    like.getPost().getPostId(),       
        	    like.getPost().getTitle(),    
        	    like.getPost().getContent(),      
        	    like.getUser().getUserId(),       
        	    like.getUser().getName(),         
        	    like.getUser().getEmail(),null);
 
		this.modelMapper.map(like, LikeResponseDto.class);
		
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
                
    }

    
    // ------------------ UNLIKE ------------------
    @DeleteMapping("/{userId}/{postId}")
    public ResponseEntity<String> unlikePost(
            @PathVariable Integer userId,
            @PathVariable Integer postId
    ) {
        likeService.unlikePost(userId, postId);
        return ResponseEntity.ok("Post unliked successfully.");
    }

    
    // ------------------ GET LIKES COUNT ------------------
    @GetMapping("/{postId}")
    public ResponseEntity<ApiResponse> getLikes(@PathVariable Integer postId) {
        
    	int count= (int) likeService.countLikesByPostId(postId);
    	
		ApiResponse response = new ApiResponse();
		response.setMessage("Total likes for post id " + postId + " : " + count);
		response.setSuccess(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    
    
}
