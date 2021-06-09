package com.dname.user.service;

import com.dname.user.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);

    User findByUserId(Long userId);

    List<User> findAll();

    User update(User user);

    void delete(Long userId);
}
