package dev.jlkeesh.dao;


import dev.jlkeesh.domain.Blog;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BlogDAO extends BaseDAO<Blog, String> {

    protected BlogDAO(DataSource dataSource) {
        super(dataSource);
    }

    public boolean save(Blog blog) {
        jdbcTemplate.update("insert into blog (title, overview, content) values(?,?,?);",
                blog.getTitle(),
                blog.getOverview(),
                blog.getContent());
        return true;
    }

    public Blog get(String id) {
        return jdbcTemplate.queryForObject("select * from blog where id = ?;", mapper(), id);
    }

    public List<Blog> getAll() {
        return jdbcTemplate.query("select * from blog", mapper());
    }

    public boolean update(Blog blog) {
        jdbcTemplate.update("update blog set title = ?, overview = ?, content = ? where id = ?;",
                blog.getTitle(),
                blog.getOverview(),
                blog.getContent(),
                blog.getId());
        return true;
    }

    public boolean delete(Blog blog) {
        jdbcTemplate.update("delete from blog where id = ?;", blog.getId());
        return true;
    }



}
