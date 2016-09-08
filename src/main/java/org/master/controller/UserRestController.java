package org.master.controller;

import org.master.user.IUserService;
import org.master.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kaenry on 2016/9/8.
 * UserRestController
 */
@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    IUserService userService;

    @RequestMapping("")
    public List<User> all() {

        return userService.findAll();
    }
}
