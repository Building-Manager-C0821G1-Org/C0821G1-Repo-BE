package com.c0821g1.sprint1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FloorsRestController_deleteFloorsById {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create:DuyNP
     * Method: Test delete floors id = null
     */
    @Test
    public void deleteFloorsById_25() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/floors/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create:DuyNP
     * Method: Test delete floors id = rỗng ("")
     */
    @Test
    public void deleteFloorsById_26() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/floors/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create:DuyNP
     * Method: Test delete floors id không tồn tại trong Database
     */
    @Test
    public void deleteFloorsById_27() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/floors/delete/{id}", 6))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create:DuyNP
     * Method: Test delete floors id tồn tại trong Database
     */
    @Test
    public void deleteFloorsById_28() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/floors/delete/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
