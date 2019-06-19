package com.lambdaschool.sprinttodo.service;

import com.lambdaschool.sprinttodo.models.Todo;
import com.lambdaschool.sprinttodo.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserById(long id);

    void delete(long id);

    User save(User user);

    User update(User user, long id);

    Todo addTodo(Todo todo, long id);
}
