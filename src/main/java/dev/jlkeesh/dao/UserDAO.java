package dev.jlkeesh.dao;

import dev.jlkeesh.domain.User;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDAO extends BaseDAO<User, String> {
    protected UserDAO(DataSource dataSource) {
        super(dataSource);
    }

    public boolean save(User user) {
        jdbcTemplate.update("insert into users (username, password) values(?,?);",
                user.getUsername(),
                user.getPassword());
        return true;
    }
    public User get(String id) {
        return jdbcTemplate.queryForObject("select * from users where id = ?;", mapper(), id);
    }
    public List<User> getAll() {
        return jdbcTemplate.query("select * from users;", mapper());
    }
}
