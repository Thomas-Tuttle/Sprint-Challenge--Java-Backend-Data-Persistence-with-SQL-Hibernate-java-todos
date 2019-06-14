package com.lambdaschool.sprinttodo.repository;

import com.lambdaschool.sprinttodo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
