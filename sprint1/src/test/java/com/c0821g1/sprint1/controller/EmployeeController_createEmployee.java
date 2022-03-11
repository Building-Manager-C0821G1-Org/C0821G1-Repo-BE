//package com.c0821g1.sprint1.controller;
//
//import com.c0821g1.sprint1.dto.EmployeeDTO;
//import com.c0821g1.sprint1.entity.employee.EmployeePosition;
//import com.c0821g1.sprint1.entity.security.AppUser;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class EmployeeController_createEmployee {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void createEmployee_employeeCode_13() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeCode(null);
//        employeeDTO.setEmployeeName("Gia Bảo");
//        employeeDTO.setEmployeeDateOfBirth("04/03/1993");
//        employeeDTO.setEmployeeGender("1");
//        employeeDTO.setEmployeeAddress("19 Nguyễn Đức Cảnh");
//        employeeDTO.setEmployeePhone("0903157020");
//        employeeDTO.setEmployeeEmail("giabao@gmail.com");
//        employeeDTO.setEmployeeStartDate("05/12/2019");
//        employeeDTO.setEmployeeImage("image1");
//        employeeDTO.setEmployeeDeleteFlag(null);
//
//        EmployeePosition employeePosition = new EmployeePosition();
//        employeePosition.setEmployeePositionId(1);
//        employeeDTO.setEmployeePosition(employeePosition);
//
//        AppUser appUser = new AppUser();
//        appUser.setAppUserId(1);
//        employeeDTO.setAppUser(appUser);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
//                .content(this.objectMapper.writeValueAsString(employeeDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void createEmployee_employeeCode_14() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeCode("");
//        employeeDTO.setEmployeeName("Gia Bảo");
//        employeeDTO.setEmployeeDateOfBirth("04/03/1993");
//        employeeDTO.setEmployeeGender("1");
//        employeeDTO.setEmployeeAddress("19 Nguyễn Đức Cảnh");
//        employeeDTO.setEmployeePhone("0903157020");
//        employeeDTO.setEmployeeEmail("giabao@gmail.com");
//        employeeDTO.setEmployeeStartDate("05/12/2019");
//        employeeDTO.setEmployeeImage("image1");
//        employeeDTO.setEmployeeDeleteFlag(null);
//
//        EmployeePosition employeePosition = new EmployeePosition();
//        employeePosition.setEmployeePositionId(1);
//        employeeDTO.setEmployeePosition(employeePosition);
//
//        AppUser appUser = new AppUser();
//        appUser.setAppUserId(1);
//        employeeDTO.setAppUser(appUser);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
//                .content(this.objectMapper.writeValueAsString(employeeDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void createEmployee_employeeName_13() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeCode("NV-1234");
//        employeeDTO.setEmployeeName(null);
//        employeeDTO.setEmployeeDateOfBirth("04/03/1993");
//        employeeDTO.setEmployeeGender("1");
//        employeeDTO.setEmployeeAddress("19 Nguyễn Đức Cảnh");
//        employeeDTO.setEmployeePhone("0903157020");
//        employeeDTO.setEmployeeEmail("giabao@gmail.com");
//        employeeDTO.setEmployeeStartDate("05/12/2019");
//        employeeDTO.setEmployeeImage("image1");
//        employeeDTO.setEmployeeDeleteFlag(null);
//
//        EmployeePosition employeePosition = new EmployeePosition();
//        employeePosition.setEmployeePositionId(1);
//        employeeDTO.setEmployeePosition(employeePosition);
//
//        AppUser appUser = new AppUser();
//        appUser.setAppUserId(1);
//        employeeDTO.setAppUser(appUser);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
//                .content(this.objectMapper.writeValueAsString(employeeDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createEmployee_employeeName_14() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeCode("Nv-1234");
//        employeeDTO.setEmployeeName("");
//        employeeDTO.setEmployeeDateOfBirth("04/03/1993");
//        employeeDTO.setEmployeeGender("1");
//        employeeDTO.setEmployeeAddress("19 Nguyễn Đức Cảnh");
//        employeeDTO.setEmployeePhone("0903157020");
//        employeeDTO.setEmployeeEmail("giabao@gmail.com");
//        employeeDTO.setEmployeeStartDate("05/12/2019");
//        employeeDTO.setEmployeeImage("image1");
//        employeeDTO.setEmployeeDeleteFlag(null);
//
//        EmployeePosition employeePosition = new EmployeePosition();
//        employeePosition.setEmployeePositionId(1);
//        employeeDTO.setEmployeePosition(employeePosition);
//
//        AppUser appUser = new AppUser();
//        appUser.setAppUserId(1);
//        employeeDTO.setAppUser(appUser);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
//                .content(this.objectMapper.writeValueAsString(employeeDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void createEmployee_employeePhone_13() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeCode("Nv-1234");
//        employeeDTO.setEmployeeName("Gia Bảo");
//        employeeDTO.setEmployeeDateOfBirth("04/03/1993");
//        employeeDTO.setEmployeeGender("1");
//        employeeDTO.setEmployeeAddress("19 Nguyễn Đức Cảnh");
//        employeeDTO.setEmployeePhone(null);
//        employeeDTO.setEmployeeEmail("giabao@gmail.com");
//        employeeDTO.setEmployeeStartDate("05/12/2019");
//        employeeDTO.setEmployeeImage("image1");
//        employeeDTO.setEmployeeDeleteFlag(null);
//
//        EmployeePosition employeePosition = new EmployeePosition();
//        employeePosition.setEmployeePositionId(1);
//        employeeDTO.setEmployeePosition(employeePosition);
//
//        AppUser appUser = new AppUser();
//        appUser.setAppUserId(1);
//        employeeDTO.setAppUser(appUser);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
//                .content(this.objectMapper.writeValueAsString(employeeDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void createEmployee_employeePhone_14() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeCode("Nv-1234");
//        employeeDTO.setEmployeeName("Gia Bảo");
//        employeeDTO.setEmployeeDateOfBirth("04/03/1993");
//        employeeDTO.setEmployeeGender("1");
//        employeeDTO.setEmployeeAddress("19 Nguyễn Đức Cảnh");
//        employeeDTO.setEmployeePhone("");
//        employeeDTO.setEmployeeEmail("giabao@gmail.com");
//        employeeDTO.setEmployeeStartDate("05/12/2019");
//        employeeDTO.setEmployeeImage("image1");
//        employeeDTO.setEmployeeDeleteFlag(null);
//
//        EmployeePosition employeePosition = new EmployeePosition();
//        employeePosition.setEmployeePositionId(1);
//        employeeDTO.setEmployeePosition(employeePosition);
//
//        AppUser appUser = new AppUser();
//        appUser.setAppUserId(1);
//        employeeDTO.setAppUser(appUser);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
//                .content(this.objectMapper.writeValueAsString(employeeDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void createEmployee_employeeEmail_13() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeCode("Nv-1234");
//        employeeDTO.setEmployeeName("Gia Bảo");
//        employeeDTO.setEmployeeDateOfBirth("04/03/1993");
//        employeeDTO.setEmployeeGender("1");
//        employeeDTO.setEmployeeAddress("19 Nguyễn Đức Cảnh");
//        employeeDTO.setEmployeePhone("0903157020");
//        employeeDTO.setEmployeeEmail(null);
//        employeeDTO.setEmployeeStartDate("05/12/2019");
//        employeeDTO.setEmployeeImage("image1");
//        employeeDTO.setEmployeeDeleteFlag(null);
//
//        EmployeePosition employeePosition = new EmployeePosition();
//        employeePosition.setEmployeePositionId(1);
//        employeeDTO.setEmployeePosition(employeePosition);
//
//        AppUser appUser = new AppUser();
//        appUser.setAppUserId(1);
//        employeeDTO.setAppUser(appUser);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
//                .content(this.objectMapper.writeValueAsString(employeeDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void createEmployee_employeeEmail_14() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeCode("Nv-1234");
//        employeeDTO.setEmployeeName("Gia Bảo");
//        employeeDTO.setEmployeeDateOfBirth("04/03/1993");
//        employeeDTO.setEmployeeGender("1");
//        employeeDTO.setEmployeeAddress("19 Nguyễn Đức Cảnh");
//        employeeDTO.setEmployeePhone("0903157020");
//        employeeDTO.setEmployeeEmail("");
//        employeeDTO.setEmployeeStartDate("05/12/2019");
//        employeeDTO.setEmployeeImage("image1");
//        employeeDTO.setEmployeeDeleteFlag(null);
//
//        EmployeePosition employeePosition = new EmployeePosition();
//        employeePosition.setEmployeePositionId(1);
//        employeeDTO.setEmployeePosition(employeePosition);
//
//        AppUser appUser = new AppUser();
//        appUser.setAppUserId(1);
//        employeeDTO.setAppUser(appUser);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
//                .content(this.objectMapper.writeValueAsString(employeeDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void createEmployee_employeeImage_13() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeCode("Nv-1234");
//        employeeDTO.setEmployeeName("Gia Bảo");
//        employeeDTO.setEmployeeDateOfBirth("04/03/1993");
//        employeeDTO.setEmployeeGender("1");
//        employeeDTO.setEmployeeAddress("19 Nguyễn Đức Cảnh");
//        employeeDTO.setEmployeePhone("0903157020");
//        employeeDTO.setEmployeeEmail("giabao@gmail.com");
//        employeeDTO.setEmployeeStartDate("05/12/2019");
//        employeeDTO.setEmployeeImage(null);
//        employeeDTO.setEmployeeDeleteFlag(null);
//
//        EmployeePosition employeePosition = new EmployeePosition();
//        employeePosition.setEmployeePositionId(1);
//        employeeDTO.setEmployeePosition(employeePosition);
//
//        AppUser appUser = new AppUser();
//        appUser.setAppUserId(1);
//        employeeDTO.setAppUser(appUser);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
//                .content(this.objectMapper.writeValueAsString(employeeDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void createEmployee_employeeImage_14() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeCode("Nv-1234");
//        employeeDTO.setEmployeeName("Gia Bảo");
//        employeeDTO.setEmployeeDateOfBirth("04/03/1993");
//        employeeDTO.setEmployeeGender("1");
//        employeeDTO.setEmployeeAddress("19 Nguyễn Đức Cảnh");
//        employeeDTO.setEmployeePhone("0903157020");
//        employeeDTO.setEmployeeEmail("giabao@gmail.com");
//        employeeDTO.setEmployeeStartDate("05/12/2019");
//        employeeDTO.setEmployeeImage("");
//        employeeDTO.setEmployeeDeleteFlag(null);
//
//        EmployeePosition employeePosition = new EmployeePosition();
//        employeePosition.setEmployeePositionId(1);
//        employeeDTO.setEmployeePosition(employeePosition);
//
//        AppUser appUser = new AppUser();
//        appUser.setAppUserId(1);
//        employeeDTO.setAppUser(appUser);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
//                .content(this.objectMapper.writeValueAsString(employeeDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    } @Test
//    public void createEmployee_18() throws Exception {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeCode("Nv-1234");
//        employeeDTO.setEmployeeName("Gia Bảo");
//        employeeDTO.setEmployeeDateOfBirth("04/03/1993");
//        employeeDTO.setEmployeeGender("1");
//        employeeDTO.setEmployeeAddress("19 Nguyễn Đức Cảnh");
//        employeeDTO.setEmployeePhone("0903157020");
//        employeeDTO.setEmployeeEmail("giabao@gmail.com");
//        employeeDTO.setEmployeeStartDate("05/12/2019");
//        employeeDTO.setEmployeeImage("image");
//        employeeDTO.setEmployeeDeleteFlag(null);
//
//        EmployeePosition employeePosition = new EmployeePosition();
//        employeePosition.setEmployeePositionId(1);
//        employeeDTO.setEmployeePosition(employeePosition);
//
//        AppUser appUser = new AppUser();
//        appUser.setAppUserId(1);
//        employeeDTO.setAppUser(appUser);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/employee/create")
//                .content(this.objectMapper.writeValueAsString(employeeDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is2xxSuccessful());
//    }
//
//}
