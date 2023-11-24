package com.diplomado.Users.service;

import com.diplomado.Users.dto.RolDTO;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<RolDTO> listRols();
    Optional<RolDTO> getRolById(Integer rolId);
    RolDTO save(RolDTO rolDTO);
    void delete(Integer rolId);
    RolDTO update(RolDTO rolDTO);
}
