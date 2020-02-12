package com.bangelevenn.backend.service;

import com.bangelevenn.backend.model.Post;
import com.bangelevenn.backend.model.User;
import com.bangelevenn.backend.repository.PostRepository;
import com.bangelevenn.backend.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public List<Post> findAllByUserId(Long userId) {
        return postRepository.findAllByUserId(userId);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findByTitleContaining(String title) {
        return Optional.empty();
    }

//    @Override
//    public Optional<Post> findByTitleContaining(String title) {
//        return postRepository.findByTitleContaining(title);
//    }

    @Override
    public Optional<Post> findById(long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post findByIdPost(Long id)  {
        return postRepository.findById(id).get();
    }


    @Override
    public Post save(Post post) {
        System.out.println("ok");
        User user = userDetailsService.getCurrentUser();
        System.out.println(user);
        post.setUser(user);
        return postRepository.save(post);
    }

    @Override
    public void delete(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> findAllByOrderByDateDesc() {
        return postRepository.findAllByOrderByDateDesc();
    }

    @Override
    public List<Post> findPostsByTitleContaining(String title) {
        return postRepository.findPostsByTitleContaining(title);
    }

//    @Override
//    public List<Post> findPostsByUserIdAndOrderByDateDateDesc(Long id) {
//        return postRepository.findPostsByUserIdAndOrderByDateDateDesc(id);
//    }


}

