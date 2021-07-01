package com.example.patientrecordsystem.Repository;


import com.example.patientrecordsystem.Domain.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer> {

    // public Patient findByCardNumber(int cardRecordNumber);
}

