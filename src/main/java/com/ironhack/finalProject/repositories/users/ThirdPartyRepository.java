package com.ironhack.finalProject.repositories.users;

import com.ironhack.finalProject.model.users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThirdPartyRepository extends JpaRepository<ThirdParty, Long> {
}