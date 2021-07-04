package com.example.patientrecordsystem.Controller;

import com.example.patientrecordsystem.Domain.Entity.DrugOrder;
import com.example.patientrecordsystem.Domain.Entity.Drug;
import com.example.patientrecordsystem.Domain.Entity.Visit;
import com.example.patientrecordsystem.Service.Implementation.DrugOrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DrugOrderController.class)
public class DrugOrderControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DrugOrderService drugOrderService;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }
/*
    @Test
    public void createDrugOrderTest() throws Exception {
        DrugOrder drugOrder = new DrugOrder();
        Drug drug = new Drug();
        drug.setDrugId(1);
        Visit visit = new Visit();
        visit.setVisitId(1);
        drugOrder.setVisit(visit);
        drugOrder.setDrug(drug);
        given(drugOrderService.create(drugOrder, drug.getDrugId(), visit.getVisitId())).willReturn(drugOrder);
        mockMvc.perform(post("/DrugOrder/post/data/" + visit.getVisitId() + "/" + drug.getDrugId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(drugOrder)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.visit.visitId", is(1)));
        verify(drugOrderService, VerificationModeFactory.times(1))
                .create(drugOrder, drug.getDrugId(), visit.getVisitId());
        reset(drugOrderService);
    }
    @Test
    public void getDrugOrderTest() throws Exception {
        DrugOrder  drugOrder = new DrugOrder();
        drugOrder.setDrugOrderId(1);
        Drug drug = new Drug();
        drug.setDrugId(1);
        Visit visit = new Visit();
        visit.setVisitId(1);
        drugOrder.setVisit(visit);
        drugOrder.setDrug(drug);
        given(drugOrderService.findById(drugOrder.getDrugOrderId())).willReturn(drugOrder);
        mockMvc.perform(get("/DrugOrder/get/data/" + drugOrder.getDrugOrderId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.drugOrderId", is(drugOrder.getDrugOrderId())));
    }

    @Test
    public void deleteDrugOrderTest() throws Exception {
        DrugOrder  drugOrder = new DrugOrder();
        drugOrder.setDrugOrderId(1);
        doNothing().when(drugOrderService).deleteById(drugOrder.getDrugOrderId());
        mockMvc.perform(delete("/DrugOrder/deleteById/data/" + drugOrder.getDrugOrderId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(true)));
    }
    */
}