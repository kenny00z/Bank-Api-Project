package com.ironhack.finalProject.services.impl;

import com.ironhack.finalProject.controller.dto.AccountDTO;
import com.ironhack.finalProject.controller.dto.BalanceDTO;
import com.ironhack.finalProject.controller.dto.TransferDTO;
import com.ironhack.finalProject.model.utils.Transfer;
import com.ironhack.finalProject.model.accounts.*;
import com.ironhack.finalProject.model.users.AccountHolder;
import com.ironhack.finalProject.model.users.ThirdParty;
import com.ironhack.finalProject.model.utils.Money;
import com.ironhack.finalProject.repositories.accounts.*;
import com.ironhack.finalProject.repositories.users.AccountHoldersRepository;
import com.ironhack.finalProject.repositories.users.ThirdPartyRepository;
import com.ironhack.finalProject.repositories.utils.TransferRepository;
import com.ironhack.finalProject.services.interfaces.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminServiceInterface {

    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    AccountHoldersRepository accountHoldersRepository;
    @Autowired
    StudentCheckingRepository studentCheckingRepository;
    @Autowired
    SavingRepository savingRepository;
    @Autowired
    CreditCardRepository creditCardRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransferRepository transferRepository;




    public List<Checking> getAllCheckingAccounts (){

        return checkingRepository.findAll();
    }


    public List<StudentChecking> getAllStudentAccounts() {
        return studentCheckingRepository.findAll();
    }

    public List<Savings> getAllSavingAccounts (){

        return savingRepository.findAll();
    }

    public List<CreditCard> getAllCreditCardAccounts (){

        return creditCardRepository.findAll();
    }



    public Optional<Checking> getAllCheckingAccountsById(Long id) {
        return checkingRepository.findById(id);
    }

    public Optional<StudentChecking> getAllStudentAccountsById(Long id) {
        return studentCheckingRepository.findById(id);
    }


    public Optional<Savings> getAllSavingAccountsById(Long id) {
        return savingRepository.findById(id);
    }
    public Optional<CreditCard> getAllCreditCardAccountsById(Long id){

        return creditCardRepository.findById(id);
    }


    public Account addChecking(AccountDTO accountDto) {

        AccountHolder primaryOwner = accountHoldersRepository.findById(accountDto.getPrimaryOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doesn't found"));
        AccountHolder secondaryOwner = null;
        if( accountDto.getSecondaryOwnerId() != null){
         secondaryOwner = accountHoldersRepository.findById(accountDto.getSecondaryOwnerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doesn't found"));
        }
        LocalDate birthDate = primaryOwner.getBirthDate();
        LocalDate actualDate = LocalDate.now();
        Period period = Period.between(birthDate, actualDate);
        int age = period.getYears();

        Account newAccount;
        if (age <= 24) {
            newAccount = studentCheckingRepository.save(new StudentChecking(primaryOwner, secondaryOwner, accountDto.getSecretKey()));
        } else {
            newAccount = checkingRepository.save(new Checking(primaryOwner, secondaryOwner, accountDto.getSecretKey()));
        }

        return newAccount;
    }

    public ThirdParty addThirdParty(ThirdParty thirdParty) {
        ThirdParty newThirdParty = new ThirdParty(thirdParty.getHashKey(), thirdParty.getName());
        thirdPartyRepository.save(newThirdParty);
        return newThirdParty;
    }

    public Savings addSavings(Savings savings) {
        Savings newSavings = new Savings(savings.getPrimaryOwnerId(), savings.getSecondaryOwnerId(), savings.getStatus());
        savingRepository.save(newSavings);
        return newSavings;
    }

    public  CreditCard addCreditCard(CreditCard creditCard) {
        CreditCard newCreditCard = new CreditCard(creditCard.getCreditLimit(), creditCard.getInterestRate(),creditCard.getPrimaryOwnerId(), creditCard.getSecondaryOwnerId());
        creditCardRepository.save(newCreditCard);
        return newCreditCard;
    }




    public void deleteThirdParty(Long id) {
        if(!thirdPartyRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ThirdParty account not found");
        }
        thirdPartyRepository.deleteById(id);
    }

    public void deleteCreditCard(Long id) {
        if(!creditCardRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Credit card not found");
        }
        creditCardRepository.deleteById(id);
    }

    public void deleteSavings(Long id) {
        if(!savingRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Savings not found");
        }
        savingRepository.deleteById(id);
    }



    public void deleteChecking(Long id) {
        if(!checkingRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Checking account not found");
        }
        checkingRepository.deleteById(id);
    }

    public void deleteStudent(Long id) {
        if(!studentCheckingRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student account not found");
        }
        studentCheckingRepository.deleteById(id);
    }


    public Money interestRateCreditCard(Long id) {
        CreditCard creditCard = creditCardRepository.findById(id).get();
        Integer transfer = Period.between(creditCard.getLastInterestDay(), LocalDate.now()).getMonths();
        if (transfer >= 1) {
            BigDecimal firstMonth = new BigDecimal(1);
            BigDecimal lastMonth = new BigDecimal(12);
            for (int i = 0; i < transfer; i++) {
                Money interestRate = new Money(creditCard.getBalance().getAmount().multiply(firstMonth.add(creditCard.getInterestRate().divide(lastMonth))));
                creditCard.setBalance(interestRate);
            }
            creditCard.setLastInterestDay(LocalDate.now());
            creditCardRepository.save(creditCard);
        }
        return creditCard.getBalance();
    }


    public Money interestRateSaving(Long id) {
        Savings saving = savingRepository.findById(id).get();

        Integer transfer = Period.between(saving.getLastInterestDay(), LocalDate.now()).getYears();
        if (transfer >= 1) {
            BigDecimal year = new BigDecimal(1);
            for (int i = 0; i < transfer; i++) {
                Money interestRate = new Money(saving.getBalance().getAmount().multiply(year.add(saving.getInterestRate())));
                saving.setBalance(interestRate);
                savingRepository.save(saving);
            }
        }
        return saving.getBalance();
    }



    public BigDecimal checkingBalance(BalanceDTO balanceDTO) {
        AccountHolder accountHolders = accountHoldersRepository.findById(balanceDTO.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not an existing user"));
        Account account = accountRepository.findById(balanceDTO.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not an existing account"));

        if (account.getPrimaryOwner() == accountHolders || account.getSecondaryOwner() == accountHolders) {
            if (savingRepository.existsById(balanceDTO.getId())) {
                return interestRateSaving(balanceDTO.getId()).getAmount();
            }
            if (creditCardRepository.existsById(balanceDTO.getId())) {
                interestRateCreditCard(balanceDTO.getId()).getAmount();
            }
            return account.getBalance().getAmount();
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Can't access to this account");
        }
    }


    public BigDecimal transfer(Transfer transferDTO) {
        Account senderAccount = accountRepository.findById(transferDTO.getIssuingAccountId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This account doesn't exist"));
        Account receiverAccount = accountRepository.findById(transferDTO.getReceivingAccountId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This account doesn't exist"));
        Money sent = new Money(senderAccount.getBalance().decreaseAmount(transferDTO.getAmount()));
        Money received = new Money(receiverAccount.getBalance().increaseAmount(transferDTO.getAmount()));
        BigDecimal init = new BigDecimal(0);

        if (senderAccount.getBalance().getAmount().subtract(transferDTO.getAmount()).compareTo(init) < 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "You don't have money, go to work");
        }

        if (checkingRepository.existsById(transferDTO.getIssuingAccountId())) {
            Checking checkingSenderAccount = checkingRepository.findById(transferDTO.getIssuingAccountId()).get();
            return this.transferChecking(checkingSenderAccount, transferDTO.getAmount(), receiverAccount, sent, received);
        } else if (savingRepository.existsById(transferDTO.getReceivingAccountId())) {
            Savings savinSenderAccount = savingRepository.findById(transferDTO.getReceivingAccountId()).get();
            return this.transferSavings(savinSenderAccount, transferDTO.getAmount(), receiverAccount, sent, received);
        } else {
            senderAccount.setBalance(sent);
            receiverAccount.setBalance(received);
            Transfer creditCardTransfer = new Transfer(senderAccount.getPrimaryOwner().getId(),
                    receiverAccount.getPrimaryOwner().getId(), BigDecimal.valueOf(100), LocalDate.now(), senderAccount);
            accountRepository.save(senderAccount);
            accountRepository.save(receiverAccount);
            transferRepository.save(creditCardTransfer);
            return senderAccount.getBalance().getAmount();
        }
    }



    public BigDecimal transferChecking(Checking checking,BigDecimal transfer, Account accountReceiver, Money sent, Money received) {
        if (checking.getBalance().getAmount().compareTo(checking.getMinimumBalance().getAmount()) < 0) {
            sent.decreaseAmount(checking.getPenaltyFee().getAmount());
        }

        checking.setBalance(sent);
        accountReceiver.setBalance(received);
        checkingRepository.save(checking);
        Transfer checkingTransfer = new Transfer(checking.getPrimaryOwner().getId(),
                accountReceiver.getPrimaryOwner().getId(), BigDecimal.valueOf(20), LocalDate.now(), checking);
        accountRepository.save(accountReceiver);
        transferRepository.save(checkingTransfer);
        return checking.getBalance().getAmount();
    }


    public BigDecimal transferSavings(Savings savings, BigDecimal transfer, Account accountReceiver, Money sent, Money received) {
        if (savings.getBalance().getAmount().compareTo(savings.getMinimumBalance().getAmount()) < 0) {
            sent.decreaseAmount(savings.getPenaltyFee().getAmount());
        }
        savings.setBalance(sent);
        accountReceiver.setBalance(received);
        savingRepository.save(savings);
        Transfer savingTransfer = new Transfer(savings.getPrimaryOwner().getId(),
                accountReceiver.getPrimaryOwner().getId(), BigDecimal.valueOf(50), LocalDate.now(), savings);
        accountRepository.save(accountReceiver);
        transferRepository.save(savingTransfer);
        return savings.getBalance().getAmount();
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


