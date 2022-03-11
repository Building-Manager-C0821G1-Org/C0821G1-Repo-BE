//package com.c0821g1.sprint1;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class DeleteContract {
//    @Autowired
//    private MockMvc mockMvc;
//    // null
////    @Test
////    public void deleteContract_25() throws Exception {
////        this.mockMvc.perform(
////                MockMvcRequestBuilders
////                        .get("/api/contract/delete/{id}", "null"))
////                .andDo(print())
////                .andExpect(status().is4xxClientError());
////    }
////    // rỗng
////    @Test
////    public void deleteContract_26() throws Exception {
////        this.mockMvc.perform(
////                MockMvcRequestBuilders
////                        .get("/api/contract/delete/{id}", " "))
////                .andDo(print())
////                .andExpect(status().is4xxClientError());
////    }
////    // có giá trị
////    @Test
////    public void deleteContract_28() throws Exception {
////        this.mockMvc.perform(
////                MockMvcRequestBuilders
////                        .get("api/contract/delete/{id}", "1"))
////                .andDo(print())
////                .andExpect(status().is2xxSuccessful());
////    }
//}
