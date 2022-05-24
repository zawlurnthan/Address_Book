/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dto.Address;
import java.util.Scanner;

/**
 *
 * @author Zaw L Than
 */
public class AddressView {
    Scanner scanner = new Scanner(System.in);
    
    public int printMenuAndGetSelection() {
        System.out.println("Main Menu");
        System.out.println("1. Add new Address");
        System.out.println("2. Remove Address");
        System.out.println("3. Check number of Addresses");
        System.out.println("4. List Addresses");
        System.out.println("5. Find Address by Last Name");   
        System.out.println("6. Exit");

        System.out.println("Please select form the above choice.");
        return scanner.nextInt();
    }
    
    public Address getNewAddressInfo() {
        System.out.println("Enter id of Address");
        String id = scanner.nextLine();
        
        System.out.println("Enter First Name");
        String firstName = scanner.nextLine();
        
        System.out.println("Enter Last Name");
        String lastName = scanner.nextLine();
        
        System.out.println("Enter Street");
        String street = scanner.nextLine();
        
        System.out.println("Enter City");
        String city = scanner.nextLine();
        
        System.out.println("Enter State");
        String state = scanner.nextLine();
        
        System.out.println("Enter ZipCode");
        String zipCode = scanner.nextLine();
        
        return new Address(id, firstName, lastName, street, city, state, zipCode);
    }
    
    public void displayRemovalAddress(Address add) {
        if (add != null) {
            System.out.println(add.getId());
            System.out.println(add.getFirstName() + " " + add.getLastName()); 
            System.out.println(add.getStreet());
            System.out.println(add.getCity() + " " + add.getState() + " " + add.getZipcode());     
        } else {
            System.out.println("No such Address");
        }
        System.out.println("Please hit enter to continue.");
    }
}
