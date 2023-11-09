package com.codewithsowmiya.demo.Repositary;

import com.codewithsowmiya.demo.Model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepositary {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Todo> findAll() {
        return jdbcTemplate.query("SELECT *FROM TodoItem", new BeanPropertyRowMapper<>(Todo.class));
    }

    public List<Todo> insert(Todo todo) {
        jdbcTemplate.update("INSERT INTO TodoItem(Item) VALUES(?)", new Object[]{todo.getItem()});
        return findAll();
    }

    public List<Todo> update(Todo todo) {
        jdbcTemplate.update("UPDATE TodoItem SET Item=? WHERE id=?",new Object[]{todo.getItem(),todo.getId()});
        return findAll();
    }

    public List<Todo> delete(int id) {
        jdbcTemplate.update("DELETE FROM TodoItem WHERE id=?;",new Object[]{id});
        return findAll();
    }
}
