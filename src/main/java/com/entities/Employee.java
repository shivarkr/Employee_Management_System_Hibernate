package com.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "HEmployee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq_gen")
    @SequenceGenerator(name = "employee_seq_gen", sequenceName = "alien_seq", allocationSize = 1)
    private int empId;
    private String name;
    private String designation;
    private String phoneNumber;
    private double salary;
    private String mail;
    @Embedded
    private Address1 address1;
    @OneToMany(mappedBy = "employee")
    private List<WorkExperience> workHistory;


    public Employee(String name, String designation, String phoneNumber, double salary, String mail, Address1 address1, List<WorkExperience> workHistory) {
        this.name = name;
        this.designation = designation;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.mail = mail;
        this.address1 = address1;
        this.workHistory = workHistory;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Address1 getAddress() {
        return address1;
    }

    public void setAddress(Address1 address1) {
        this.address1 = address1;
    }

    public List<WorkExperience> getWorkHistory() {
        return workHistory;
    }

    public void setWorkHistory(List<WorkExperience> workHistory) {
        this.workHistory = workHistory;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Employee{" +'\n' +
                "empId=" + empId +'\n' +
                "name=" + name + '\n' +
                "designation=" + designation + '\n' +
                "phoneNumber=" + phoneNumber + '\n' +
                "salary=" + salary+ '\n'+
                "mail=" + mail + '\n'+
                "address=" + address1 +'\n'+
                "workHistory=" + workHistory+ '\n'+
                '}';
    }
}
