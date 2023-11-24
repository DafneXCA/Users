package com.diplomado.Users.service.mapper;

public interface CustomMapper <DTO,E>{
    DTO toDTO(E e);
    E toEntity(DTO dto);
}
