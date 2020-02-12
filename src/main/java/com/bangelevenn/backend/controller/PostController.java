package com.bangelevenn.backend.controller;

import com.bangelevenn.backend.model.Post;
import com.bangelevenn.backend.payload.response.MessageResponse;
import com.bangelevenn.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 21600000)
@RestController
@RequestMapping("/api/post")

public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping("/createPost")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> createPost(@Valid @RequestBody Post postRequest) {
        LocalDateTime now = LocalDateTime.now();
        postRequest.setDate(now);
        postService.save(postRequest);
        return new ResponseEntity<>(new MessageResponse("Create post successfully!", null), HttpStatus.OK);

    }


   @GetMapping("/getAllPosts")
    public ResponseEntity<?> listAllPost() {
        List<Post> posts = this.postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


    @RequestMapping(value = "getPostBy/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPost(@PathVariable("id") Long id) {
        System.out.println("ok");
        Post post = postService.findByIdPost(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }


    @DeleteMapping("/deletePost/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deletePostById(@PathVariable("id") Long id) {
        postService.delete(id);
        return new ResponseEntity<>(new MessageResponse("Delete post successfully!"), HttpStatus.OK);
    }


    @PutMapping("/updatePost/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> updatePost(@RequestBody Post post, @PathVariable("id") Long id) {
        Post post1 = postService.findByIdPost(id);

        LocalDateTime now = LocalDateTime.now();
        post1.setDate(now);
        post1.setTitle(post.getTitle());
        post1.setContent(post.getContent());


        postService.save(post1);
        return new ResponseEntity<>(new MessageResponse("update post successfully!", null), HttpStatus.OK);
    }


    @GetMapping("/getAllPostsByUserId/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> findAllByUserId(@PathVariable("id") Long id) {
        List<Post> posts = this.postService.findAllByUserId(id);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


    @GetMapping("/getAllPostsByDate/DESC")
    public ResponseEntity<?> getListPostAndPaginationDESC() {
        List<Post> posts = postService.findAllByOrderByDateDesc();

        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/searchPostByTitle/{title}")
    public ResponseEntity<List<Post>> searchPostByTitleContaining(@PathVariable String title) {
        try {
            List<Post> posts = postService.findPostsByTitleContaining(title);

            if (posts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
