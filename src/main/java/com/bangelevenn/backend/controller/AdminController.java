package com.bangelevenn.backend.controller;


import com.bangelevenn.backend.model.Post;
import com.bangelevenn.backend.model.User;
import com.bangelevenn.backend.payload.response.MessageResponse;
import com.bangelevenn.backend.service.PostService;
import com.bangelevenn.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @GetMapping("/userManager/getAllUsers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = this.userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @DeleteMapping("/userManager/deleteUserById/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(new MessageResponse("Delete user successfully!"), HttpStatus.OK);
    }


    @GetMapping("/postManager/getAllPosts")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllPosts() {
        List<Post> posts = this.postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @RequestMapping(value = "/postManager/getPostById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPost(@PathVariable("id") Long id) {
        System.out.println("ok");
        Post post = postService.findByIdPost(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }



    @GetMapping("/postManager/getAllPostsByDate/DESC")
    public ResponseEntity<?> getListPostAndPaginationDESC() {
        List<Post> posts = postService.findAllByOrderByDateDesc();

        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


    @DeleteMapping("/postManger/deletePostById/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletePostById(@PathVariable("id") Long id) {
        postService.delete(id);
        return new ResponseEntity<>(new MessageResponse("Delete post successfully!"), HttpStatus.OK);
    }












}
