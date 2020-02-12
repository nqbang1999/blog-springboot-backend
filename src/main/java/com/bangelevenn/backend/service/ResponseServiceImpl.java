//package com.bangelevenn.backend.service;
//
//import com.bangelevenn.backend.model.Post;
//import com.bangelevenn.backend.model.Response;
//import com.bangelevenn.backend.model.User;
//import com.bangelevenn.backend.repository.PostRepository;
//import com.bangelevenn.backend.repository.ResponseRepository;
//import com.bangelevenn.backend.security.services.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ResponseServiceImpl implements ResponseService {
//
//    @Autowired
//    private PostRepository postRepository;
//
//    @Autowired
//    private PostService postService;
//
//    @Autowired
//    private ResponseRepository responseRepository;
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Override
//    public List<Response> findResponsesByPostId(Long id) {
//        return responseRepository.findResponsesByPostId(id);
//    }
//
//    @Override
//    public List<Response> findAll() {
//        return responseRepository.findAll();
//    }
//
//
//    @Override
//    public Response findById(Long id) {
//        return responseRepository.findResponseById(id);
//    }
//
//    @Override
//    public void save(Response response) {
////        System.out.println("ok");
////        User user = userDetailsService.getCurrentUser();
////        System.out.println(user);
////        response.setUser(user);
////        return responseRepository.save(response);
//
//        responseRepository.save(response);
//
//    }
//
//    @Override
//    public void delete(long id) {
//        responseRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Response> findResponsesByUserId(Long id) {
//        return responseRepository.findResponsesByUserId(id);
//    }
//}
