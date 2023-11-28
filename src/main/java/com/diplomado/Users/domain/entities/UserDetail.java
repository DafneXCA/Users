package com.diplomado.Users.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Entity
@Table(name = "user_detail")
@Validated
public class UserDetail {

    @Id
    @SequenceGenerator(name = "user_detail_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_detail_seq")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 1,max = 100)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 1,max = 100)
    @Column(name = "last_name")
    private  String lastName;

    @NotNull
    @Min(1)
    private Integer age;

    @NotNull
    @Column(name = "birth_day")
    private Date birthDay;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserDetail(String firstName, String lastName, Integer age, Date birthDay, User user) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDay = birthDay;
        this.user = user;
    }

    public UserDetail() {

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
