package com.example.demo.model;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entity.PostEntity;

public class Post {

    private Long id;
    private Long user_id;

    private String text;
    private String title;

    private List<Tag> tags;

    public static Post toModel(PostEntity entity) {

        Post model = new Post();
        model.setId(entity.getId());
        model.setText(entity.getText());
        model.setTitle(entity.getTitle());
        if (entity.getUser() != null) {
            model.setUser_id(entity.getUser().getId());
        }
        model.setTags(entity.getTags().stream().map(Tag::toModel).collect(Collectors.toList()));
        return model;
    }

    public Post() {
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
