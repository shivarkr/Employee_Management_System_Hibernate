package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "HWORKExperience")

public class WorkExperience {
    @Id
    private int nthexperience;
    private String companyName;
    private String designation;
    @Id
    @ManyToOne
    private Employee employee;


    public WorkExperience( String companyName, String designation) {

        this.companyName = companyName;
        this.designation = designation;
    }

    public WorkExperience() {
    }

    public String getCompanyName(){
        return  companyName;
    }
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "companyName='" + companyName + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }

    public int getNthexperience() {
        return nthexperience;
    }

    public void setNthexperience(int nthexperience) {
        this.nthexperience = nthexperience;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
