package com.c0821g1.sprint1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerController_getDetailCustomer {
    @Autowired
    private MockMvc mockMvc;

    //      VyLTT- customer detail - id = null
    @Test
    public void getDetailCustomer_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/customer/detail/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //      VyLTT- customer detail - id = ""
    @Test
    public void getIDetailCustomer_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/customer/detail/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //      VyLTT- customer detail - id is not exist in database
    @Test
    public void getDetailCustomer_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/customer/detail/{id}", "9"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //      VyLTT- customer detail - id is exist in database
    @Test
    public void getDetailCustomer_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/customer/detail/{id}", "3"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.customerId").value(3))
                .andExpect(jsonPath("$.customerName").value("Lê Đình Quốc"))
                .andExpect(jsonPath("$.customerDateOfBirth").value("01-01-1998"));
    }
}
