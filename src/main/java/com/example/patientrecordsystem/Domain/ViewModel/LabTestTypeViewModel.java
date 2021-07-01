package com.example.patientrecordsystem.Domain.ViewModel;



import com.example.patientrecordsystem.Domain.Entity.LabOrder;
import com.example.patientrecordsystem.Domain.Entity.SystemAdmin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LabTestTypeViewModel {
    private int labTestTypeId;
    private String labTestName;
    private String labTestCode;
    private SystemAdmin systemAdmin;
    private List<LabOrder> labOrderList;

    public LabTestTypeViewModel(int labTestTypeId, String labTestName, String labTestCode, SystemAdmin systemAdmin, List<LabOrder> labOrderList) {
        this.labTestTypeId = labTestTypeId;
        this.labTestName = labTestName;
        this.labTestCode = labTestCode;
        this.systemAdmin = systemAdmin;
        this.labOrderList = labOrderList;
    }

    public LabTestTypeViewModel(String labTestName, String labTestCode, SystemAdmin systemAdmin, List<LabOrder> labOrderList) {
        this.labTestName = labTestName;
        this.labTestCode = labTestCode;
        this.systemAdmin = systemAdmin;
        this.labOrderList = labOrderList;
    }

    public LabTestTypeViewModel() {
    }

    public int getLabTestTypeId() {
        return labTestTypeId;
    }

    public void setLabTestTypeId(int labTestTypeId) {
        this.labTestTypeId = labTestTypeId;
    }

    public String getLabTestName() {
        return labTestName;
    }

    public void setLabTestName(String labTestName) {
        this.labTestName = labTestName;
    }

    public String getLabTestCode() {
        return labTestCode;
    }

    public void setLabTestCode(String labTestCode) {
        this.labTestCode = labTestCode;
    }

    public SystemAdmin getSystemAdmin() {
        return systemAdmin;
    }

    public void setSystemAdmin(SystemAdmin systemAdmin) {
        this.systemAdmin = systemAdmin;
    }

    public List<LabOrder> getLabOrderList() {
        return labOrderList;
    }

    public void setLabOrderList(List<LabOrder> labOrderList) {
        this.labOrderList = labOrderList;
    }
}
