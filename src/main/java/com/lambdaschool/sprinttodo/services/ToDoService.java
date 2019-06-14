package com.lambdaschool.sprinttodo.services;

import com.lambdaschool.sprinttodo.models.Todo;

import java.util.ArrayList;
import java.util.List;

public interface ToDoService
{
    ArrayList<Todo> findAll();

    Todo findToDoById(long id);

    List<Todo> findByUserName(String username);

    void delete(long id);

    Todo save(Todo todo);

    Todo update(Todo todo, long id);

}
