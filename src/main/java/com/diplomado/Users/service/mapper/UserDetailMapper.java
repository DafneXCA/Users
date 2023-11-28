package com.diplomado.Users.service.mapper;

import com.diplomado.Users.domain.entities.User;
import com.diplomado.Users.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDetailMapper implements CustomMapper<UserDTO, User>{

    private final DetailedMapper detailedMapper;

    public UserDetailMapper(DetailedMapper detailedMapper) {
        this.detailedMapper = detailedMapper;
    }
    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO=new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setCreatedAt(user.getCreatedAt());

        if(user.getUserDetail()!=null) {
            userDTO.setUserDetail(detailedMapper.toDTO(user.getUserDetail()));
        }
        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        User user=new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setCreatedAt(userDTO.getCreatedAt());

        if(userDTO.getUserDetail()!=null) {
            user.setUserDetail(detailedMapper.toEntity(userDTO.getUserDetail()));
        }

        return user;
    }
}
