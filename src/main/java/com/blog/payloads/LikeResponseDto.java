package com.blog.payloads;

public class LikeResponseDto {

    private Integer likeId;

    // Post info
    private Integer postId;
    private String postTitle;
    private String postContent;

    // User info
    private Integer userId;
    private String userName;
    private String userEmail;

    private String likedAt; // optional, formatted date

	public Integer getLikeId() {
		return likeId;
	}

	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getLikedAt() {
		return likedAt;
	}

	public void setLikedAt(String likedAt) {
		this.likedAt = likedAt;
	}

	public LikeResponseDto(Integer likeId, Integer postId, String postTitle, String postContent, Integer userId,
			String userName, String userEmail, String likedAt) {
		super();
		this.likeId = likeId;
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.likedAt = likedAt;
	}

	public LikeResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

    // getters and setters
    
    
}
