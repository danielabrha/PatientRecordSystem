package com.example.patientrecordsystem.Repository;

import com.example.patientrecordsystem.Domain.Entity.*;
import com.example.patientrecordsystem.Service.Implementation.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class IUserRepositoryTest {


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

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    User user = new User("Weldmicheal", "Berhanu", "Hailu", "male", "michock.mit@gmail.com",
            "+12345", "MIU", "12062001", "username", "password", roleList);

    @Test
    final void getUserTest() {
        //user.setUserName("gg");
        Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(user));
        User user1 = userService.findById(Mockito.anyInt());
        assertNotNull(user1);
        assertEquals("Weldmicheal", user1.getfName());
    }


}