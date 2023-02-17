package com.ironhack.finalProject.repositories.users;

import com.ironhack.finalProject.model.users.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}