package com.hibernateConnectors;
import com.entities.Address;
import com.entities.Employee;
import com.entities.WorkExperience;
import com.service.InputTakers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HibernateCRUD {

    public static Session giveSession(){
        final Configuration cnf = new Configuration();
        cnf.addAnnotatedClass(Address.class);
        cnf.addAnnotatedClass(Employee.class);
        cnf.addAnnotatedClass(WorkExperience.class);
        cnf.configure();
        final SessionFactory sessionFactory = cnf.buildSessionFactory();
        return sessionFactory.openSession();


    }
    public static void insert(){
        //Employee employee = InputTakers.takeInputOfEmployee();
        Employee employee  = giveDummyEmployee();
        Session session = giveSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();


            for(int i = 0 ;i<employee.getWorkHistory().size();i++){

                employee.getWorkHistory().get(i).setNthexperience(i+1);
                employee.getWorkHistory().get(i).setEmployee(employee);

            }
            session.persist(employee);

            transaction.commit();


            System.out.println("Inserted Employee ID: " + employee.getEmpId());

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    public static void display(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the id for Display: ");
        int empIdForDisplay = sc.nextInt();
       display(empIdForDisplay);

    }
    public static void display(int empId){

        Session session = giveSession();
        Employee e = session.get(Employee.class,empId);
        if(e==null){
            System.out.println("Employee does not exist");
            return;
        }
        System.out.println(e);
    }

    public static void deleteFromDb(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the id of the employee for deletion: ");
        int empIdForDelete= sc.nextInt();
        sc.nextLine();
        delete(empIdForDelete);
    }
    public static void delete(int empId){
        Session session = giveSession();
        Employee employee = session.get(Employee.class,empId);
        if(employee==null){
            System.out.println("Employee does not exist");
            return;
        }
        Transaction transaction=null;
        try{
            transaction = session.beginTransaction();
            session.remove(employee);
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();

            if( transaction!=null){
                transaction.rollback();
            }

        }finally {
            session.close();
        }

    }

    public static void updateEmployeeDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the id for update: ");
        int empIdForUpdate = Integer.parseInt(sc.nextLine());
        update(empIdForUpdate);
        System.out.println("Update completed for " + empIdForUpdate);
    }
    public static void update(int empId){
        Session session = giveSession();
        Employee employee = session.get(Employee.class,empId);
        if(employee==null){
            System.out.println("Employee does not exist");
            return;
        }
        Employee updatedEmployee = InputTakers.takeInputOfEmployee();


        Transaction transaction=null;
        try{

            transaction = session.beginTransaction();

            employee.setName(updatedEmployee.getName());
            employee.setDesignation(updatedEmployee.getDesignation());
            employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
            employee.setSalary(updatedEmployee.getSalary());
            employee.setMail(updatedEmployee.getMail());
            employee.setAddress(updatedEmployee.getAddress());
            employee.setWorkHistory(updatedEmployee.getWorkHistory());


            for(int i = 0 ;i<employee.getWorkHistory().size();i++){
                WorkExperience work = employee.getWorkHistory().get(i);
                work.setNthexperience(i+1);
                work.setEmployee(employee);
            }

            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();

            if( transaction!=null){
                transaction.rollback();
            }

        }finally {
            session.close();
        }


    }


    //for testing
    public static Employee giveDummyEmployee(){
        Address address = new Address("124", "Main St", "Springfield", "IL", "USA");

        // Create WorkExperience objects
        WorkExperience work1 = new WorkExperience("Company A", "Software Engineer");
        work1.setNthexperience(1);
        WorkExperience work2 = new WorkExperience("Company B", "Senior Developer");
        work2.setNthexperience(2);


        // Create a list of work experiences
        List<WorkExperience> workHistory = new ArrayList<>();
        workHistory.add(work1);
        workHistory.add(work2);

        // Create Employee object
        Employee employee = new Employee("Shiva", "Developer", "123-456-7890", 75000.00, "john.doe@example.com", address, workHistory);
        work1.setEmployee(employee);
        work1.setEmployee(employee);
        return employee;
    }

//    public static void main(String[] args) {
//        insert();
//    }


}
