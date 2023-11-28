package com.diplomado.Users.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_rol")
@Validated
public class UserRol {

    @Id
    @SequenceGenerator(name = "user_rol_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_rol_seq")
    private Integer id;

    private Boolean active;


    @Column(name = "created_at",columnDefinition = "timestamp")
    private LocalDateTime createdAt;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="rol_id")
    private Rol rol;

    public UserRol(Boolean active,LocalDateTime createdAt, User user, Rol rol) {
        this.active = active;
        this.user = user;
        this.rol = rol;
        this.createdAt=createdAt;
    }

    public UserRol() {

    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
