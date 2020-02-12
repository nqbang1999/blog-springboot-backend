//package com.bangelevenn.backend.model;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "response")
//public class Response {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//
//    private String content;
//
//
//    private LocalDateTime date;
//
//
//
////    @ManyToOne
////    @JoinColumn
////    private Post post;
//
//
//
//
//    public Response() {
//    }
//
//
////    public Response(String content, LocalDateTime date, Post post) {
////        this.content = content;
////        this.date = date;
////        this.post = post;
////    }
//
//    public Response(String content, LocalDateTime date) {
//        this.content = content;
//        this.date = date;
//    }
//
//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//
////    public Post getPost() {
////        return post;
////    }
////
////    public void setPost(Post post) {
////        this.post = post;
////    }
//
////    public User getUser() {
////        return user;
////    }
////
////    public void setUser(User user) {
////        this.user = user;
////    }
//}
