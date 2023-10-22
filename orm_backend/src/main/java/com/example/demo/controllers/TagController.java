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

import com.example.demo.entity.TagEntity;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.service.TagService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tags")

public class TagController {
    @Autowired
    private TagService TagService;

    @PostMapping
    public ResponseEntity addTag(@RequestBody TagEntity tag) {
        try {
            return ResponseEntity.ok(TagService.update(tag));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PatchMapping
    public ResponseEntity updateTag(@RequestBody TagEntity tag) {
        try {
            return ResponseEntity.ok(TagService.update(tag));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getAllTags() {
        try {
            return ResponseEntity.ok(TagService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка" + e);
        }
    }

    @GetMapping(params = { "id" })
    public ResponseEntity getOneTag(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(TagService.getOne(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTag(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(TagService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
