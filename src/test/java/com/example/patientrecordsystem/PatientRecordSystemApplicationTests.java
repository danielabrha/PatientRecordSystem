package com.example.patientrecordsystem;

import com.example.patientrecordsystem.Domain.Entity.*;
import com.example.patientrecordsystem.Repository.IPatientRepository;
import com.example.patientrecordsystem.Repository.IUserRepository;
import com.example.patientrecordsystem.Service.Implementation.PatientService;
import com.example.patientrecordsystem.Service.Implementation.UserService;
import com.example.patientrecordsystem.Service.Interface.IPatientService;
import com.example.patientrecordsystem.Service.Interface.IVisitService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest

class PatientRecordSystemApplicationTests {

    // 1. Test case for user controller

    //@Autowired
    //private MockMvc mockMvc;

    private int userId;
    private String userName;
    private String password;

    @MockBean
    private List<Role> roleList;
    @MockBean
    private Doctor doctor;
    @MockBean
    private Receptionst receptionst;
    @MockBean
    private Laboratorist laboratorist;
    @MockBean
    private SystemAdmin systemAdmin;
    @Autowired
    private UserService userService;


    @MockBean
    private IUserRepository userRepository;

    User user = new User("Weldmicheal","Berhanu", "Hailu", "male", "michock.mit@gmail.com",
            "+12345",  "MIU", "12062001", "username", "password", roleList, doctor, receptionst, laboratorist,
            systemAdmin);

    User user1 = new User("Weld","Berh", "Hailu", "male", "michock.mit@gmail.com",
            "+12345",  "MIU", "12062001", "username", "password", roleList, doctor, receptionst, laboratorist,
            systemAdmin);


    //User/post/data
    @Test
    public void postUserTest() {
        Mockito.when(userRepository.save(user)).thenReturn(user);
        assertEquals(user, userService.create(user));
    }

    @Test
    public void getUserTest() {
        Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(user));
        assertEquals(user, userService.findById(userId));
    }


    @Test
    public void getUsersTest() {
        Mockito.when(userRepository.findAll()).thenReturn(Arrays.asList(user, user1));
        assertEquals(2, userService.findAll().size());
    }


    // 2. Patient Test

    @MockBean
    private List<Visit> visitList;

    @Autowired
    private PatientService patientService;

    @MockBean
    private IPatientRepository patientRepository;


    Patient patient = new Patient("Weldmicheal","Berhanu", "Hailu", "male", "michock.mit@gmail.com",
            "+12345",  "MIU", "12062001", 10000, visitList);

    Patient patient1 = new Patient("Weldm","Berhanu", "Hailu", "male", "michock.mit@gmail.com",
            "+12345",  "MIU", "12062001", 10000, visitList);

    @Test
    public void postPatientTest() {
        Mockito.when(patientRepository.save(patient)).thenReturn(patient);
        assertEquals(patient, patientService.create(patient));
    }

    @Test
    public void postPatientsTest() {
        Mockito.when(patientRepository.saveAll(Arrays.asList(patient, patient1))).thenReturn(Arrays.asList(patient,
                patient1));
        assertEquals(2, patientService.findAll().size());
    }

    @Test
    public void deletePatientTest(){
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
