package com.example.patientrecordsystem.Repository;



import com.example.patientrecordsystem.Domain.Entity.LabOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILabOrderRepository extends JpaRepository<LabOrder,Integer> {

}

