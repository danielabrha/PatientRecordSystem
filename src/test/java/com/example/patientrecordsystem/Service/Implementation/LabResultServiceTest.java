package com.example.patientrecordsystem.Service.Implementation;

import com.example.patientrecordsystem.Domain.Entity.LabOrder;
import com.example.patientrecordsystem.Domain.Entity.LabResult;
import com.example.patientrecordsystem.Domain.Entity.Laboratorist;
import com.example.patientrecordsystem.Repository.ILabOrderRepository;
import com.example.patientrecordsystem.Repository.ILabResultRepository;
import com.example.patientrecordsystem.Repository.ILaboratoristRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)

class LabResultServiceTest {

    @InjectMocks
    private LabResultService labResultService;

    @Mock
    private LabOrderService labOrderService;
    @Mock
    private LaboratoristService laboratoristService;
    @MockBean
    private ILabOrderRepository labOrderRepository;

    @Mock
    private ILabResultRepository labResultRepository;


    @Mock
    private ILaboratoristRepository laboratoristRepository;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }
    //LabResult/post/data

    @Test
    public void postLabResultTest() {
        LabResult labResult = new LabResult();
        labResult.setLabResultName("Negative");
        LabOrder labOrder = new LabOrder();
        labOrder.setLabOrderId(1);
        labResult.setLabOrder(labOrder);
        Mockito.when(labResultRepository.save(labResult)).thenReturn(labResult);
        assertEquals(labResult, labResultService.create(labResult, labOrder.getLabOrderId()));
        Mockito.verify(labResultRepository).save(labResult);

    }


    @Test
    public void getLabResultTest() {
        LabResult labResult = new LabResult();
        labResult.setLabResultName("Free");
        labResult.setLabResultId(1);
        Mockito.when(labResultRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(labResult));
        assertEquals(labResult, labResultService.findById(labResult.getLabResultId()));
    }


    @Test
    public void getLabResultsTest() {
        LabResult labResult = new LabResult();
        labResult.setLabResultName("positive");
        LabResult labResult1 = new LabResult();
        labResult1.setLabResultName("negative");
        Mockito.when(labResultRepository.findAll()).thenReturn(Arrays.asList(labResult1, labResult));
        assertEquals(2, labResultService.findAll().size());
        Mockito.verify(labResultRepository).findAll();

    }
/*
    @Test
    public void getLabResultsTest() {
        LabResult labResult = new LabResult();
        LabResult labResult1 = new LabResult();
        List<LabResult> labResultList = new ArrayList<>();
        labResultList.add(labResult);
        labResultList.add(labResult1);
        given(labResultRepository.findAll()).willReturn(labResultList);
        List<LabResult> expected = labResultService.findAll();
        assertEquals(expected, labResultList);
    }
*/

    @Test
    public void deleteLabResultTest(){
        LabResult labResult = new LabResult();
        labResult.setLabResultName("Berhanu");
        labResult.setLabResultId(1);
        Mockito.when(labResultRepository.findById(labResult.getLabResultId())).thenReturn(Optional.of(labResult));
        labResultService.deleteById(labResult.getLabResultId());
        Mockito.verify(labResultRepository).deleteById(labResult.getLabResultId());
    }
/*
    @Test
    public void updateLabResultTest() {
        LabResult labResult = new LabResult();
        labResult.setfName("Weld");
        labResult.setlName("Ber");
        labResult.setAddress("MIU");
        labResult.setLabResultId(1);
        LabResult updatedLabResult = labResult;
        updatedLabResult.setfName("Weldmicheal");
        updatedLabResult.setlName("Berhanu");
        given(labResultRepository.findById(labResult.getLabResultId())).willReturn(Optional.of(labResult));
        labResultService.update(updatedLabResult, labResult.getLabResultId());
        Mockito.verify(labResultRepository).save(updatedLabResult);
        Mockito.verify(labResultRepository).findById(labResult.getLabResultId());
    }
*/
}