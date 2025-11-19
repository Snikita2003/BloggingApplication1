package com.blog.service;
import com.blog.entities.Notification;
import com.blog.entities.Post;
import com.blog.entities.User;


public interface NotificationService {

    Notification sendLikeNotification(Integer senderId, Integer receiverId, Integer postId);

    java.util.List<Notification> getUserNotifications(Integer userId);

	
}