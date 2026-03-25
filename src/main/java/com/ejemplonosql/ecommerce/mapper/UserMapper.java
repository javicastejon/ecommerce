package com.ejemplonosql.ecommerce.mapper;

import org.springframework.stereotype.Component;


import com.ejemplonosql.ecommerce.domain.model.User;
import com.ejemplonosql.ecommerce.dto.UserRequest;
import com.ejemplonosql.ecommerce.dto.UserResponse;

@Component
public class UserMapper {
    public UserResponse toDTO(User user){
        UserResponse ucresponse = new UserResponse();
        ucresponse.setId(user.getId());
        ucresponse.setName(user.getName());
        ucresponse.setEmail(user.getEmail());
        ucresponse.setOrders(user.getOrders());
        return ucresponse;
    }

    public User toEntity(UserRequest dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setOrders(dto.getOrders());
        return user;
    }
}


