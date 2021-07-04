package com.example.patientrecordsystem.Controller;

import com.example.patientrecordsystem.Domain.Entity.*;
import com.example.patientrecordsystem.Repository.IUserRepository;
import com.example.patientrecordsystem.Service.Implementation.UserService;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void createUserTest() throws Exception {
        User user = new User();
        user.setfName("Weldmicheal");
        given(userService.create(Mockito.any())).willReturn(user);
        mockMvc.perform(post("/User/post/data")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fName", is("Weldmicheal")));
        verify(userService, VerificationModeFactory.times(1))
                .create(Mockito.any());
        reset(userService);
    }
    @Test
    public void getUsersTest() throws Exception {
        User user1 = new User();
        user1.setfName("Weldmicheal");
        User user2 = new User();
        user2.setfName("Berhanu");
        List<User> userList = Arrays.asList(user1, user2);
        given(userService.findAll()).willReturn(userList);
        mockMvc.perform(get("/User/get/All/data")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].fName", is(user1.getfName())));
    }

    @Test
    public void deleteUserTest() throws Exception {
        User user = new User();
        user.setfName("Weldmicheal");
        user.setUserId(1);
        doNothing().when(userService).deleteById(user.getUserId());
        mockMvc.perform(delete("/User/delete/" + Integer.toString(user.getUserId()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(true)));
    }

    @Test
    public void getUserTest() throws Exception{
        User user = new User();
        user.setfName("Weldmicheal");
        user.setUserId(1);
        given(userService.findById(user.getUserId())).willReturn(user);
        mockMvc.perform(get("/User/get/data/" + Integer.toString(user.getUserId()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fName", is(user.getfName())));
    }
/*
    @Test
    public void updateUserTest() throws Exception{
        User user = new User("Weldmicheal","Berhanu", "Hailu", "male", "michock.mit@gmail.com",
                "+12345",  "MIU", "12062001",1, "username", "password", null);

        when(userService.findById(user.getUserId())).thenReturn(user);
        User updatedUser = userService.update(user, user.getUserId());
        mockMvc.perform(put("/User/update/{id}", user.getUserId())
                .content(JsonUtil.toJson(user))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//        verify(userService, VerificationModeFactory.times(1)).findById(user.getUserId());
//        verify(userService, times(1)).update(user, user.getUserId());
//        verifyNoMoreInteractions(userService);
        verify(userService, VerificationModeFactory.times(1))
                .update(updatedUser, updatedUser.getUserId());
        reset(userService);
    }
*/
}