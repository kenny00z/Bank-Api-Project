package com.ironhack.finalProject.services.impl;

import com.ironhack.finalProject.model.accounts.Account;
import com.ironhack.finalProject.model.accounts.Checking;
import com.ironhack.finalProject.model.accounts.StudentChecking;
import com.ironhack.finalProject.model.users.AccountHolder;
import com.ironhack.finalProject.repositories.accounts.AccountRepository;
import com.ironhack.finalProject.repositories.accounts.CheckingRepository;
import com.ironhack.finalProject.repositories.accounts.StudentCheckingRepository;
import com.ironhack.finalProject.repositories.users.AccountHoldersRepository;
import com.ironhack.finalProject.repositories.users.AdminRepository;
import com.ironhack.finalProject.services.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

@Service
public class AdminServiceImpl implements AdminService {

@Autowired
    AdminRepository adminrepository;
@Autowired
    AccountRepository accountRepository;
@Autowired
    AccountHoldersRepository accountHoldersRepository;
@Autowired
    StudentCheckingRepository studentCheckingRepository;
@Autowired
    CheckingRepository checkingRepository;


    public Account addChecking(Account account) {

        AccountHolder primaryOwner = accountHoldersRepository.findById(account.getPrimaryOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doesn't found"));
        AccountHolder secondaryOwner = accountHoldersRepository.findById(account.getSecondaryOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doesn't found"));
        LocalDate birthDate = primaryOwner.getBirthDate();
        LocalDate actualDate = LocalDate.now();
        Period period = Period.between(birthDate, actualDate);
        int age = period.getYears();

        Account newAccount;
        if (age <= 24) {
            newAccount = studentCheckingRepository.save(new StudentChecking(primaryOwner, secondaryOwner, account.getSecretKey()));
        } else {
            newAccount = checkingRepository.save(new Checking(primaryOwner, secondaryOwner, account.getSecretKey()));
        }
        return newAccount;
    }


    }








//    public static int getAge(LocalDate dateOfBirth){
//
//        Calendar today = Calendar.getInstance();
//        Calendar birthDate = Calendar.getInstance();
//
//        int age = 0;
//
//        birthDate.getTime(dateOfBirth);
//
//        if(birthDate.after(dateOfBirth)){
//            throw new IllegalArgumentException("Can't be born in the future");
//        }
//        age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
//
//        if( (birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) ||
//                (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))){
//            age--;
//        }else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH)) && (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH))){
//            age--;
//        }
//        return age;
//    }


