package com.ironhack.erp.salesservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.erp.salesservice.model.entities.Sale;
import com.ironhack.erp.salesservice.repository.SalesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class SalesControllerImplTest {

    @Autowired
    SalesControllerImpl salesController;

    @MockBean
    SalesRepository salesRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    Sale sale;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        List<Long> products = Arrays.asList((long) 1);

        sale = new Sale((long) 1,(long) 1, products,"card", new BigDecimal(10), new BigDecimal(10),BigDecimal.ZERO,  BigDecimal.ZERO, BigDecimal.ZERO);


        when(salesRepository.findAll()).thenReturn(Arrays.asList(sale));
        when(salesRepository.findById("1")).thenReturn(java.util.Optional.ofNullable(sale));
        when(salesRepository.save(sale)).thenReturn(sale);
    }

    void findAllSales() throws Exception {
        mockMvc.perform(get("/sales")).andExpect(status().isOk());
    }

    @Test
    void findSaleById() throws Exception {
        mockMvc.perform(get("/sales/1")).andExpect(status().isOk());
    }

    @Test
    void createSale() throws Exception {
        mockMvc.perform(post("/sales")
                .content(objectMapper.writeValueAsString(sale))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void deleteSale() throws Exception {
        mockMvc.perform(delete("/sales/1")).andExpect(status().isNoContent());
    }
}