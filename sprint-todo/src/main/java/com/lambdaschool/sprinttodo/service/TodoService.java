package com.lambdaschool.sprinttodo.service;

import com.lambdaschool.sprinttodo.model.Todo;

public interface TodoService
{
    Todo findById(Long id);

    Todo save(Todo todo);

    Todo update(Todo todo);

    void delete(Long id);
}
