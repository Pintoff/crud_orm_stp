package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PostEntity;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.service.PostService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/posts")

public class PostController {
    @Autowired
    private PostService PostService;

    @PostMapping
    public ResponseEntity addPost(@RequestBody PostEntity post) {
        try {
            return ResponseEntity.ok(PostService.update(post));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PatchMapping
    public ResponseEntity updatePost(@RequestBody PostEntity post) {
        try {
            return ResponseEntity.ok(PostService.update(post));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getAllPosts() {
        try {
            return ResponseEntity.ok(PostService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping(params = { "id" })
    public ResponseEntity getOnePost(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(PostService.getOne(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(PostService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
