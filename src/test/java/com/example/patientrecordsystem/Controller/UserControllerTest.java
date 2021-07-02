package com.example.patientrecordsystem.Controller;

import com.example.patientrecordsystem.Domain.Entity.*;
import com.example.patientrecordsystem.Repository.IUserRepository;
import com.example.patientrecordsystem.Service.Implementation.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)

class UserControllerTest {


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

    @InjectMocks
    private UserService userService;


    @Mock
    private IUserRepository userRepository;

    User user = new User("Weldmicheal","Berhanu", "Hailu", "male", "michock.mit@gmail.com",
            "+12345",  "MIU", "12062001", "username", "password", roleList, doctor, receptionst, laboratorist,
            systemAdmin);

    User user1 = new User("Weld","Berh", "Hailu", "male", "michock.mit@gmail.com",
            "+12345",  "MIU", "12062001", "username", "password", roleList, doctor, receptionst, laboratorist,
            systemAdmin);

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }
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

    @Test
    public void updateUserTest(){
        Mockito.when(userRepository.)
    }

}