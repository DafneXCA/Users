package com.diplomado.Users.dto;


import java.time.LocalDateTime;

public class UserRolDTO {
    private Integer id;

    private Boolean active;

    private LocalDateTime createdAt;

    private UserDTO user;

    private RolDTO rol;

    public UserRolDTO(Integer id, Boolean active, LocalDateTime createdAt, UserDTO user, RolDTO rol) {
        this.id = id;
        this.active = active;
        this.createdAt = createdAt;
        this.user = user;
        this.rol = rol;
    }

    public UserRolDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public RolDTO getRol() {
        return rol;
    }

    public void setRol(RolDTO rol) {
        this.rol = rol;
    }
}
