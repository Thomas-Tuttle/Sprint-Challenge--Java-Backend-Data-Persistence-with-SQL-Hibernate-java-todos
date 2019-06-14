package com.lambdaschool.sprinttodo.repository;

import com.lambdaschool.sprinttodo.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<Todo, Long>
{
}
