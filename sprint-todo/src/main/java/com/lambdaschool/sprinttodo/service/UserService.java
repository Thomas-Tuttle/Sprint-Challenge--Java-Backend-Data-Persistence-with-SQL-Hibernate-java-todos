package com.lambdaschool.sprinttodo.service;

import com.lambdaschool.sprinttodo.model.Todo;
import com.lambdaschool.sprinttodo.model.User;

import java.util.List;

public interface UserService
{

    List<User> findAll();

    User findUserById(long id);

    void delete(long id);

    User save(User user);

    User update(User user, long id);

    public User updateTodos(Todo todo, long id);

    User findUserByUsername(String username);
}
