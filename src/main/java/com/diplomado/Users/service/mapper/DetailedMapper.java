package com.diplomado.Users.service.mapper;

import com.diplomado.Users.domain.entities.UserDetail;
import com.diplomado.Users.dto.DetailedDTO;
import org.springframework.stereotype.Component;

@Component
public class DetailedMapper implements CustomMapper<DetailedDTO, UserDetail>{
    @Override
    public DetailedDTO toDTO(UserDetail userDetail) {
        DetailedDTO detailedDTO=new DetailedDTO();
        detailedDTO.setId(userDetail.getId());
        detailedDTO.setFirstName(userDetail.getFirstName());
        detailedDTO.setLastName(userDetail.getLastName());
        detailedDTO.setAge(userDetail.getAge());
        detailedDTO.setBirthDay(userDetail.getBirthDay());

        return detailedDTO;
    }

    @Override
    public UserDetail toEntity(DetailedDTO detailedDTO) {
        UserDetail userDetail=new UserDetail();
        userDetail.setId(detailedDTO.getId());
        userDetail.setFirstName(detailedDTO.getFirstName());
        userDetail.setLastName(detailedDTO.getLastName());
        userDetail.setAge(detailedDTO.getAge());
        userDetail.setBirthDay(detailedDTO.getBirthDay());

        return userDetail;
    }
}
