package com.ironhack.finalProject.repositories.users;

import com.ironhack.finalProject.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}