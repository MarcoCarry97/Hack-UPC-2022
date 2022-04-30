package com.example.springboot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @PutMapping("/upvote")
    public void upvote() {
    }

    @PutMapping("/downvote")
    public void downvote() {
    }

    @PostMapping("/search")
    public void search() {
    }

    @PostMapping("/listings")
    public void listings() {
    }
}
