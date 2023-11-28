package com.diplomado.Users.service.implement;

import com.diplomado.Users.domain.entities.User;
import com.diplomado.Users.domain.entities.UserDetail;
import com.diplomado.Users.domain.entities.UserRol;
import com.diplomado.Users.dto.UserDTO;
import com.diplomado.Users.repositories.UserDetailRepository;
import com.diplomado.Users.repositories.UserRepository;
import com.diplomado.Users.repositories.UserRolRepository;
import com.diplomado.Users.service.UserService;
import com.diplomado.Users.service.mapper.UserDetailMapper;
import com.diplomado.Users.service.mapper.UserMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final UserDetailMapper userDetailMapper;

    private final UserDetailRepository userDetailRepository;
    private final UserRolRepository userRolRepository;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, UserDetailMapper userDetailMapper, UserDetailRepository userDetailRepository, UserRolRepository userRolRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userDetailMapper = userDetailMapper;
        this.userDetailRepository = userDetailRepository;
        this.userRolRepository = userRolRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> listUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDTO> getUserById(Long userId) {
        return userRepository.findById(userId).map(userDetailMapper::toDTO);
    }

    @Override
    public UserDTO save(User user) {
        User userFromDb=userRepository.save(user);

        if (user.getUserDetail()!=null){
            UserDetail userDetail=user.getUserDetail();
            userDetail.setUser(userFromDb);
            userDetailRepository.save(userDetail);
        }

        if (user.getUserRolList()!=null){
            for(UserRol userRol : user.getUserRolList()){
                userRol.setCreatedAt(LocalDateTime.now());
                userRol.setUser(userFromDb);
                userRol.setActive(true);
            }
            userRolRepository.saveAll(user.getUserRolList());
        }

        return userMapper.toDTO(userFromDb);
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDTO update(User user) {
        User userFromDB= userRepository.findById(user.getId()).orElseThrow();

        user.setPassword(userFromDB.getPassword());
        User userFromDbEdit=userRepository.save(user);

        if (user.getUserDetail()!=null){
            UserDetail userDetail=user.getUserDetail();

            userDetail.setUser(userFromDbEdit);
            userDetailRepository.save(userDetail);
        }

        if (user.getUserRolList()!=null){
            for(UserRol userRol : user.getUserRolList()){
                userRol.setUser(userFromDbEdit);
                userRol.setActive(true);
            }
            userRolRepository.saveAll(user.getUserRolList());
        }

        return userMapper.toDTO(userFromDbEdit);

       // return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> listUsersDetailed() {
        return userRepository.findAll()
                .stream()
                .map(userDetailMapper::toDTO).collect(Collectors.toList());
    }
}
