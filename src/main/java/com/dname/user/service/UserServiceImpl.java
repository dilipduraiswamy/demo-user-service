package com.dname.user.service;

import com.dname.user.custom.exceptions.EmptyInputException;
import com.dname.user.custom.exceptions.NoDataException;
import com.dname.user.custom.exceptions.UserNotFoundException;
import com.dname.user.entity.User;
import com.dname.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public User save(User user) {
        if (user.getEmailId().isEmpty() || user.getFirstName().isEmpty()) {
            throw new EmptyInputException(1001, "Empty Input Exception");
        }
        return userRepo.save(user);
    }

    @Override
    public User findByUserId(Long userId) {
        User user = userRepo.findByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException(1005, "User Not Found");
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users=userRepo.findAll();
        if(users.isEmpty()){
            throw new NoDataException(1006,"No Data Found");
        }
        return users;
    }

    @Override
    public User update(User user) {
        if(user.getUserId()==null||user.getUserId()==0)
        {
            throw new EmptyInputException(1001, "UserId Is Empty");
        }
        if(findByUserId(user.getUserId())==null)
        {
            throw new UserNotFoundException(1005, "User Not Found");
        }

        return userRepo.save(user);
    }

    @Override
    public void delete(Long userId) {
        Optional<User> userDetails = userRepo.findById(userId);
        if (userDetails.isPresent()) {
            userRepo.delete(userDetails.get());
        } else {
           throw new UserNotFoundException(1005,"User Not Found");
        }
    }
}
