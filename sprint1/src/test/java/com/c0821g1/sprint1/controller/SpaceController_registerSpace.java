//package com.c0821g1.sprint1.controller;
//
//import com.c0821g1.sprint1.dto.space.SpacesDTO;
//import com.c0821g1.sprint1.entity.floor.Floors;
//import com.c0821g1.sprint1.entity.space.SpacesStatus;
//import com.c0821g1.sprint1.entity.space.SpacesType;
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
//public class SpaceController_registerSpace {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
////  Test
//    @Test
//    public void registerSpace_spaceCode_13() throws Exception {
//        SpacesDTO spacesDTO = new SpacesDTO();
//        spacesDTO.setSpaceCode(null);
//        spacesDTO.setSpaceArea("70");
//        spacesDTO.setSpacePrice("3.000.000");
//        spacesDTO.setSpaceManagerFee("1.000.000");
//        spacesDTO.setSpaceNote("ok");
//        spacesDTO.setSpaceImage("");
//        spacesDTO.setSpaceDeleteFlag(null);
//
//        SpacesType spacesType = new SpacesType();
//        spacesType.setSpaceTypeId(1);
//        spacesDTO.setSpacesType(spacesType);
//
//        SpacesStatus spacesStatus = new SpacesStatus();
//        spacesStatus.setSpaceStatusId(2);
//        spacesDTO.setSpaceStatus(spacesStatus);
//
//        Floors floors = new Floors();
//        floors.setFloorId(2);
//        spacesDTO.setFloors(floors);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/space/register")
//                .content(this.objectMapper.writeValueAsString(spacesDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void registerSpace_spaceCode_14() throws Exception {
//        SpacesDTO spacesDTO = new SpacesDTO();
//        spacesDTO.setSpaceCode("");
//        spacesDTO.setSpaceArea("70");
//        spacesDTO.setSpacePrice("3.000.000");
//        spacesDTO.setSpaceManagerFee("1.000.000");
//        spacesDTO.setSpaceNote("ok");
//        spacesDTO.setSpaceImage("");
//        spacesDTO.setSpaceDeleteFlag(null);
//
//        SpacesType spacesType = new SpacesType();
//        spacesType.setSpaceTypeId(1);
//        spacesDTO.setSpacesType(spacesType);
//
//        SpacesStatus spacesStatus = new SpacesStatus();
//        spacesStatus.setSpaceStatusId(2);
//        spacesDTO.setSpaceStatus(spacesStatus);
//
//        Floors floors = new Floors();
//        floors.setFloorId(2);
//        spacesDTO.setFloors(floors);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/space/register")
//                .content(this.objectMapper.writeValueAsString(spacesDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void registerSpace_spaceArea_13() throws Exception {
//        SpacesDTO spacesDTO = new SpacesDTO();
//        spacesDTO.setSpaceCode("MB-001");
//        spacesDTO.setSpaceArea(null);
//        spacesDTO.setSpacePrice("3.000.000");
//        spacesDTO.setSpaceManagerFee("1.000.000");
//        spacesDTO.setSpaceNote("ok");
//        spacesDTO.setSpaceImage("");
//        spacesDTO.setSpaceDeleteFlag(null);
//
//        SpacesType spacesType = new SpacesType();
//        spacesType.setSpaceTypeId(1);
//        spacesDTO.setSpacesType(spacesType);
//
//        SpacesStatus spacesStatus = new SpacesStatus();
//        spacesStatus.setSpaceStatusId(2);
//        spacesDTO.setSpaceStatus(spacesStatus);
//
//        Floors floors = new Floors();
//        floors.setFloorId(2);
//        spacesDTO.setFloors(floors);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/space/register")
//                .content(this.objectMapper.writeValueAsString(spacesDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void registerSpace_spaceArea_14() throws Exception {
//        SpacesDTO spacesDTO = new SpacesDTO();
//        spacesDTO.setSpaceCode("MB-001");
//        spacesDTO.setSpaceArea("");
//        spacesDTO.setSpacePrice("3.000.000");
//        spacesDTO.setSpaceManagerFee("1.000.000");
//        spacesDTO.setSpaceNote("ok");
//        spacesDTO.setSpaceImage("");
//        spacesDTO.setSpaceDeleteFlag(null);
//
//        SpacesType spacesType = new SpacesType();
//        spacesType.setSpaceTypeId(1);
//        spacesDTO.setSpacesType(spacesType);
//
//        SpacesStatus spacesStatus = new SpacesStatus();
//        spacesStatus.setSpaceStatusId(2);
//        spacesDTO.setSpaceStatus(spacesStatus);
//
//        Floors floors = new Floors();
//        floors.setFloorId(2);
//        spacesDTO.setFloors(floors);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/space/register")
//                .content(this.objectMapper.writeValueAsString(spacesDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void registerSpace_spacesType_13() throws Exception {
//        SpacesDTO spacesDTO = new SpacesDTO();
//        spacesDTO.setSpaceCode("MB-001");
//        spacesDTO.setSpaceArea("70");
//        spacesDTO.setSpacePrice("3.000.000");
//        spacesDTO.setSpaceManagerFee("1.000.000");
//        spacesDTO.setSpaceNote("ok");
//        spacesDTO.setSpaceImage("");
//        spacesDTO.setSpaceDeleteFlag(null);
//
////        SpacesType spacesType = new SpacesType();
////        spacesType.setSpaceTypeId(1);
//        spacesDTO.setSpacesType(null);
//
//        SpacesStatus spacesStatus = new SpacesStatus();
//        spacesStatus.setSpaceStatusId(2);
//        spacesDTO.setSpaceStatus(spacesStatus);
//
//        Floors floors = new Floors();
//        floors.setFloorId(2);
//        spacesDTO.setFloors(floors);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/space/register")
//                .content(this.objectMapper.writeValueAsString(spacesDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void registerSpace_spacesType_14() throws Exception {
//        SpacesDTO spacesDTO = new SpacesDTO();
//        spacesDTO.setSpaceCode("MB-001");
//        spacesDTO.setSpaceArea("70");
//        spacesDTO.setSpacePrice("3.000.000");
//        spacesDTO.setSpaceManagerFee("1.000.000");
//        spacesDTO.setSpaceNote("ok");
//        spacesDTO.setSpaceImage("");
//        spacesDTO.setSpaceDeleteFlag(null);
//
//        SpacesType spacesType = new SpacesType();
////        spacesType.setSpaceTypeId(1);
//        spacesDTO.setSpacesType(spacesType);
//
//        SpacesStatus spacesStatus = new SpacesStatus();
//        spacesStatus.setSpaceStatusId(2);
//        spacesDTO.setSpaceStatus(spacesStatus);
//
//        Floors floors = new Floors();
//        floors.setFloorId(2);
//        spacesDTO.setFloors(floors);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/space/register")
//                .content(this.objectMapper.writeValueAsString(spacesDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void registerSpace_spacesStatus_13() throws Exception {
//        SpacesDTO spacesDTO = new SpacesDTO();
//        spacesDTO.setSpaceCode("MB-001");
//        spacesDTO.setSpaceArea("70");
//        spacesDTO.setSpacePrice("3.000.000");
//        spacesDTO.setSpaceManagerFee("1.000.000");
//        spacesDTO.setSpaceNote("ok");
//        spacesDTO.setSpaceImage("");
//        spacesDTO.setSpaceDeleteFlag(null);
//
//        SpacesType spacesType = new SpacesType();
//        spacesType.setSpaceTypeId(1);
//        spacesDTO.setSpacesType(spacesType);
//
////        SpacesStatus spacesStatus = new SpacesStatus();
////        spacesStatus.setSpaceStatusId(2);
//        spacesDTO.setSpaceStatus(null);
//
//        Floors floors = new Floors();
//        floors.setFloorId(2);
//        spacesDTO.setFloors(floors);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/space/register")
//                .content(this.objectMapper.writeValueAsString(spacesDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void registerSpace_spacesStatus_14() throws Exception {
//        SpacesDTO spacesDTO = new SpacesDTO();
//        spacesDTO.setSpaceCode("MB-001");
//        spacesDTO.setSpaceArea("70");
//        spacesDTO.setSpacePrice("3.000.000");
//        spacesDTO.setSpaceManagerFee("1.000.000");
//        spacesDTO.setSpaceNote("ok");
//        spacesDTO.setSpaceImage("");
//        spacesDTO.setSpaceDeleteFlag(null);
//
//        SpacesType spacesType = new SpacesType();
//        spacesType.setSpaceTypeId(1);
//        spacesDTO.setSpacesType(spacesType);
//
//        SpacesStatus spacesStatus = new SpacesStatus();
////        spacesStatus.setSpaceStatusId(2);
//        spacesDTO.setSpaceStatus(spacesStatus);
//
//        Floors floors = new Floors();
//        floors.setFloorId(2);
//        spacesDTO.setFloors(floors);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/space/register")
//                .content(this.objectMapper.writeValueAsString(spacesDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void registerSpace_floors_13() throws Exception {
//        SpacesDTO spacesDTO = new SpacesDTO();
//        spacesDTO.setSpaceCode("MB-001");
//        spacesDTO.setSpaceArea("70");
//        spacesDTO.setSpacePrice("3.000.000");
//        spacesDTO.setSpaceManagerFee("1.000.000");
//        spacesDTO.setSpaceNote("ok");
//        spacesDTO.setSpaceImage("");
//        spacesDTO.setSpaceDeleteFlag(null);
//
//        SpacesType spacesType = new SpacesType();
//        spacesType.setSpaceTypeId(1);
//        spacesDTO.setSpacesType(spacesType);
//
//        SpacesStatus spacesStatus = new SpacesStatus();
//        spacesStatus.setSpaceStatusId(2);
//        spacesDTO.setSpaceStatus(spacesStatus);
//
////        Floors floors = new Floors();
////        floors.setFloorId(2);
//        spacesDTO.setFloors(null);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/space/register")
//                .content(this.objectMapper.writeValueAsString(spacesDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void registerSpace_floors_14() throws Exception {
//        SpacesDTO spacesDTO = new SpacesDTO();
//        spacesDTO.setSpaceCode("MB-001");
//        spacesDTO.setSpaceArea("70");
//        spacesDTO.setSpacePrice("3.000.000");
//        spacesDTO.setSpaceManagerFee("1.000.000");
//        spacesDTO.setSpaceNote("ok");
//        spacesDTO.setSpaceImage("");
//        spacesDTO.setSpaceDeleteFlag(null);
//
//        SpacesType spacesType = new SpacesType();
//        spacesType.setSpaceTypeId(1);
//        spacesDTO.setSpacesType(spacesType);
//
//        SpacesStatus spacesStatus = new SpacesStatus();
//        spacesStatus.setSpaceStatusId(2);
//        spacesDTO.setSpaceStatus(spacesStatus);
//
//        Floors floors = new Floors();
////        floors.setFloorId(2);
//        spacesDTO.setFloors(null);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/space/register")
//                .content(this.objectMapper.writeValueAsString(spacesDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void registerSpace_18() throws Exception {
//        SpacesDTO spacesDTO = new SpacesDTO();
//        spacesDTO.setSpaceCode("MB-001");
//        spacesDTO.setSpaceArea("70");
//        spacesDTO.setSpacePrice("3.000.000");
//        spacesDTO.setSpaceManagerFee("1.000.000");
//        spacesDTO.setSpaceNote("ok");
//        spacesDTO.setSpaceImage("");
//        spacesDTO.setSpaceDeleteFlag(null);
//
//        SpacesType spacesType = new SpacesType();
//        spacesType.setSpaceTypeId(1);
//        spacesDTO.setSpacesType(spacesType);
//
//        SpacesStatus spacesStatus = new SpacesStatus();
//        spacesStatus.setSpaceStatusId(2);
//        spacesDTO.setSpaceStatus(spacesStatus);
//
//        Floors floors = new Floors();
//        floors.setFloorId(2);
//        spacesDTO.setFloors(floors);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/space/register")
//                .content(this.objectMapper.writeValueAsString(spacesDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is2xxSuccessful());
//    }
//}
