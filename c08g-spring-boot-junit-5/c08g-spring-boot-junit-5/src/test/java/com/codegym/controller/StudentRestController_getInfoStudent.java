package com.codegym.controller;

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
public class StudentRestController_getInfoStudent {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getInfoStudent_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/studentRest/detail/{id}", "null"))
//                .get("/studentRest/detail/:?id=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/studentRest/detail/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/studentRest/detail/{id}", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("Thịnh"))
                .andExpect(jsonPath("$.dateOfBirth").value("2002-05-03"))
                .andExpect(jsonPath("$.classStudent.id").value(1));
    }
}
