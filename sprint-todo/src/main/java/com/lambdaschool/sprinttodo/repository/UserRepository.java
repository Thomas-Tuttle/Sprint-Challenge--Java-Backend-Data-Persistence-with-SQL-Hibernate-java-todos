package com.lambdaschool.sprinttodo.repository;

import com.lambdaschool.sprinttodo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}

