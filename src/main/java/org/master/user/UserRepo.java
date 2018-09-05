package org.master.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kaenry on 2016/6/17.
 * UserRepo
 */
@Repository
public interface UserRepo extends CrudRepository<User, Long> {
}
