package com.lambdaschool.sprinttodo.repos;

import com.lambdaschool.sprinttodo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
