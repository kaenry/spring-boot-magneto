package org.master.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by kaenry on 2016/6/17.
 * UserController
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id){

        return userService.findById(id);
    }
}
