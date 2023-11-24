package com.diplomado.Users.service.mapper;

import com.diplomado.Users.domain.entities.Rol;
import com.diplomado.Users.dto.RolDTO;
import org.springframework.stereotype.Component;

@Component
public class RolMapper implements CustomMapper<RolDTO, Rol>{

    @Override
    public RolDTO toDTO(Rol rol) {
        RolDTO rolDTO = new RolDTO();
        rolDTO.setId(rol.getId());
        rolDTO.setName(rol.getName());

        return rolDTO;
    }

    @Override
    public Rol toEntity(RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setId(rolDTO.getId());
        rol.setName(rolDTO.getName());

        return rol;
    }
}
