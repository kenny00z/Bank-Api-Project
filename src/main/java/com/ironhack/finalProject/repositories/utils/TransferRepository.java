package com.ironhack.finalProject.repositories.utils;

import com.ironhack.finalProject.model.utils.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
