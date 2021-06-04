package com.muru.dcb.user.controller;

import com.muru.dcb.user.model.User;
import com.muru.dcb.user.service.UserService;
import com.muru.dcb.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService service){
        this.userService = service;
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Request for save User {}", user);
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Request for get User {} with Department", userId);
        return userService.getUserWithDepartment(userId);
    }
}
