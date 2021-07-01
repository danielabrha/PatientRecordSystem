package com.example.patientrecordsystem.Repository;


import com.example.patientrecordsystem.Domain.Entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISymptomRepository extends JpaRepository<Symptom,Integer> {
}