# Blogging-Application

# Spring Boot Blogging Application

## 📌 Description
A complete blogging platform built using Spring Boot with JWT Authentication, Post Management, Comments, Likes, Categories, Search, Pagination and more.

## 🚀 Features
- User Registration & Login (JWT)
- CRUD on Users
- CRUD on Categories
- CRUD on Posts
- Comments on Posts
- Like / Unlike Posts
- Pagination & Sorting
- Search Posts
- Swagger Documentation
- Global Exception Handling
- DTOs + ModelMapper

## 🛠 Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security + JWT
- MySQL Database
- Maven
- Swagger / OpenAPI

## 📂 Project Structure
src/main/java/com/blog  
├── controllers  
├── services  
├── entities  
├── repositories  
├── payloads  
└── config  

## 📌 API Endpoints
### Auth
POST /api/auth/login  
POST /api/auth/register  

### Users
GET /api/users  
POST /api/users  
PUT /api/users/{id}  
DELETE /api/users/{id}  

### Posts
POST /api/user/{userId}/category/{catId}/posts  
GET /api/posts  
GET /api/posts/{postId}  
DELETE /api/posts/{postId}  

### Likes
POST /api/likes/{userId}/{postId}  
DELETE /api/likes/{userId}/{postId}  
GET /api/likes/{postId}

### Search
GET /api/posts/search/{keywords}

### Pagination
GET /api/posts?page=0&size=5&sortBy=addedDate&sortDir=desc

## 🗄 Database Schema
Tables: users, posts, categories, comments, likes, roles

## ▶️ How to Run
1. Clone repo  
2. Create MySQL database  
3. Update application.properties  
4. Run: `mvn spring-boot:run`  
5. Open Swagger: http://localhost:8080/swagger-ui/index.html

- Post Analytics  

