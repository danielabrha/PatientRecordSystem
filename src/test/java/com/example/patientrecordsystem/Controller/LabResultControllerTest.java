package com.example.patientrecordsystem.Controller;

import com.example.patientrecordsystem.Domain.Entity.*;
import com.example.patientrecordsystem.Repository.ILabOrderRepository;
import com.example.patientrecordsystem.Repository.ILabResultRepository;
import com.example.patientrecordsystem.Service.Implementation.LabOrderService;
import com.example.patientrecordsystem.Service.Implementation.LabResultService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

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
@WebMvcTest(LabResultController.class)
class LabResultControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LabResultService labResultService;


    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

/*
    @Test
    public void createLabResultTest() throws Exception {
        LabResult labResult = new LabResult();
        labResult.setLabResultName("positive");
        LabOrder labOrder = new LabOrder();
        labOrder.setLabOrderId(1);
        labResult.setLabOrder(labOrder);
        given(labResultService.create(labResult, labOrder.getLabOrderId())).willReturn(labResult);
        mockMvc.perform(post("/LabResult/post/data/" + labOrder.getLabOrderId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(labResult)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(1)));
        verify(labResultService, VerificationModeFactory.times(1))
                .create(labResult, labOrder.getLabOrderId());
        reset(labResultService);
    }
*/
    @Test
    public void getLabResultTest() throws Exception {
        LabResult  labResult = new LabResult();
        labResult.setLabResultId(1);

        LabOrder labOrder = new LabOrder();
        labOrder.setLabOrderId(2);
        labResult.setLabOrder(labOrder);
        given(labResultService.findById(labResult.getLabResultId())).willReturn(labResult);
        mockMvc.perform(get("/LabResult/get/data/" + labResult.getLabResultId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.labOrder.labOrderId", is(labOrder.getLabOrderId())));
    }


    @Test
    public void deleteLabResultTest() throws Exception {
        LabResult  labResult = new LabResult();
        labResult.setLabResultId(1);
        doNothing().when(labResultService).deleteById(labResult.getLabResultId());
        mockMvc.perform(delete("/LabResult/deleteById/data/" + labResult.getLabResultId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(true)));
    }

}