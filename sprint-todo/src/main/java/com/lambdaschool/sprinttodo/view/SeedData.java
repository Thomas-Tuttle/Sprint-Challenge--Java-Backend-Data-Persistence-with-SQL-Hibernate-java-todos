package com.lambdaschool.sprinttodo.view;

import com.lambdaschool.sprinttodo.model.Role;
import com.lambdaschool.sprinttodo.model.Todo;
import com.lambdaschool.sprinttodo.model.User;
import com.lambdaschool.sprinttodo.model.UserRoles;
import com.lambdaschool.sprinttodo.repository.RoleRepository;
import com.lambdaschool.sprinttodo.repository.ToDoRepository;
import com.lambdaschool.sprinttodo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    RoleRepository rolerepos;
    UserRepository userrepos;
    ToDoRepository todorepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos, ToDoRepository todorepos)
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
        this.todorepos = todorepos;
    }

    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));

        rolerepos.save(r1);
        rolerepos.save(r2);

        User u1 = new User("thomastuttle", "lambda", users);
        User u2 = new User("admin", "password", admins);


        // the date and time string should get converted to a datetime Java data type. This is done in the constructor!
        ArrayList<Todo> todos = new ArrayList<>();
        Todo t1 = new Todo("Learn Java", u1);
        Todo t2 = new Todo("Feed the turtles", u1);
        Todo t3 = new Todo("Finish java-orders-swagger", u1);
        Todo t4 = new Todo("Pass Sprint", u1);
        todos.addAll(Arrays.asList(t1, t2, t3, t4));

        u1.setTodos(todos);


        userrepos.save(u1);
        userrepos.save(u2);

    }
}
