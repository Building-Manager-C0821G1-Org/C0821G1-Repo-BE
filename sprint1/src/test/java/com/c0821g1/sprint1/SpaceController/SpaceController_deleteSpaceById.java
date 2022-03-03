package com.c0821g1.sprint1.SpaceController;

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
public class SpaceController_deleteSpaceById {
    @Autowired
    private MockMvc mockMvc;

    //test case: trường hợp [id] = null.
    @Test
    public void deleteSpaceById_25() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/spaces/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //test case: trường hợp [id] = "".
    @Test
    public void deleteSpaceById_26() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/spaces/{id}","" ))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //test case: trường hợp [id] không tồn tại trong DB.
    @Test
    public void deleteSpaceById_27() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/spaces/{id}",1000 ))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //test case: trường hợp [id]  tồn tại trong DB.
    @Test
    public void deleteSpaceById_28() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/spaces/{id}",4 ))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(status().is4xxClientError());
    }
}
