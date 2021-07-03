package com.example.patientrecordsystem.Controller;

import com.example.patientrecordsystem.Domain.Entity.LabResult;
import com.example.patientrecordsystem.Domain.Entity.User;
import com.example.patientrecordsystem.Service.Implementation.LabResultService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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

    @Test
    public void createLabResultTest() throws Exception {
        LabResult labResult = new LabResult();
        labResult.setLabResultName("positive");
        given(labResultService.create(Mockito.any(), Mockito.anyInt(), Mockito.anyInt())).willReturn(labResult);
        mockMvc.perform(post("/LabResult/post/data/" + Mockito.anyInt() + "/" + Mockito.anyInt())
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(labResult)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fName", is("Wldmicheal")));
        verify(labResultService, VerificationModeFactory.times(1))
                .create(Mockito.any(), Mockito.any(), Mockito.any());
        reset(labResultService);
    }
    @Test
    public void getLabResultTest() throws Exception {
        LabResult  labResult = new LabResult();
        labResult.setLabResultId(1);
        given(labResultService.findById(labResult.getLabResultId())).willReturn(labResult);
        mockMvc.perform(get("/LabResult/get/data/" + labResult.getLabResultId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].labResultId", is(labResult.getLabResultId())));
    }

    @Test
    public void deleteUserTest() throws Exception {
        User user = new User();
        user.setfName("Weldmicheal");
        user.setUserId(1);
        doNothing().when(labResultService).deleteById(user.getUserId());
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
        //given(labResultService.findById(user.getUserId())).willReturn();
        mockMvc.perform(get("/User/get/data/" + Integer.toString(user.getUserId()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fName", is(user.getfName())));
    }
}