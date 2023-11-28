package com.diplomado.Users.repositories;

import com.diplomado.Users.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
