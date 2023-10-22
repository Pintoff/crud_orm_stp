package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByLogin(user.getLogin()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем существует");
        }
        return userRepo.save(user);
    }

    public List<User> findAll() {
        return userRepo.findAll().stream().map(User::toModel).collect(Collectors.toList());
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public UserEntity update(UserEntity user) {
        
        return userRepo.save(user);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
