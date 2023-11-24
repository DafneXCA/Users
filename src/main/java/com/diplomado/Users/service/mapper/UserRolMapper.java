package com.diplomado.Users.service.mapper;

import com.diplomado.Users.domain.entities.UserRol;
import com.diplomado.Users.dto.UserRolDTO;
import org.springframework.stereotype.Component;

@Component
public class UserRolMapper implements CustomMapper<UserRolDTO, UserRol>{

    private final RolMapper rolMapper;
    private final UserMapper userMapper;

    public UserRolMapper(RolMapper rolMapper, UserMapper userMapper) {
        this.rolMapper = rolMapper;
        this.userMapper = userMapper;
    }


    @Override
    public UserRolDTO toDTO(UserRol userRol) {
        UserRolDTO userRolDTO=new UserRolDTO();
        userRolDTO.setId(userRol.getId());
        userRolDTO.setActive(userRol.getActive());
        userRolDTO.setRol(rolMapper.toDTO(userRol.getRol()));
        userRolDTO.setUser(userMapper.toDTO(userRol.getUser()));

        return userRolDTO;
    }

    @Override
    public UserRol toEntity(UserRolDTO userRolDTO) {
        UserRol userRol=new UserRol();
        userRol.setId(userRolDTO.getId());
        userRol.setActive(userRolDTO.getActive());
        userRol.setRol(rolMapper.toEntity(userRolDTO.getRol()));
        userRol.setUser(userMapper.toEntity(userRolDTO.getUser()));

        return userRol;
    }
}
