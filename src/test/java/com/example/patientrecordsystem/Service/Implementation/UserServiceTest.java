package com.example.patientrecordsystem.Service.Implementation;

import com.example.patientrecordsystem.Domain.Entity.*;
import com.example.patientrecordsystem.Repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
class UserServiceTest {


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
            "+12345",  "MIU", "12062001", "username", "password", roleList);

    User user1 = new User("Weld","Berh", "Hailu", "male", "michock.mit@gmail.com",
            "+12345",  "MIU", "12062001", "username", "password", roleList);

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
    public void whenPostUser_shouldReturnUser() {
        User user = new User();
        user.setfName("Daniel");
        Mockito.when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);
        User created = userService.create(user);
        assertThat(created.getfName()).isSameAs(user.getfName());
        Mockito.verify(userRepository).save(user);
    }


    @Test
    public void getUserTest() {
        Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(user));
        assertEquals(user, userService.findById(userId));
    }


//    @Test
//    public void getUsersTest() {
//        Mockito.when(userRepository.findAll()).thenReturn(Arrays.asList(user, user1));
//        assertEquals(2, userService.findAll().size());
//    }

    @Test
    public void getUsersTest() {
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        given(userRepository.findAll()).willReturn(users);
        List<User> expected = userService.findAll();
        assertEquals(expected, users);
        Mockito.verify(userRepository).findAll();
    }


    @Test
    public void TestDeleteUserIfFound(){
        User user = new User();
        user.setlName("Berhanu");
        user.setUserId(1);
        Mockito.when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
        userService.deleteById(user.getUserId());
        Mockito.verify(userRepository).deleteById(user.getUserId());
    }

    @Test
    public void updateUserTest() {
        User user = new User();
        user.setfName("Weld");
        user.setlName("Ber");
        user.setAddress("MIU");
        user.setUserId(1);
        User updatedUser = user;
        updatedUser.setfName("Weldmicheal");
        updatedUser.setlName("Berhanu");
        given(userRepository.findById(user.getUserId())).willReturn(Optional.of(user));
        userService.update(updatedUser, user.getUserId());
        Mockito.verify(userRepository).save(updatedUser);
        Mockito.verify(userRepository).findById(user.getUserId());
    }

}