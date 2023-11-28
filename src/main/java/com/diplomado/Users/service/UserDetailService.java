package com.diplomado.Users.service;

import com.diplomado.Users.domain.entities.UserDetail;
import com.diplomado.Users.dto.DetailedDTO;
import com.diplomado.Users.dto.RolDTO;


import java.util.List;
import java.util.Optional;

public interface UserDetailService {
    List<DetailedDTO> listUserDetail();
    Optional<DetailedDTO> getUserDetailById(Long userDetailId);
    UserDetail save(UserDetail userDetail);
    UserDetail update(UserDetail userDetail);
    void delete(Long userDetailId);
}
