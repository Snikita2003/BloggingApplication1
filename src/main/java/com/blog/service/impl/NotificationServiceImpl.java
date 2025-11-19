package com.blog.service.impl;
import com.blog.entities.Notification;
import com.blog.repositories.NotificationRepo;
import com.blog.service.NotificationService;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;



@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    @Override
    public Notification sendLikeNotification(Integer senderId, Integer receiverId, Integer postId) {

        Notification noti = new Notification();
        noti.setSenderId(senderId);
        noti.setReceiverId(receiverId);
        noti.setPostId(postId);
        noti.setType("LIKE");
        noti.setMessage("Someone liked your post");
        noti.setIsRead(false);
        noti.setCreatedAt(LocalDateTime.now());

        return notificationRepo.save(noti);
    }

    @Override
    public List<Notification> getUserNotifications(Integer userId) {
        return notificationRepo.findByReceiverIdOrderByCreatedAtDesc(userId);
    }
}