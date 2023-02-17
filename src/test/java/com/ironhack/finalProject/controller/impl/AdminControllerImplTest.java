package com.ironhack.finalProject.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.finalProject.model.accounts.Savings;
import com.ironhack.finalProject.model.users.AccountHolder;
import com.ironhack.finalProject.model.users.Address;
import com.ironhack.finalProject.model.users.Admin;
import com.ironhack.finalProject.model.users.ThirdParty;
import com.ironhack.finalProject.repositories.accounts.AccountRepository;
import com.ironhack.finalProject.repositories.accounts.SavingRepository;
import com.ironhack.finalProject.repositories.users.AccountHoldersRepository;
import com.ironhack.finalProject.repositories.users.AddressRepository;
import com.ironhack.finalProject.repositories.users.AdminRepository;
import com.ironhack.finalProject.repositories.users.ThirdPartyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import static com.ironhack.finalProject.enums.Status.ACTIVE;

@SpringBootTest
@AutoConfigureMockMvc
class AdminControllerImplTest {
    @Autowired
    private AdminRepository adminsRepository;
    @Autowired
    private AccountHoldersRepository accountHoldersRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private SavingRepository savingsRepository;
    @Autowired
    private AccountRepository accountRepository;

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private Admin admin1;
    private AccountHolder holder1;
    private Address address1;
    private LocalDate birthDate;
    private Savings saving1;

    MvcResult mvcResult;
    String body;
    private final ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        admin1 = new Admin("Yisus", "123");
        adminsRepository.save(admin1);

        birthDate = LocalDate.of(1999,1,2);
        holder1 = new AccountHolder("Yisus","123",birthDate, address1, address1);
        accountHoldersRepository.save(holder1);

        address1 = new Address("street", "08870", "Sabadell");
        addressRepository.saveAll(List.of(address1));

        saving1 = new Savings(1L,2L,ACTIVE);
        savingsRepository.save(saving1);


    }

    @AfterEach
    void tearDown() {
        savingsRepository.delete(saving1);
        adminsRepository.delete(admin1);
        accountHoldersRepository.delete(holder1);
        addressRepository.delete(address1);

    }

    @Test
    void getAllSavingsAccounts_AllSavingsAccountsWorks() throws Exception {
        mvcResult = mockMvc.perform(get("/accounts/savings"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("ACTIVE"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("1"));
//        MvcResult mvcResult = mockMvc.perform(get("/accounts/savings"))
//                .andExpect(status().isOK())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andReturn();

    }

    @Test
    void addThirdParty_Works() throws Exception {
        //Admin admins = new Admin("Yisus", "123");
        body = objectMapper.writeValueAsString(admin1);
        mvcResult = mockMvc.perform(post("/admin/third-party").content(body).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Yisus"));
    }

    @Test
    void deleteSavings_Works() throws Exception {
        mvcResult = mockMvc.perform(delete("/admin/savings/" + saving1.getId()))
                .andExpect(status().isNoContent())
                .andReturn();

        assertFalse(savingsRepository.existsById(saving1.getId()));

    }
}