package com.diplomado.Users.service.implement;

import com.diplomado.Users.domain.entities.Rol;
import com.diplomado.Users.dto.RolDTO;
import com.diplomado.Users.repositories.RolRepository;
import com.diplomado.Users.service.RolService;
import com.diplomado.Users.service.mapper.RolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements RolService {
    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    public RolServiceImpl(RolRepository rolRepository,RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper=rolMapper;
    }


    @Override
    public List<RolDTO> listRols() {
        return rolRepository.findAll()
                .stream()
                .map(rolMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<RolDTO> getRolById(Integer rolId) {

        return rolRepository.findById(rolId).map(rolMapper::toDTO);
    }

    @Override
    public RolDTO save(RolDTO rolDTO) {
        return rolMapper.toDTO(rolRepository.save(rolMapper.toEntity(rolDTO)));
    }

    @Override
    public void delete(Integer rolId) {
        rolRepository.deleteById(rolId);
    }

    @Override
    public RolDTO update(RolDTO rolDTO) {

        return rolMapper.toDTO(rolRepository.save(rolMapper.toEntity(rolDTO)));
    }
}
