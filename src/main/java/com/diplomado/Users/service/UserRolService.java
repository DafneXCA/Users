package com.diplomado.Users.service;

import com.diplomado.Users.domain.entities.UserRol;
import com.diplomado.Users.dto.DetailedDTO;
import com.diplomado.Users.dto.UserRolDTO;

import java.util.List;
import java.util.Optional;

public interface UserRolService {

    List<UserRolDTO> listUserRol();

    Optional<UserRolDTO> getUserRolById(Integer userRolId);

    UserRolDTO save(UserRol userRol);

    UserRolDTO update(UserRol userRol);
}
