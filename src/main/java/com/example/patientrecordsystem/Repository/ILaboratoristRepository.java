package com.example.patientrecordsystem.Repository;


import com.example.patientrecordsystem.Domain.Entity.Laboratorist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILaboratoristRepository extends JpaRepository<Laboratorist,Integer> {
}