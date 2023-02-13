package com.ironhack.finalProject.repositories.users;

import com.ironhack.finalProject.model.users.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminsRepository extends JpaRepository<Admins, Long> {
}