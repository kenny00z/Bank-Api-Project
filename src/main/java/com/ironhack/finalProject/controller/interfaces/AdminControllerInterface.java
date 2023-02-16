package com.ironhack.finalProject.controller.interfaces;

import com.ironhack.finalProject.controller.dto.AccountDTO;
import com.ironhack.finalProject.model.accounts.*;
import com.ironhack.finalProject.model.users.ThirdParty;

import java.util.List;
import java.util.Optional;

public interface AdminControllerInterface {
    List<Checking> getAllCheckingAccounts();

    List<StudentChecking> getAllStudentsAccounts();

    List<Savings> getAllSavingAccounts();

    List<CreditCard> getAllCreditCardAccounts();

    Optional<Checking> getAllCheckingAccountsById(Long id);
    Optional<StudentChecking> getAllStudentsAccountsById(Long id);
    Optional<Savings> getAllSavingAccountsById(Long id);
    Optional<CreditCard> getAllCreditCardAccountsById(Long id);

    ThirdParty addThirdParty(ThirdParty thirdParty);
    Account addChecking(AccountDTO accountDto);
    CreditCard addCreditCard(CreditCard creditCard);
    Savings addSavings(Savings savings);
    //StudentChecking addStudent(StudentChecking studentChecking);

    void deleteStudent(Long id);

    void deleteChecking(Long id);

    void deleteCreditCard(Long id);

    void deleteSavings(Long id);

    void deleteThirdParty(Long id);

}
