package org.master.controller;

import org.master.common.RestResult;
import org.master.common.RestResultGenerator;
import org.master.common.Utils;
import org.master.user.IUserService;
import org.master.user.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    /**
     * get all user, GET
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public RestResult<List<User>> all() {
        List<User> all = userService.findAll();
        return RestResultGenerator.genSuccessResult(all);
    }

    /**
     * add single user
     * @param user username, password
     * @return RestResult
     * @throws Exception valid check
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public RestResult<User> save(@Valid @RequestBody User user) throws Exception {
        User save = userService.save(user);
        return RestResultGenerator.genSuccessResult(save);
    }

    /**
     * get single user by id, GET /id
     * @param id user id
     * @return RestResult<User>
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RestResult<User> get(@PathVariable Long id) throws Exception {
        User user = userService.findById(id);
        return RestResultGenerator.genSuccessResult(user);
    }

    /**
     * delete user by id
     * @param id user id
     * @return success
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RestResult delete(@PathVariable Long id) throws Exception {
        userService.delete(id);
        return RestResultGenerator.genSuccessResult();
    }

    /**
     * update user for all props
     * @param id update user id
     * @param newUser new props
     * @return updated User
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public RestResult<User> updateAll(@PathVariable Long id, @Valid @RequestBody User newUser) throws Exception {
        User user = userService.findById(id);
        // copy all new user props to user except id
        BeanUtils.copyProperties(newUser, user, "id");
        user = userService.save(user);
        return RestResultGenerator.genSuccessResult(user);
    }

    /**
     * update user for some props
     * @param id update user id
     * @param newUser some props
     * @return updated user
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public RestResult<User> update(@PathVariable Long id, @Valid @RequestBody User newUser) throws Exception {
        User user = userService.findById(id);
        // copy all new user props to user except null props
        BeanUtils.copyProperties(newUser, user, Utils.getNullPropertyNames(newUser));
        user = userService.save(user);
        return RestResultGenerator.genSuccessResult(user);
    }
}
