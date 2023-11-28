package com.diplomado.Users.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Validated
public class User {
    @Id
    @SequenceGenerator(name = "user_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 1,max = 150)
    private String username;


    private String password;
    @NotNull
    @Size(min = 1,max = 150)
    @Email
    private String email;

    @NotNull
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private  UserDetail userDetail;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<UserRol> userRolList;


    @Column(name = "created_at",columnDefinition = "timestamp")
    private LocalDateTime createdAt;
    public User(String username,LocalDateTime createdAt, String password, String email,List<UserRol> userRolList,UserDetail userDetail) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt=createdAt;
        this.userRolList=userRolList;
        this.userDetail=userDetail;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public List<UserRol> getUserRolList() {
        return userRolList;
    }

    public void setUserRolList(List<UserRol> userRolList) {
        this.userRolList = userRolList;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
