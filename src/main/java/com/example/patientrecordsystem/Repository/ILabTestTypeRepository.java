package com.example.patientrecordsystem.Repository;


import com.example.patientrecordsystem.Domain.Entity.LabTestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILabTestTypeRepository extends JpaRepository<LabTestType,Integer> {

    public List<LabTestType> findByLabTestTypeId(int labOrderId);
}

