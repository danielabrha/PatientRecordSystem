package com.example.patientrecordsystem.Controller;

import com.example.patientrecordsystem.Domain.Entity.Patient;
import com.example.patientrecordsystem.Domain.Entity.User;
import com.example.patientrecordsystem.Domain.Entity.Visit;
import com.example.patientrecordsystem.Repository.IPatientRepository;
import com.example.patientrecordsystem.Service.Implementation.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PatientController.class)
class PatientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Autowired
    private PatientService patientService;

    @Test
    public void createPatientTest() throws Exception {
        Patient patient = new Patient("Weldmicheal","Berhanu", "Hailu", "male", "michock.mit@gmail.com",
                "1234567890",  "MIU", "2012-20-01", 10000,null);


        given(patientService.create(Mockito.any())).willReturn(patient);
        mockMvc.perform(post("/Patient/post/data")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(patient)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fName", is("Weldmicheal")));
                verify(patientService, VerificationModeFactory.times(1))
                .create(Mockito.any());
        reset(patientService);
    }
    @Test
    public void getUsersTest() throws Exception {
        Patient patient1 = new Patient();
        patient1.setfName("Weldmicheal");
        Patient patient2 = new Patient();
        patient2.setfName("Berhanu");
        List<Patient> patientList = Arrays.asList(patient1, patient2);
        given(patientService.findAll()).willReturn(patientList);
        mockMvc.perform(get("/Patient/get/All/data")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].fName", is(patient1.getfName())));
    }

   @Test
    public void deletePatientTest() throws Exception {
        Patient patient = new Patient();
        patient.setfName("Weldmicheal");
        patient.setPatientId(1);
        doNothing().when(patientService).deleteById(patient.getPatientId());
        mockMvc.perform(delete("/Patient/delete/" + Integer.toString(patient.getPatientId()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(true)));
    }

    @Test
    public void getPatientTest() throws Exception{
        Patient patient = new Patient();
        patient.setfName("Weldmicheal");
        patient.setPatientId(1);
        given(patientService.findById(patient.getPatientId())).willReturn(patient);
        mockMvc.perform(get("/Patient/get/data/" + Integer.toString(patient.getPatientId()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fName", is(patient.getfName())));
    }

   /* @Test
    public void updatePatientTest() throws Exception{
        Patient patient = new Patient();
        patient.setfName("Weldmieal");
        patient.setPatientId(2);
        //User updatedUser = new User();
        //updatedUser = user;
        //updatedUser.setfName("Weldmicheal");
        given(patientService.update(patient, patient.getPatientId())).willReturn(patient);
        mockMvc.perform(put("/Patient/update/" + patient.getPatientId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(patient)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fName", is(patient.getfName())));
    }*/



}