package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PostEntity;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepo;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    public List<Post> findAll() {
        return postRepo.findAll().stream().map(Post::toModel).collect(Collectors.toList());
    }

    public Post getOne(Long id) throws EntityNotFoundException {
        PostEntity post = postRepo.findById(id).get();
        if (post == null) {
            throw new EntityNotFoundException("Пост не найден");
        }
        return Post.toModel(post);
    }

    public PostEntity update(PostEntity post) {

        return postRepo.save(post);
    }

    public Long delete(Long id) {
        postRepo.deleteById(id);
        return id;
    }
}
