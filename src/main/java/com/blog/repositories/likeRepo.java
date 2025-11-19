package com.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entities.Like;
@Repository
public interface likeRepo extends JpaRepository<Like, Integer> {

	    boolean existsByUser_UserIdAndPost_PostId(Integer userId, Integer postId);

	    void deleteByUser_UserIdAndPost_PostId(Integer userId, Integer postId);

	    int countByPost_PostId(Integer postId);
}
