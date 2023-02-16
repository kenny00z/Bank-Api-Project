package com.ironhack.finalProject.controller.impl;

import com.ironhack.finalProject.controller.dto.AccountDTO;
import com.ironhack.finalProject.model.accounts.*;
import com.ironhack.finalProject.model.users.ThirdParty;
import com.ironhack.finalProject.services.impl.AdminServiceImpl;
import com.ironhack.finalProject.services.interfaces.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class AdminControllerImpl implements AdminServiceInterface {

    @Autowired
    AdminServiceImpl adminService;


    @GetMapping("/accounts/checking")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> getAllCheckingAccounts() {
        return adminService.getAllCheckingAccounts();
    }

    @GetMapping("/accounts/student")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentChecking> getAllStudentAccounts(){
        return adminService.getAllStudentAccounts();
    }

    @GetMapping("/accounts/savings")
    @ResponseStatus(HttpStatus.OK)
    public List<Savings> getAllSavingAccounts() {
        return adminService.getAllSavingAccounts();
    }

    @GetMapping("/accounts/credit-card")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCard> getAllCreditCardAccounts() {
        return adminService.getAllCreditCardAccounts();
    }


    @GetMapping("/accounts/checking/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Checking> getAllCheckingAccountsById(@PathVariable Long id) {
        return adminService.getAllCheckingAccountsById(id);
    }
    @GetMapping("/accounts/student/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<StudentChecking> getAllStudentAccountsById(@PathVariable Long id) {
        return adminService.getAllStudentAccountsById(id);
    }
    @GetMapping("/accounts/savings/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Savings> getAllSavingAccountsById(@PathVariable Long id) {
        return adminService.getAllSavingAccountsById(id);
    }

    @GetMapping("/accounts/credit-card/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CreditCard> getAllCreditCardAccountsById(@PathVariable Long id) {
        return adminService.getAllCreditCardAccountsById(id);
    }
    @PostMapping("/admin/third-party")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty addThirdParty(@RequestBody ThirdParty thirdParty) {
        return adminService.addThirdParty(thirdParty);
    }

    @PostMapping("/admin/savings")
    @ResponseStatus(HttpStatus.CREATED)
    public Savings addSavings(@RequestBody Savings savings) {
        return adminService.addSavings(savings);
    }

    @PostMapping("/admin/checking")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addChecking(@RequestBody AccountDTO accountDto) {
        return adminService.addChecking(accountDto);
    }

    @PostMapping("/admin/credit-card")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard addCreditCard(@RequestBody CreditCard creditCard) {
        return adminService.addCreditCard(creditCard);
    }


    @DeleteMapping("/admin/student/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        adminService.deleteStudent(id);
    }

    @DeleteMapping("/admin/checking/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteChecking(@PathVariable Long id) {
        adminService.deleteChecking(id);
    }

    @DeleteMapping("/admin/credit-card/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCreditCard(@PathVariable Long id) {
        adminService.deleteCreditCard(id);
    }
    @DeleteMapping("/admin/third-party/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteThirdParty(@PathVariable Long id) {
        adminService.deleteThirdParty(id);
    }

    @DeleteMapping("/admin/savings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSavings(@PathVariable Long id) {
        adminService.deleteSavings(id);
    }


}
