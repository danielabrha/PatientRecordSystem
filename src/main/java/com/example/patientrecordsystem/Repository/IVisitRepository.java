package com.example.patientrecordsystem.Repository;


import com.example.patientrecordsystem.Domain.Entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVisitRepository extends JpaRepository<Visit,Integer> {
}
