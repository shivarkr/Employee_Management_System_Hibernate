package com.service;

import com.entities.Address1;
import com.entities.Employee;
import com.entities.WorkExperience;
import com.utils.InputValidators;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputTakers {

    public static Employee takeInputOfEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the following details");
        //taking input of name;
        String name;
        do {
            System.out.println("Name: ");
            name = sc.nextLine();
            if (!InputValidators.isValidString(name)) {
                System.out.println("Please enter a valid name.");
            }
        } while (!InputValidators.isValidString(name));
        // taking input of designation
        String designation;
        do {
            System.out.println("designation: ");
            designation = sc.nextLine();
            if (!InputValidators.isValidString(designation)) {
                System.out.println("Please enter a valid designation.");
            }
        } while (!InputValidators.isValidString(designation));

        //taking input of phone number
        String phn;
        do {
            System.out.println("Phn num: ");
            phn = sc.nextLine();
            if (!InputValidators.isValidPhoneNumber(phn)) {
                System.out.println("Please enter a valid Phone number");
            }
        } while (!InputValidators.isValidPhoneNumber(phn));
        //taking input of salary
        double salary = takeInputOfSalary();

        // taking input of email
        String email;
        do {
            System.out.println("Email:  ");
            email = sc.nextLine();
            if (!InputValidators.isValidEmail(email)) {
                System.out.println("Please enter a valid Email");
            }
        } while (!InputValidators.isValidEmail(email));

        Address1 address1 = takeInputOfAddress();
        List<WorkExperience> workHistory = takeInputOfWorkExperience();

        return new Employee(name, designation, phn, salary, email, address1, workHistory);

    }

    public static double takeInputOfSalary() {
        // taking input of salary
        Scanner sc = new Scanner(System.in);
        double salary;
        while (true) {
            try {
                System.out.println("Salary: ");
                salary = Double.parseDouble(sc.nextLine());
                if (salary < 0) {
                    System.out.println("Salary cannot be less than 0 ");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter valid Number ");
            }

        }
        return salary;
    }

    public static Address1 takeInputOfAddress() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the details of Address");

        // Taking input of street number
        String streetNumber;
        do {
            System.out.print("Street number: ");
            streetNumber = sc.nextLine();
            if (!InputValidators.isValidStreetNumber(streetNumber)) {
                System.out.println("Please enter a valid street number.");
            }
        } while (!InputValidators.isValidStreetNumber(streetNumber));

        // Taking input of street name
        String streetName;
        do {
            System.out.print("Street name: ");
            streetName = sc.nextLine();
            if (!InputValidators.isValidString(streetName)) {
                System.out.println("Please enter a valid street name.");
            }
        } while (!InputValidators.isValidString(streetName));

        // Taking input of city
        String city;
        do {
            System.out.print("City: ");
            city = sc.nextLine();
            if (!InputValidators.isValidString(city)) {
                System.out.println("Please enter a valid city.");
            }
        } while (!InputValidators.isValidString(city));

        // Taking input of state
        String state;
        do {
            System.out.print("State: ");
            state = sc.nextLine();
            if (!InputValidators.isValidString(state)) {
                System.out.println("Please enter a valid state.");
            }
        } while (!InputValidators.isValidString(state));

        // Taking input of country
        String country;
        do {
            System.out.print("Country: ");
            country = sc.nextLine();
            if (!InputValidators.isValidString(country)) {
                System.out.println("Please enter a valid country.");
            }
        } while (!InputValidators.isValidString(country));

        return new Address1(streetNumber, streetName, city, state, country);
    }

    public static List<WorkExperience> takeInputOfWorkExperience() {
        Scanner sc = new Scanner(System.in);
        List<WorkExperience> workHistory = new ArrayList<>();
        System.out.println("Please enter number of experiences:");

        int noOfExperiences;
        while (true) {
            try {
                noOfExperiences = Integer.parseInt(sc.nextLine());
                if (noOfExperiences < 0) {
                    System.out.println("Number of experiences cannot be negative. Please enter a valid number.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        for (int i = 0; i < noOfExperiences; i++) {
            System.out.println("Enter the details of experience " + (i + 1) + ":");

            // Taking input of company name
            String companyName;
            do {
                System.out.print("Company Name: ");
                companyName = sc.nextLine();
                if (!InputValidators.isValidString(companyName)) {
                    System.out.println("Please enter a valid company name.");
                }
            } while (!InputValidators.isValidString(companyName));

            // Taking input of designation
            String designation;
            do {
                System.out.print("Designation: ");
                designation = sc.nextLine();
                if (!InputValidators.isValidString(designation)) {
                    System.out.println("Please enter a valid designation.");
                }
            } while (!InputValidators.isValidString(designation));
            workHistory.add(new WorkExperience(companyName, designation));
        }
        return workHistory;
    }

}
