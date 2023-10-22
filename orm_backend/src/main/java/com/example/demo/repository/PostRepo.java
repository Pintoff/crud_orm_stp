package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PostEntity;

@Repository

public interface PostRepo extends JpaRepository<PostEntity, Long> {

}
