package com.blog.entities;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.Data;


import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer senderId;       // who liked
    private Integer receiverId;     // post owner
    private Integer postId;

    private String type;            // LIKE, COMMENT etc.
    private String message;

    private Boolean isRead;

    private LocalDateTime createdAt;
}

