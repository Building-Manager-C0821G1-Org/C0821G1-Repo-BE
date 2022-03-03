package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.dto.ContractDTO;
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
public class ContractRestController_createContract {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createContract_Expired_13() throws Exception {

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractExpred(null);
        contractDTO.setContractDateStart("20-12-2020");
        contractDTO.setContractDateStart("20-12-2020");
        contractDTO.setPrice("300000");
        contractDTO.setContractTotal("1200000");
        contractDTO.setContractContent("Hợp đồng lao đồng");
        contractDTO.setCustomerId(1);
        contractDTO.setEmployeeId(1);
        contractDTO.setSpaceId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/add")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_Expired_14() throws Exception {

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractExpred("");
        contractDTO.setContractDateStart("20-12-2020");
        contractDTO.setContractDateStart("20-12-2020");
        contractDTO.setPrice("300000");
        contractDTO.setContractTotal("1200000");
        contractDTO.setContractContent("Hợp đồng lao đồng");
        contractDTO.setCustomerId(1);
        contractDTO.setEmployeeId(1);
        contractDTO.setSpaceId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/add")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_DateStart_14() throws Exception {

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractExpred("12");
        contractDTO.setContractDateStart("");
        contractDTO.setContractDateEnd("20-12-2020");
        contractDTO.setPrice("300000");
        contractDTO.setContractTotal("1200000");
        contractDTO.setContractContent("Hợp đồng lao đồng");
        contractDTO.setCustomerId(1);
        contractDTO.setEmployeeId(1);
        contractDTO.setSpaceId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/add")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_DateStart_13() throws Exception {

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractExpred("sdsd");
        contractDTO.setContractDateStart(null);
        contractDTO.setContractDateEnd("20-12-2020");
        contractDTO.setPrice("300000");
        contractDTO.setContractTotal("1200000");
        contractDTO.setContractContent("Hợp đồng lao đồng");
        contractDTO.setCustomerId(1);
        contractDTO.setEmployeeId(1);
        contractDTO.setSpaceId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/add")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_DateEnd_13() throws Exception {

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractExpred("12");
        contractDTO.setContractDateStart("20-12-2020");
        contractDTO.setContractDateEnd(null);
        contractDTO.setPrice("300000");
        contractDTO.setContractTotal("1200000");
        contractDTO.setContractContent("Hợp đồng lao đồng");
        contractDTO.setCustomerId(1);
        contractDTO.setEmployeeId(1);
        contractDTO.setSpaceId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/add")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_DateEnd_14() throws Exception {

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractExpred("sdsd");
        contractDTO.setContractDateStart("20-12-2020");
        contractDTO.setContractDateEnd("");
        contractDTO.setPrice("300000");
        contractDTO.setContractTotal("1200000");
        contractDTO.setContractContent("Hợp đồng lao đồng");
        contractDTO.setCustomerId(1);
        contractDTO.setEmployeeId(1);
        contractDTO.setSpaceId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/add")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_Price_14() throws Exception {

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractExpred("5");
        contractDTO.setContractDateStart("20-12-2020");
        contractDTO.setContractDateEnd("20-12-2020");
        contractDTO.setPrice("");
        contractDTO.setContractTotal("1200000");
        contractDTO.setContractContent("Hợp đồng lao đồng");
        contractDTO.setCustomerId(1);
        contractDTO.setEmployeeId(1);
        contractDTO.setSpaceId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/add")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_Total_14() throws Exception {

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractExpred("5");
        contractDTO.setContractDateStart("20-12-2020");
        contractDTO.setContractDateEnd("20-12-2020");
        contractDTO.setPrice("120000");
        contractDTO.setContractTotal("");
        contractDTO.setContractContent("Hợp đồng lao đồng");
        contractDTO.setCustomerId(1);
        contractDTO.setEmployeeId(1);
        contractDTO.setSpaceId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/add")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_Content_14() throws Exception {

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractExpred("5");
        contractDTO.setContractDateStart("20-12-2020");
        contractDTO.setContractDateEnd("20-12-2020");
        contractDTO.setPrice("120000");
        contractDTO.setContractTotal("120000");
        contractDTO.setContractContent("");
        contractDTO.setCustomerId(1);
        contractDTO.setEmployeeId(1);
        contractDTO.setSpaceId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/add")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_Content_16() throws Exception {

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractExpred("5");
        contractDTO.setContractDateStart("20-12-2020");
        contractDTO.setContractDateEnd("20-12-2020");
        contractDTO.setPrice("120000");
        contractDTO.setContractTotal("120000");
        contractDTO.setContractContent("asds");
        contractDTO.setCustomerId(1);
        contractDTO.setEmployeeId(1);
        contractDTO.setSpaceId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/add")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_18() throws Exception {

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractExpred("5");
        contractDTO.setContractDateStart("20-12-2020");
        contractDTO.setContractDateEnd("20-12-2020");
        contractDTO.setPrice("120000");
        contractDTO.setContractTotal("120000");
        contractDTO.setContractContent("Hợp đông B");
        contractDTO.setCustomerId(1);
        contractDTO.setEmployeeId(1);
        contractDTO.setSpaceId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/add")
                        .content(this.objectMapper.writeValueAsString(contractDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
