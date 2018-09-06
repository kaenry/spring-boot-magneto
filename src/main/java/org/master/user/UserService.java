package org.master.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 *
 * @author kaenry
 * @date 2016/6/17
 * UserService
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;

    @Transactional
    @Override
    public void save(User entity) {
        userRepo.save(entity);
    }

    @Override
    public void delete(Integer id) {
        userRepo.delete(id);
    }

    @Override
    public User findById(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public List<User> findAll() {

        Iterable<User> users = userRepo.findAll();
        return StreamSupport.stream(users.spliterator(), false).collect(Collectors.toList());
    }

}
