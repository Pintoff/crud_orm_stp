package com.example.demo.model;

import com.example.demo.entity.TagEntity;

public class Tag {

    private Long id;

    private String name;

    private Long post_id;

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public static Tag toModel(TagEntity entity) {
        Tag model = new Tag();
        model.setId(entity.getId());
        model.setName(entity.getName());
        if (entity.getPost() != null) {
            model.setPost_id(entity.getPost().getId());
        }

        return model;
    }

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
