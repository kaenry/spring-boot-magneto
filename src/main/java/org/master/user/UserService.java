package org.master.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by kaenry on 2016/6/17.
 * UserService
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User save(User entity) {
        return userRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

}
