package com.lambdaschool.sprinttodo.controller;

import com.lambdaschool.sprinttodo.exceptions.ResourceNotFoundException;
import com.lambdaschool.sprinttodo.model.Todo;
import com.lambdaschool.sprinttodo.model.User;
import com.lambdaschool.sprinttodo.service.TodoService;
import com.lambdaschool.sprinttodo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class controller
{
    @Autowired
    UserService userService;
    @Autowired
    TodoService todoService;

    @GetMapping("/test")
    public ResponseEntity<?> doTest()
    {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

//      GET localhost:2019/users/mine
    @GetMapping(value = "/users/mine",
            produces = "application/json")
    public ResponseEntity<?> getUserAndTodos()
    {
        // get authenticated users name
        String uname;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null)
        {
            return new ResponseEntity<>("Could not authenticate", HttpStatus.OK);
        }
        uname = authentication.getName();

        // use name
        User user = userService.findUserByUsername(uname);
        if (user == null)
        {
            throw new ResourceNotFoundException("Could not find user");
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//      POST localhost:2019/users
    @PostMapping(value = "/users",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<?> addUser(
            @Valid
            @RequestBody
                    User user)
    {
        User rtn = userService.save(user);
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

//      DELETE localhost:2019/users/userid/{userid}
    @DeleteMapping(value = "/users/userid/{userid}",
            consumes = "application/json")
    public ResponseEntity<?> deleteUserById(
            @PathVariable
                    Long userid)
    {
        userService.delete(userid);
        return new ResponseEntity<>("Successfully deleted user with id: " + userid, HttpStatus.OK);
    }


//      PUT localhost:2019/todos/todoid/{todoid}
    @PutMapping(value = "/todos/todoid/{todoid}",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<?> updateTodo(
            @PathVariable
                    long todoid,
            @Valid
            @RequestBody
                    Todo todo)
    {
        Todo toUpdate = todoService.findById(todoid);
        if (todo.getDesc() != null)
        {
            toUpdate.setDesc(todo.getDesc());
        }
        return new ResponseEntity<>(todoService.update(toUpdate), HttpStatus.OK);

    }


//      POST localhost:2019/users/todo/{userid}

    @PostMapping(value = "/users/todo/{userid}",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<?> addTodoToUser(
            @PathVariable
                    long userid,
            @Valid
            @RequestBody
                    Todo todo)
    {
        return new ResponseEntity<>(userService.updateTodos(todo, userid), HttpStatus.OK);
    }


}
