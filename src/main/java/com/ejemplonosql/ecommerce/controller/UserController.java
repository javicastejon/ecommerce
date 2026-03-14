package com.ejemplonosql.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplonosql.ecommerce.domain.model.User;
import com.ejemplonosql.ecommerce.dto.UserRequest;
import com.ejemplonosql.ecommerce.dto.UserResponse;
import com.ejemplonosql.ecommerce.mapper.UserMapper;
import com.ejemplonosql.ecommerce.service.EventLogService;
import com.ejemplonosql.ecommerce.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EventLogService eventLogService;

    @Autowired
    private UserMapper mapper;



    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userCreationRequest) {
        User user = userService.createUser(mapper.toEntity(userCreationRequest));
        eventLogService.log("USER_CREATION","Creado nuevo usuario",user.getId());
        return mapper.toDTO(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.removeUser(id);
        eventLogService.log("USER_DELETED","Usuario creado correctamente",id);
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable long id) {
        User user = userService.getUserById(id).orElse(null);
        return mapper.toDTO(user);
    }

    @GetMapping("/getall")
    public List<User> getAllUser() {
        return userService.getAll();
    }

}

