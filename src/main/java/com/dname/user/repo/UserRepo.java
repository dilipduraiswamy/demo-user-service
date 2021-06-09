package com.dname.user.repo;

import com.dname.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {
    User findByUserId(Long userId);

    List<User> findAll();
}
