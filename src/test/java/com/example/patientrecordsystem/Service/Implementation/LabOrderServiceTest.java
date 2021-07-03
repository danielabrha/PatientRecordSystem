package com.example.patientrecordsystem.Service.Implementation;

import com.example.patientrecordsystem.Domain.Entity.LabOrder;
import com.example.patientrecordsystem.Domain.Entity.LabTestType;
import com.example.patientrecordsystem.Domain.Entity.Visit;
import com.example.patientrecordsystem.Repository.IDoctorRepository;
import com.example.patientrecordsystem.Repository.ILabOrderRepository;
import com.example.patientrecordsystem.Repository.IVisitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
class LabOrderServiceTest {


    @InjectMocks
    private LabOrderService labOrderService;

    @Mock
    private VisitService visitService;

    @Mock
    private DoctorService doctorService;

    @Mock
    private LabTestTypeService labTestTypeService;

    @Mock
    private ILabOrderRepository labOrderRepository;

    @Mock
    private IVisitRepository visitRepository;

    @Mock
    private IDoctorRepository doctorRepository;


    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void postLabOrderTest() {
        LabOrder labOrder = new LabOrder();
        LabTestType labTestType = new LabTestType();
        labTestType.setLabTestTypeId(1);
        Visit visit = new Visit();
        visit.setVisitId(1);
        labOrder.setVisit(visit);
        labOrder.setLabTestType(labTestType);
        Mockito.when(labOrderRepository.save(ArgumentMatchers.any(LabOrder.class))).thenReturn(labOrder);
        LabOrder created = labOrderService.create(visit.getVisitId(), labTestType.getLabTestTypeId());
        assertEquals(labOrder, created);

    }




    @Test
    public void getLabOrderTest() {
        LabOrder labOrder = new LabOrder();
        labOrder.setLabOrderId(1);
        Mockito.when(labOrderRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(labOrder));
        assertEquals(labOrder, labOrderService.findById(labOrder.getLabOrderId()));
    }


    @Test
    public void getLabOrdersTest() {
        LabOrder labOrder = new LabOrder();
        LabOrder labOrder1 = new LabOrder();
        labOrder.setLabOrderId(1);
        labOrder1.setLabOrderId(2);
        Mockito.when(labOrderRepository.findAll()).thenReturn(Arrays.asList(labOrder, labOrder1));
        assertEquals(2, labOrderService.findAll().size());
        List<LabOrder> expected = labOrderService.findAll();

        assertEquals(expected, Arrays.asList(labOrder, labOrder1));
        Mockito.verify(labOrderRepository).findAll();

    }

    @Test
    public void deleteLabOrderTest(){
        LabOrder labOrder = new LabOrder();
        labOrder.setLabOrderId(1);
        Mockito.when(labOrderRepository.findById(labOrder.getLabOrderId())).thenReturn(Optional.of(labOrder));
        labOrderService.deleteById(labOrder.getLabOrderId());
        Mockito.verify(labOrderRepository).deleteById(labOrder.getLabOrderId());
    }

    @Test
    public void updateLabOrderTest() {

        LabOrder labOrder = new LabOrder();
        labOrder.setLabOrderId(1);
        LabOrder updatedLabOrder = labOrder;
        LabTestType labTestType = new LabTestType();
        labTestType.setLabTestTypeId(1);
        Visit visit = new Visit();
        visit.setVisitId(1);
        updatedLabOrder.setVisit(visit);
        updatedLabOrder.setLabTestType(labTestType);
        Mockito.when(labOrderRepository.findById(labOrder.getLabOrderId())).thenReturn(Optional.of(labOrder));
        labOrderService.update(updatedLabOrder, visit.getVisitId(), labTestType.getLabTestTypeId());
        Mockito.verify(labOrderRepository).save(updatedLabOrder);
        Mockito.verify(labOrderRepository).findById(labOrder.getLabOrderId());
    }

}