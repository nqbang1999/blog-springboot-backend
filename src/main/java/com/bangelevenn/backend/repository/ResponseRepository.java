//package com.bangelevenn.backend.repository;
//
//import com.bangelevenn.backend.model.Response;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ResponseRepository extends JpaRepository<Response,Long> {
//    List<Response> findResponsesByPostId(Long id);
//    List<Response> findAllByPostId(Long id);
//    Response findResponseById(Long id);
//
//    List<Response> findResponsesByPostIdAndUserId(Long idPost, Long idUser);
//
//    List<Response> findResponsesByUserId(Long idUser);
//
//
//
//
//
//}
