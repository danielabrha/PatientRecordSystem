package com.example.patientrecordsystem.Repository;


import com.example.patientrecordsystem.Domain.Entity.Receptionst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceptionstRepository extends JpaRepository<Receptionst,Integer> {
}
