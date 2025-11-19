package com.blog.service;

import com.blog.entities.Like;


public interface LikeService {
    Like likePost(Integer userId, Integer postId);
    Like unlikePost(Integer userId, Integer postId);
    long countLikesByPostId(Integer postId);
}
