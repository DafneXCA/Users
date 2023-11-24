package com.diplomado.Users.repositories;

import com.diplomado.Users.domain.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RolRepository extends JpaRepository<Rol,Integer> {
}
