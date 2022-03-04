package com.c0821g1.sprint1;

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
public class EmployeeController_getViewEmployee {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getViewEmployee_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/:?username=null)"))
                        .andDo(print())
                        .andExpect(status().is4xxClientError());


    }
    @Test
    public void getViewEmployee_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/:?username="))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void getViewEmployee_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/:?username=hung"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.employee_id").value(2))
                .andExpect(jsonPath("$.app_user_id").value("2"))
                .andExpect(jsonPath("$.employee_name").value("hung"))
                .andExpect(jsonPath("$.employee_date_of_birth").value("1992-10-10"))
                .andExpect(jsonPath("$.employee_address").value("dn"))
                .andExpect(jsonPath("$.employee_email").value("hjj@gmail.com"))
                .andExpect(jsonPath("$.employee_gender").value(""));

    }
}
