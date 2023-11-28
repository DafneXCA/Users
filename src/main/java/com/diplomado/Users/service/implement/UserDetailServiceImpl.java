package com.diplomado.Users.service.implement;

import com.diplomado.Users.domain.entities.UserDetail;
import com.diplomado.Users.dto.DetailedDTO;
import com.diplomado.Users.repositories.UserDetailRepository;
import com.diplomado.Users.service.UserDetailService;
import com.diplomado.Users.service.mapper.DetailedMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    private final UserDetailRepository userDetailRepository;
    private final DetailedMapper detailedMapper;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository, DetailedMapper detailedMapper) {
        this.userDetailRepository = userDetailRepository;
        this.detailedMapper = detailedMapper;
    }

    @Override
    public List<DetailedDTO> listUserDetail() {
        return userDetailRepository.findAll()
                .stream()
                .map(detailedMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<DetailedDTO> getUserDetailById(Long userDetailId) {
        return userDetailRepository.findById(userDetailId).map(detailedMapper::toDTO);
    }

    @Override
    public UserDetail save(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }

    @Override
    public UserDetail update(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }

    @Override
    public void delete(Long userDetailId) {
        userDetailRepository.deleteById(userDetailId);
    }
}
