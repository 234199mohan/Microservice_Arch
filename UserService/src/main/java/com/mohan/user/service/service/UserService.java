package com.mohan.user.service.service;

import com.mohan.user.service.entities.User;

import java.util.List;

public interface UserService {

    User saveUser (User user);

    <T> T getUser(T userId);

    List<?> getAllUser();

    <T>List<T>customizeUser();
}
