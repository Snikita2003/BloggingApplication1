package com.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.Notification;

public interface NotificationRepo extends JpaRepository<Notification, Integer> {

    List<Notification> findByReceiverIdOrderByCreatedAtDesc(Integer receiverId);

}