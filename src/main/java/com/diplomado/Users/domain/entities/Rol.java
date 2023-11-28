package com.diplomado.Users.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Entity
@Table(name = "rol")
@Validated
public class Rol {
    @Id
    @SequenceGenerator(name = "rol_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "rol_seq")
    private Integer id;

    @NotNull
    @Size(min = 1,max = 100)
    private String name;

    @OneToMany(mappedBy = "rol",cascade = CascadeType.ALL)
    private List<UserRol> userRolList;

    public Rol(String name) {

        this.name = name;
    }

    public Rol() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
