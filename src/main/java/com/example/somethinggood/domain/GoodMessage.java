package com.example.somethinggood.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class GoodMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank (message = "please fill the message")
    @Length(max= 255, message = "message to long")
    private String text;
    @ManyToOne( fetch = FetchType.EAGER)
    private User author;

    public GoodMessage(String text, User user) {
        this.text = text;
        this.author = user;
    }
    public GoodMessage() {
    }

    public User getAuthor() {
        return author;
    }
    public String getAuthorName(){
        return author!=null? author.getUsername():"<none>";
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
