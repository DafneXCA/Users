package com.diplomado.Users.service;

import com.diplomado.Users.domain.entities.User;
import com.diplomado.Users.dto.RolDTO;
import com.diplomado.Users.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> listUsers();
    Optional<UserDTO> getUserById(Long userId);
    UserDTO save(User user);
    void delete(Long userId);
    UserDTO update(User user);
    List<UserDTO> listUsersDetailed();
}
