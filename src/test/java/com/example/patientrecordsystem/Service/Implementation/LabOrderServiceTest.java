package com.example.patientrecordsystem.Service.Implementation;

import com.example.patientrecordsystem.Domain.Entity.LabOrder;
import com.example.patientrecordsystem.Repository.IDoctorRepository;
import com.example.patientrecordsystem.Repository.ILabOrderRepository;
import com.example.patientrecordsystem.Repository.IVisitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
class LabOrderServiceTest {





    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

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


    //LabOrder/post/data
   /*
    @Test
    public void postLabOrderTest() {
        LabOrder labOrder = new LabOrder();
        labOrder.setLabTestType(labTestType);
        labOrder.setVisit(visit);
        labOrder.setDoctor(doctor);
        Mockito.when(labOrderRepository.save(labOrder)).thenReturn(labOrder);
        assertEquals(labOrder, labOrderService.create(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt()));
    }
    */

    @Test
    public void postLabOrderTest() {
        LabOrder labOrder = new LabOrder();
        labOrder.setLabOrderId(1);
        Mockito.when(labOrderRepository.save(ArgumentMatchers.any(LabOrder.class))).thenReturn(labOrder);
        LabOrder created = labOrderService.create(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());
        Mockito.verify(labOrderRepository).save(labOrder);
    }

/*
    @Test
    public void getLabOrderTest() {
        Mockito.when(labOrderRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(user));
        assertEquals(user, labOrderService.findById(userId));
    }


//    @Test
//    public void getLabOrdersTest() {
//        Mockito.when(labOrderRepository.findAll()).thenReturn(Arrays.asList(user, user1));
//        assertEquals(2, labOrderService.findAll().size());
//    }

    @Test
    public void getLabOrdersTest() {
        List<LabOrder> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        given(labOrderRepository.findAll()).willReturn(users);
        List<LabOrder> expected = labOrderService.findAll();
        assertEquals(expected, users);
        Mockito.verify(labOrderRepository).findAll();
    }


    @Test
    public void TestDeleteLabOrderIfFound(){
        LabOrder user = new LabOrder();
        user.setlName("Berhanu");
        user.setLabOrderId(1);
        Mockito.when(labOrderRepository.findById(user.getLabOrderId())).thenReturn(Optional.of(user));
        labOrderService.deleteById(user.getLabOrderId());
        Mockito.verify(labOrderRepository).deleteById(user.getLabOrderId());
    }

    @Test
    public void updateLabOrderTest() {
        LabOrder user = new LabOrder();
        user.setfName("Weld");
        user.setlName("Ber");
        user.setAddress("MIU");
        user.setLabOrderId(1);
        LabOrder updatedLabOrder = user;
        updatedLabOrder.setfName("Weldmicheal");
        updatedLabOrder.setlName("Berhanu");
        given(labOrderRepository.findById(user.getLabOrderId())).willReturn(Optional.of(user));
        labOrderService.update(updatedLabOrder, user.getLabOrderId());
        Mockito.verify(labOrderRepository).save(updatedLabOrder);
        Mockito.verify(labOrderRepository).findById(user.getLabOrderId());
    }
*/
}