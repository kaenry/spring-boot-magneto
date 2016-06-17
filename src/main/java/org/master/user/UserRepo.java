package org.master.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by kaenry on 2016/6/17.
 * UserRepo
 */
public interface UserRepo extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
