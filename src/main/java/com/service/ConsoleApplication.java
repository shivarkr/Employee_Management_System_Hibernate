package com.service;


import com.hibernateConnectors.HibernateCRUD;


import java.util.Scanner;

public class ConsoleApplication {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Choose the Option: ");
            System.out.println("1. Insert \n" + "2. Update \n" + "3. Delete \n" + "4. Display \n" + "5. Exit");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    HibernateCRUD.insert();
                    break;
                case 2:
                    HibernateCRUD.updateEmployeeDetails();
                    break;
                case 3:
                    HibernateCRUD.deleteFromDb();
                    break;
                case 4:
                    HibernateCRUD.display();
                    break;
                case 5:
                    return; // Exits the loop and the program
                default:
                    System.out.println("Please Enter a Valid Choice: ");
                    break;
            }
        }

    }
}
