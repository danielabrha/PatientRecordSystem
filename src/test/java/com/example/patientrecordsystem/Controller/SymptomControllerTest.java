package com.example.patientrecordsystem.Controller;

import com.example.patientrecordsystem.Domain.Entity.Patient;
import com.example.patientrecordsystem.Domain.Entity.Symptom;
import com.example.patientrecordsystem.Domain.Entity.Visit;
import com.example.patientrecordsystem.Service.Implementation.SymptomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SymptomController.class)
class SymptomControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    @MockBean
    private SymptomService symptomService;
/*
    @Test
    void postSymptom() throws Exception {
        Symptom symptom = new Symptom();
        symptom.setSymptomId(1);
        symptom.setSymptomName("Amonia");
        Visit visit = new Visit();
        visit.setVisitId(1);
        symptom.setVisit(visit);
        given(symptomService.create(symptom,visit.getVisitId())).willReturn(symptom);
        mockMvc.perform(post("/Symptom/post/data/"+Integer.toString(symptom.getSymptomId()))

                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(symptom)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.symptomName", is("Amonia")));
                 verify(symptomService, VerificationModeFactory.times(1))
                .create(symptom,visit.getVisitId());
        reset(symptomService);
    }
    */

    @Test
    void getSymptom() throws Exception {
        Symptom symptom = new Symptom();
        symptom.setSymptomName("Amonia");
        symptom.setSymptomId(1);
        given(symptomService.findById(symptom.getSymptomId())).willReturn(symptom);
        mockMvc.perform(get("/Symptom/get/data/" + Integer.toString(symptom.getSymptomId()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.symptomName", is(symptom.getSymptomName())));
    }

    @Test
    void getAllSymptom() throws Exception {
        Symptom symptom1 = new Symptom();
        symptom1.setSymptomName("Amonia");
        Symptom symptom2 = new Symptom();
        symptom2.setSymptomName("Headache");
        List<Symptom> symptomList = Arrays.asList(symptom1, symptom2);
        given(symptomService.findAll()).willReturn(symptomList);
        mockMvc.perform(get("/Symptom/Symptoms/get/All/data")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].symptomName", is(symptom1.getSymptomName())));
    }
}