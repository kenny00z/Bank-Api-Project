package com.ironhack.finalProject.repositories.users;

import com.ironhack.finalProject.model.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}