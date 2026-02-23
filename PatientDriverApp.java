/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Driver application for Patient and Procedure classes
 * Due: 02/23/2026
 * Platform/compiler: macOS / Java JDK 17
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * Print your Name here: Derrick Patterson
*/

import java.util.Scanner;

public class PatientDriverApp {
    
    /**
     * Displays patient information
     * @param patient the patient object to display
     */
    public static void displayPatient(Patient patient) {
        System.out.println(patient.toString());
    }
    
    /**
     * Displays procedure information
     * @param procedure the procedure object to display
     */
    public static void displayProcedure(Procedure procedure) {
        System.out.println(procedure.toString());
    }
    
    /**
     * Calculates total charges from three procedures
     * @param proc1 first procedure
     * @param proc2 second procedure
     * @param proc3 third procedure
     * @return total charges
     */
    public static double calculateTotalCharges(Procedure proc1, Procedure proc2, Procedure proc3) {
        return proc1.getProcedureCharges() + proc2.getProcedureCharges() + proc3.getProcedureCharges();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Collect patient information
        System.out.println("Enter patient's first name:");
        String firstName = scanner.nextLine();
        
        System.out.println("Enter patient's middle name:");
        String middleName = scanner.nextLine();
        
        System.out.println("Enter patient's last name:");
        String lastName = scanner.nextLine();
        
        System.out.println("Enter patient's street address:");
        String streetAddress = scanner.nextLine();
        
        System.out.println("Enter patient's city:");
        String city = scanner.nextLine();
        
        System.out.println("Enter patient's state:");
        String state = scanner.nextLine();
        
        System.out.println("Enter patient's ZIP code:");
        String zipCode = scanner.nextLine();
        
        System.out.println("Enter patient's phone number (format: 301-123-4567):");
        String phoneNumber = scanner.nextLine();
        
        System.out.println("Enter emergency contact name:");
        String emergencyContactName = scanner.nextLine();
        
        System.out.println("Enter emergency contact phone number:");
        String emergencyContactPhone = scanner.nextLine();
        
        // Create patient using all-parameter constructor
        Patient patient = new Patient(firstName, middleName, lastName, streetAddress,
                                     city, state, zipCode, phoneNumber,
                                     emergencyContactName, emergencyContactPhone);
        
        // Create Procedure 1 using no-arg constructor
        Procedure procedure1 = new Procedure();
        
        System.out.println("\nEnter procedure 1 name:");
        String proc1Name = scanner.nextLine();
        procedure1.setProcedureName(proc1Name);
        
        System.out.println("Enter procedure 1 date (MM/DD/YYYY):");
        String proc1Date = scanner.nextLine();
        procedure1.setProcedureDate(proc1Date);
        
        System.out.println("Enter procedure 1 practitioner name:");
        String proc1Practitioner = scanner.nextLine();
        procedure1.setPractitionerName(proc1Practitioner);
        
        System.out.println("Enter procedure 1 charges:");
        double proc1Charges = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        procedure1.setProcedureCharges(proc1Charges);
        
        // Create Procedure 2 using name and date constructor
        System.out.println("\nEnter procedure 2 name:");
        String proc2Name = scanner.nextLine();
        
        System.out.println("Enter procedure 2 date (MM/DD/YYYY):");
        String proc2Date = scanner.nextLine();
        
        Procedure procedure2 = new Procedure(proc2Name, proc2Date);
        
        System.out.println("Enter procedure 2 practitioner name:");
        String proc2Practitioner = scanner.nextLine();
        procedure2.setPractitionerName(proc2Practitioner);
        
        System.out.println("Enter procedure 2 charges:");
        double proc2Charges = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        procedure2.setProcedureCharges(proc2Charges);
        
        // Create Procedure 3 using all-parameter constructor
        System.out.println("\nEnter procedure 3 name:");
        String proc3Name = scanner.nextLine();
        
        System.out.println("Enter procedure 3 date (MM/DD/YYYY):");
        String proc3Date = scanner.nextLine();
        
        System.out.println("Enter procedure 3 practitioner name:");
        String proc3Practitioner = scanner.nextLine();
        
        System.out.println("Enter procedure 3 charges:");
        double proc3Charges = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        
        Procedure procedure3 = new Procedure(proc3Name, proc3Date, proc3Practitioner, proc3Charges);
        
        // Display all information
        System.out.println();
        displayPatient(patient);
        
        System.out.println();
        displayProcedure(procedure1);
        
        System.out.println();
        displayProcedure(procedure2);
        
        System.out.println();
        displayProcedure(procedure3);
        
        // Calculate and display total charges
        double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
        System.out.println();
        System.out.printf("Total Charges: $%,.2f\n", totalCharges);
        
        // Display student information
        System.out.println();
        System.out.println("Student Name: Derrick Patterson");
        System.out.println("MC#: M21021819");
        System.out.println("Due Date: 02/23/2026");
        
        scanner.close();
    }
}
