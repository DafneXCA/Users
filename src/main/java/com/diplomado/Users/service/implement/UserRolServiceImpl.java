package com.diplomado.Users.service.implement;

import com.diplomado.Users.domain.entities.UserRol;
import com.diplomado.Users.dto.UserRolDTO;
import com.diplomado.Users.repositories.UserRolRepository;
import com.diplomado.Users.service.UserRolService;
import com.diplomado.Users.service.mapper.UserRolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRolServiceImpl implements UserRolService {

    private final UserRolRepository userRolRepository;
    private final UserRolMapper userRolMapper;

    public UserRolServiceImpl(UserRolRepository userRolRepository, UserRolMapper userRolMapper) {
        this.userRolRepository = userRolRepository;
        this.userRolMapper = userRolMapper;
    }

    @Override
    public List<UserRolDTO> listUserRol() {
        return userRolRepository.findAll()
                .stream()
                .map(userRolMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<UserRolDTO> getUserRolById(Integer userRolId) {
        return userRolRepository.findById(userRolId).map(userRolMapper::toDTO);
    }

    @Override
    public UserRolDTO save(UserRol userRol) {
        return userRolMapper.toDTO(userRolRepository.save(userRol)) ;
    }

    @Override
    public UserRolDTO  update(UserRol userRol) {

        return userRolMapper.toDTO(userRolRepository.save(userRol));
    }
}
