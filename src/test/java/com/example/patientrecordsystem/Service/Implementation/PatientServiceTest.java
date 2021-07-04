package com.example.patientrecordsystem.Service.Implementation;

import com.example.patientrecordsystem.Domain.Entity.Patient;
import com.example.patientrecordsystem.Domain.Entity.Visit;
import com.example.patientrecordsystem.Repository.IPatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
class PatientServiceTest {

    @MockBean
    private List<Visit> visitList;

    @InjectMocks
    private PatientService patientService;

    @Mock
    private IPatientRepository patientRepository;


    Patient patient = new Patient("Weldmicheal","Berhanu", "Hailu", "male", "michock.mit@gmail.com",
            "+12345",  "MIU", "12062001", 10000, visitList);

    Patient patient1 = new Patient("Weldm","Berhanu", "Hailu", "male", "michock.mit@gmail.com",
            "+12345",  "MIU", "12062001", 10000, visitList);


    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void postPatientTest() {
        Mockito.when(patientRepository.save(patient)).thenReturn(patient);
        assertEquals(patient, patientService.create(patient));
    }
/*
    @Test
    public void postPatientsTest() {
        Mockito.when(patientRepository.saveAll(Arrays.asList(patient, patient1))).thenReturn(Arrays.asList(patient,
                patient1));
        assertEquals(2, patientService.findAll().size());
    }
*/
    @Test
    public void deletePatientTest(){
        patientService.deleteById(patient.getPatientId());
        //assertEquals(null, patientService.findById(patient.getPatientId()));
        verify(patientRepository, times(1)).deleteById(patient.getPatientId());
    }

    @Test
    public void deletePatientsTest(){
        patientService.deleteById(patient.getPatientId());
        //assertEquals(null, patientService.findById(patient.getPatientId()));
        verify(patientRepository, times(1)).deleteById(patient.getPatientId());
    }

    @Test
    public void getPatient(){
        when(patientRepository.findAll()).thenReturn(Arrays.asList(patient, patient1));
        assertEquals(2, patientService.findAll().size());
    }
}