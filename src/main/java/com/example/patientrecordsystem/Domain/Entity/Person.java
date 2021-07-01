package com.example.patientrecordsystem.Domain.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.MappedSuperclass;

@Component
@MappedSuperclass
public class Person {
    private String fName;
    private String lName;
    private String mName;
    private String gender;
    private String email;
    private String phoneNumber;
    private String address;
    private String dateOfBirth;

    public Person(String fName, String lName, String mName, String gender, String email,
                  String phoneNumber, String address, String dateOfBirth) {
        this.fName = fName;
        this.lName = lName;
        this.mName = mName;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public Person() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
