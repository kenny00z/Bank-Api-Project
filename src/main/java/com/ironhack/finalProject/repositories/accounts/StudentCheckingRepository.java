package com.ironhack.finalProject.repositories.accounts;

import com.ironhack.finalProject.model.accounts.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCheckingRepository extends JpaRepository<StudentChecking, Long> {
}