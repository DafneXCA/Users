package com.diplomado.Users.service.mapper;

import com.diplomado.Users.domain.entities.User;
import com.diplomado.Users.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements CustomMapper<UserDTO, User>{



    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO=new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setCreatedAt(user.getCreatedAt());


        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        User user=new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setCreatedAt(userDTO.getCreatedAt());


        return user;
    }
}
