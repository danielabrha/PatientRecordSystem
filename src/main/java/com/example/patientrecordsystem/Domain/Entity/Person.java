package com.example.patientrecordsystem.Domain.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.*;

@Component
@MappedSuperclass
public class Person {

    @NotEmpty
    @Size(min = 2, max = 30, message = "first Name should be between 2 and 30 chars")
    private String fName;

    @NotEmpty
    @Size(min = 2, max = 30, message = "last Name should be between 2 and 30 chars")
    private String lName;

    private String mName;

    @NotNull
    @Pattern(regexp = "(Male|Female|male|female|m|f)", message = "please put gender")
    private String gender;

    @NotEmpty
    @NotNull
    @Email(message = "Email must be a well formed email")
    @Column(unique = true)
    private String email;

    @Pattern(regexp="(^$|[0-9]{10})", message = "phone must be either empty or be 10 digits only")
    private String phoneNumber;

    private String address;


   @Pattern(regexp = "(^$|\\d{4}-\\d{2}-\\d{2})", message = "date of Birth should be YYYY-MM-DD")
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
