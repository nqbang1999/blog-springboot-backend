package com.bangelevenn.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "post")

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Length(min = 0, max = 50)
    private String title;


    @Length(min = 0, max = 1000)
    private String content;



    @ManyToOne
    @JoinColumn
    private User user;


//    @JsonIgnore
//    @OneToMany(targetEntity = Response.class , mappedBy = "post" , cascade = CascadeType.ALL)
//    private List<Response> responses;





    private LocalDateTime date;


    public Post() {
    }


    public Post(@Length(min = 0, max = 50) String title, @Length(min = 0, max = 1000) String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }


    public Post(@Length(min = 0, max = 50) String title, @Length(min = 0, max = 1000) String content, User user, LocalDateTime date) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.date = date;
    }


//    public Post(@Length(min = 0, max = 50) String title, @Length(min = 0, max = 1000) String content, User user, List<Response> responses, LocalDateTime date) {
//        this.title = title;
//        this.content = content;
//        this.user = user;
//        this.responses = responses;
//        this.date = date;
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public List<Response> getResponses() {
//        return responses;
//    }
//
//    public void setResponses(List<Response> responses) {
//        this.responses = responses;
//    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
