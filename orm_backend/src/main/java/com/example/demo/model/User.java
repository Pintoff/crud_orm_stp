package com.example.demo.model;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entity.UserEntity;

public class User {

    private Long id;

    private String login;
    private String country;

    private String sex;

    private List<Post> posts;

    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setLogin(entity.getLogin());
        model.setCountry(entity.getCountry());
        model.setSex(entity.getSex());
        model.setPosts(entity.getPosts().stream().map(Post::toModel).collect(Collectors.toList()));
        return model;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}
