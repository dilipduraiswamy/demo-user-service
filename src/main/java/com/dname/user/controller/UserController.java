package com.dname.user.controller;

import com.dname.user.custom.exceptions.EmptyInputException;
import com.dname.user.dto.CustomExceptionResponse;
import com.dname.user.entity.User;
import com.dname.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiOperation(value = "/user", tags = "User Details Controller")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "save new user", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "SUCCESS", response = User.class),
            @ApiResponse(code = 1001, message = "EMPTY INPUT EXCEPTION", response = CustomExceptionResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")}
    )
    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "update user by userid", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "SUCCESS", response = User.class),
            @ApiResponse(code = 1001, message = "EMPTY INPUT EXCEPTION", response = CustomExceptionResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 1005, message = "User Not Found Exception", response = CustomExceptionResponse.class)
    }
    )
    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.update(user), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "delete user by userid")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "SUCCESS", response = User.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 1005, message = "User Not Found Exception", response = CustomExceptionResponse.class)
    })
    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") Long userId) {
        userService.delete(userId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "find user by userid", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "SUCCESS", response = User.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 1001, message = "EMPTY INPUT EXCEPTION", response = CustomExceptionResponse.class),
            @ApiResponse(code = 1005, message = "User Not Found Exception", response = CustomExceptionResponse.class)
    }
    )
    @GetMapping("/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(userService.findByUserId(userId), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "find all users", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "SUCCESS", response = Iterable.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 1006, message = "Users Not Found EXCEPTION", response = CustomExceptionResponse.class),
    }
    )
    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.ACCEPTED);
    }

}
