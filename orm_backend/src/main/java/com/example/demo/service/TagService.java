package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TagEntity;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.Tag;
import com.example.demo.repository.TagRepo;

@Service
public class TagService {

    @Autowired
    private TagRepo tagRepo;

    public List<Tag> findAll() {
        return tagRepo.findAll().stream().map(Tag::toModel).collect(Collectors.toList());
    }

    public Tag getOne(Long id) throws EntityNotFoundException {
        TagEntity tag = tagRepo.findById(id).get();
        if (tag == null) {
            throw new EntityNotFoundException("Тэг не найден");
        }
        return Tag.toModel(tag);
    }

    public TagEntity update(TagEntity tag) {

        return tagRepo.save(tag);
    }

    public Long delete(Long id) {
        tagRepo.deleteById(id);
        return id;
    }
}
