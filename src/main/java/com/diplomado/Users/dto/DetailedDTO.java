package com.diplomado.Users.dto;

import com.diplomado.Users.domain.entities.UserDetail;
import com.diplomado.Users.service.mapper.CustomMapper;
import jakarta.persistence.Column;

import java.util.Date;

public class DetailedDTO {
    private Long id;
    private String firstName;
    private  String lastName;
    private Integer age;
    private Date birthDay;

    public DetailedDTO() {
    }

    public DetailedDTO(Long id, String firstName, String lastName, Integer age, Date birthDay) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDay = birthDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
