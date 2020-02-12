package com.bangelevenn.backend.service;

import com.bangelevenn.backend.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {

    List<Post> findAllByUserId(Long userId);

    List<Post> findAll();

    Optional<Post> findByTitleContaining(String title);

    Optional<Post> findById(long id);

    Post findByIdPost(Long id);

    Post save(Post post);

    void delete(long id);

    List<Post> findAllByOrderByDateDesc();

    List<Post> findPostsByTitleContaining(String title);

//    List<Post> findPostsByUserIdAndOrderByDateDateDesc(long id);


}
