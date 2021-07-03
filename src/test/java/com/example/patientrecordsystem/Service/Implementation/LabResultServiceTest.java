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

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)

class LabResultServiceTest {


    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

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


    //LabResult/post/data
   /*
    @Test
    public void postLabResultTest() {
        LabResult labResult = new LabResult();
        labResult.setLabTestType(labTestType);
        labResult.setVisit(visit);
        labResult.setDoctor(doctor);
        Mockito.when(labResultRepository.save(labResult)).thenReturn(labResult);
        assertEquals(labResult, labResultService.create(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt()));
    }
    */
/*
    @Test
    public void postLabResultTest() {
        LabResult labResult = new LabResult();
        labResult.setLabResultName("BloodP");
        LabOrder labOrder = new LabOrder();
        Laboratorist laboratorist = new Laboratorist();
        Mockito.when(labResultRepository.save(ArgumentMatchers.any(LabResult.class))).thenReturn(labResult);
        //Mockito.when(labResultService.toLabResult(labResult, eq(Mockito.anyInt()), eq(Mockito.anyInt())))
        // .thenReturn(labResult);
        System.out.println("Hello");

        given(labResultService.create(Mockito.any(), Mockito.anyInt(), Mockito.anyInt())).willReturn(labResult);
        Mockito.verify(labResultRepository).save(labResult);
    }
*/

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
    }
///*
//    @Test
//    public void getLabResultsTest() {
//        List<LabResult> labResults = new ArrayList<>();
//        labResults.add(labResult);
//        labResults.add(labResult1);
//        given(labResultRepository.findAll()).willReturn(labResults);
//        List<LabResult> expected = labResultService.findAll();
//        assertEquals(expected, labResults);
//        Mockito.verify(labResultRepository).findAll();
//    }


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