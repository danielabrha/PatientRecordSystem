package com.example.patientrecordsystem.Controller;

import com.example.patientrecordsystem.Domain.Entity.LabOrder;
import com.example.patientrecordsystem.Domain.Entity.LabTestType;
import com.example.patientrecordsystem.Domain.Entity.User;
import com.example.patientrecordsystem.Domain.Entity.Visit;
import com.example.patientrecordsystem.Service.Implementation.LabOrderService;
import org.hamcrest.Matchers;
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

import java.util.LinkedHashMap;

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
        LabTestType labTestType = new LabTestType();
        labTestType.setLabTestTypeId(1);
        Visit visit = new Visit();
        visit.setVisitId(1);
        labOrder.setVisit(visit);
        labOrder.setLabTestType(labTestType);
        given(labOrderService.create(visit.getVisitId(), labTestType.getLabTestTypeId())).willReturn(labOrder);
        mockMvc.perform(post("/LabOrder/post/data/" + visit.getVisitId() + "/" + labTestType.getLabTestTypeId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(labOrder)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.visit.visitId", is(1)));
        verify(labOrderService, VerificationModeFactory.times(1))
                .create(visit.getVisitId(), labTestType.getLabTestTypeId());
        reset(labOrderService);
    }
    @Test
    public void getLabOrderTest() throws Exception {
        LabOrder  labOrder = new LabOrder();
        labOrder.setLabOrderId(1);
        LabTestType labTestType = new LabTestType();
        labTestType.setLabTestTypeId(1);
        Visit visit = new Visit();
        visit.setVisitId(1);
        labOrder.setVisit(visit);
        labOrder.setLabTestType(labTestType);
        given(labOrderService.findById(labOrder.getLabOrderId())).willReturn(labOrder);
        mockMvc.perform(get("/LabOrder/get/data/" + labOrder.getLabOrderId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.labOrderId", is(labOrder.getLabOrderId())));
    }

    @Test
    public void deleteLabOrderTest() throws Exception {
        LabOrder  labOrder = new LabOrder();
        labOrder.setLabOrderId(1);
        doNothing().when(labOrderService).deleteById(labOrder.getLabOrderId());
        mockMvc.perform(delete("/LabOrder/deleteById/data/" + labOrder.getLabOrderId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(true)));
    }

    @Test
    public void getLabOrderTest() throws Exception{
        LabOrder  labOrder = new LabOrder();
        labOrder.setLabOrderId(1);
        //given(labOrderService.findById(user.getUserId())).willReturn();
        mockMvc.perform(get("/User/get/data/" + Integer.toString(user.getUserId()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fName", is(user.getfName())));
    }
}