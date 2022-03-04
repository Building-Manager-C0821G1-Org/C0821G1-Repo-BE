package com.c0821g1.sprint1;

import com.c0821g1.sprint1.dto.ChangePasswordDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserController_getChangePasswordEmployee {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void authenticateUser_13() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setCurrentPassword(null);
        changePasswordDTO.setNewPassword(null);
        changePasswordDTO.setConfirmPassword(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/changePassword")
                        .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void authenticateUser_14() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setCurrentPassword("");
        changePasswordDTO.setNewPassword("");
        changePasswordDTO.setConfirmPassword("");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/changePassword")
                        .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void authenticateUser_18() throws Exception {
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
        changePasswordDTO.setCurrentPassword("234");
        changePasswordDTO.setNewPassword("123");
        changePasswordDTO.setConfirmPassword("123");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/changePassword")
                        .content(this.objectMapper.writeValueAsString(changePasswordDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
