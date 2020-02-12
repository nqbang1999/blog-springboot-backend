//package com.bangelevenn.backend.controller;
//
//import com.bangelevenn.backend.model.Post;
//import com.bangelevenn.backend.model.Response;
//import com.bangelevenn.backend.model.User;
//import com.bangelevenn.backend.payload.response.MessageResponse;
//import com.bangelevenn.backend.service.PostService;
//import com.bangelevenn.backend.service.ResponseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.Optional;
//
//@CrossOrigin(origins = "*", maxAge = 21600000)
//@RestController
//@RequestMapping("/api/response")
//
//public class ResponseController {
//
//    @Autowired
//    private ResponseService responseService;
//
//
//    @Autowired
//    private PostService postService;
//
//
//    @PostMapping("/createResponse")
//    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//    public ResponseEntity<?> createResponse(@RequestBody Response response) {
//        LocalDateTime now = LocalDateTime.now();
//        response.setDate(now);
//        responseService.save(response);
//        return new ResponseEntity<>(new MessageResponse("Create response successfully!", null), HttpStatus.OK);
//
//    }
//
//
//    @RequestMapping(value = "/listAllResponses", method = RequestMethod.GET)
//    public ResponseEntity<?> listAllResponses() {
//        List<Response> responses = this.responseService.findAll();
//        return new ResponseEntity<>(responses, HttpStatus.OK);
//    }
//
//
//    @GetMapping("/listResponsesByIdPost/{id}")
//    public ResponseEntity<?> getResponsesByIdPost(@PathVariable Long id) {
//        List<Response> responses = responseService.findResponsesByPostId(id);
//
//        if (responses.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        return new ResponseEntity<>(responses,HttpStatus.OK);
//    }
//
//
//
//
//
//
//
//
//    @RequestMapping(value = "{id}", method = RequestMethod.GET)
//    public ResponseEntity<?> getResponseById(@PathVariable("id") Long id) {
//        System.out.println("ok");
//        Post post = postService.findByIdPost(id);
//        return new ResponseEntity<>(post, HttpStatus.OK);
//    }
//
//
//}
