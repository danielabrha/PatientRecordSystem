package com.example.patientrecordsystem.Controller;

import com.example.patientrecordsystem.Domain.Entity.LabOrder;
import com.example.patientrecordsystem.Domain.Entity.User;
import com.example.patientrecordsystem.Service.Implementation.LabOrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LabOrderController.class)
class LabOrderControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LabOrderService labOrderService;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createLabOrderTest() throws Exception {
        LabOrder labOrder = new LabOrder();

        given(labOrderService.create(Mockito.any(), Mockito.any(), Mockito.any())).willReturn(labOrder);
        mockMvc.perform(post("/LabOrder/post/data/" + Mockito.any() + "/" + Mockito.any() + "/" + Mockito.any())
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(labOrder)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fName", is("Wldmicheal")));
        verify(labOrderService, VerificationModeFactory.times(1))
                .create(Mockito.any(), Mockito.any(), Mockito.any());
        reset(labOrderService);
    }
    @Test
    public void getLabOrderTest() throws Exception {
        LabOrder  labOrder = new LabOrder();
        labOrder.setLabOrderId(1);
        given(labOrderService.findById(labOrder.getLabOrderId())).willReturn(labOrder);
        mockMvc.perform(get("/LabOrder/get/data/" + labOrder.getLabOrderId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].labOrderId", is(labOrder.getLabOrderId())));
    }

    @Test
    public void deleteUserTest() throws Exception {
        User user = new User();
        user.setfName("Weldmicheal");
        user.setUserId(1);
        doNothing().when(labOrderService).deleteById(user.getUserId());
        mockMvc.perform(delete("/User/delete/" + Integer.toString(user.getUserId()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(true)));
    }

    @Test
    public void getUserTest() throws Exception{
        User user = new User();
        user.setfName("Weldmicheal");
        user.setUserId(1);
        //given(labOrderService.findById(user.getUserId())).willReturn();
        mockMvc.perform(get("/User/get/data/" + Integer.toString(user.getUserId()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fName", is(user.getfName())));
    }
}