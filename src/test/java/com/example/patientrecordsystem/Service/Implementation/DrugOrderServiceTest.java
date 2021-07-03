package com.example.patientrecordsystem.Service.Implementation;

import com.example.patientrecordsystem.Domain.Entity.DrugOrder;
import com.example.patientrecordsystem.Domain.Entity.Drug;
import com.example.patientrecordsystem.Domain.Entity.Visit;
import com.example.patientrecordsystem.Repository.IDrugRepository;
import com.example.patientrecordsystem.Repository.IDrugOrderRepository;
import com.example.patientrecordsystem.Repository.IVisitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
class DrugOrderServiceTest {


    @InjectMocks
    private DrugOrderService drugOrderService;

    @Mock
    private VisitService visitService;

    @Mock
    private DrugService drugService;

    @Mock
    private IDrugOrderRepository drugOrderRepository;

    @Mock
    private IVisitRepository visitRepository;

    @Mock
    private IDrugRepository drugRepository;


    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void postDrugOrderTest() {
        DrugOrder drugOrder = new DrugOrder();
        Drug drug = new Drug();
        drug.setDrugId(1);
        Visit visit = new Visit();
        visit.setVisitId(1);
        drugOrder.setVisit(visit);
        drugOrder.setDrug(drug);
        Mockito.when(drugOrderRepository.save(ArgumentMatchers.any(DrugOrder.class))).thenReturn(drugOrder);
        DrugOrder created = drugOrderService.create(drugOrder, drug.getDrugId(), visit.getVisitId());
        assertEquals(drugOrder, created);

    }




    @Test
    public void getDrugOrderTest() {
        DrugOrder drugOrder = new DrugOrder();
        drugOrder.setDrugOrderId(1);
        Mockito.when(drugOrderRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(drugOrder));
        assertEquals(drugOrder, drugOrderService.findById(drugOrder.getDrugOrderId()));
    }



    @Test
    public void deleteDrugOrderTest(){
        DrugOrder drugOrder = new DrugOrder();
        drugOrder.setDrugOrderId(1);
        Mockito.when(drugOrderRepository.findById(drugOrder.getDrugOrderId())).thenReturn(Optional.of(drugOrder));
        drugOrderService.deleteById(drugOrder.getDrugOrderId());
        Mockito.verify(drugOrderRepository).deleteById(drugOrder.getDrugOrderId());
    }

    @Test
    public void updateDrugOrderTest() {

        DrugOrder drugOrder = new DrugOrder();
        drugOrder.setDrugOrderId(1);
        DrugOrder updatedDrugOrder = drugOrder;
        Drug drug = new Drug();
        drug.setDrugId(1);
        Visit visit = new Visit();
        visit.setVisitId(1);
        updatedDrugOrder.setVisit(visit);
        updatedDrugOrder.setDrug(drug);
        Mockito.when(drugOrderRepository.findById(drugOrder.getDrugOrderId())).thenReturn(Optional.of(drugOrder));
        drugOrderService.update(updatedDrugOrder, visit.getVisitId(), drug.getDrugId());
        Mockito.verify(drugOrderRepository).save(updatedDrugOrder);
        Mockito.verify(drugOrderRepository).findById(drugOrder.getDrugOrderId());
    }
}