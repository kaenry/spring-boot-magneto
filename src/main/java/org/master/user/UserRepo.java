package org.master.user;


import org.master.common.ICommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author kaenry
 * @date 2016/6/17
 * UserRepo
 */
@Repository
public class UserRepo implements ICommonDao<User, Integer> {

    final static String INSERT_SQL = "insert into api_user (id, username, password, role) values (?, ?, ?, ?)";
    final static String UPDATE_SQL = "update api_user set username = ?, password = ?, role = ?) where id = ?";
    final static String DELETE_SQL = "delete from api_user where id = ?";
    final static String SELECT_SQL = "select id, username, password, role from api_user where id = ?";

    final RowMapper<User> beanMapper = new BeanPropertyRowMapper<>(User.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void save(User entity) {
        jdbcTemplate.update(INSERT_SQL, entity.getId(), entity.getUsername(), entity.getPassword(), entity.getRole());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update(DELETE_SQL, id);
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update(UPDATE_SQL, entity.getUsername(), entity.getPassword(), entity.getRole(), entity.getId());
    }

    @Override
    public User findById(Integer id) {
        return jdbcTemplate.queryForObject(SELECT_SQL, beanMapper, id);
    }

    @Override
    public List<User> findAll() {
        String query = "select id, username, password, role from api_user";
        return jdbcTemplate.query(query, new Object[]{}, beanMapper);
    }
}
