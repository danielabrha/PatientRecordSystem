package com.example.patientrecordsystem.Repository;


import com.example.patientrecordsystem.Domain.Entity.SystemAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISystemAdminRepository extends JpaRepository<SystemAdmin,Integer> {
    @Query(value = "SELECT * FROM SystemAdmins u WHERE u.status = 1",
            nativeQuery = true)
    public SystemAdmin getByName(String name);
}