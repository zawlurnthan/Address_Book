/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Zaw L Than
 */
public class AddressDaoImpl implements AddressDao {
    
    Map<String, Address> address_book = new HashMap<>();
    public static final String ADDRESS_BOOK = "Add_Book.txt";
    public static final String DELIMITER = "::";

    @Override
    public Address addAddress(String id, Address add) {
        Address newAdd = address_book.put(id, add);
        writeTextFile();
        return newAdd;
    }

    @Override
    public Address removeAddress(String id) {
        readTextFile();
        Address add = address_book.remove(id);
        writeTextFile();
        return add;
    }

    @Override
    public List<Address> getAllAddresses() {
        readTextFile();
        return new ArrayList<>(address_book.values());
    }

    @Override
    public int numberOfAddress() {
        readTextFile();
        return address_book.size();
    }

    @Override
    public Address findAddressByLastName(String lastName) {
        readTextFile();
        return address_book.values().stream().filter(x -> x.getLastName().equalsIgnoreCase(lastName)).findAny().get();
    } 
    
    // convert object ot text
    private String marshallAddress(Address add) {
        return add.getId() + DELIMITER
                + add.getFirstName() + DELIMITER
                + add.getLastName() + DELIMITER
                + add.getStreet() + DELIMITER
                + add.getCity() + DELIMITER
                + add.getState() + DELIMITER
                + add.getZipcode();
    }
    
    // writing to text file
    private void writeTextFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(ADDRESS_BOOK));
            for (Address add : address_book.values()) {
                String text = marshallAddress(add);
                out.println(text);
                out.flush();
            }
            out.checkError();
            
        } catch (IOException e) {
            System.out.println("Could not save address data.");
        }
        
    }
    
    // convert text to object
    private Address unmarshallAddress(String text) {
        String[] tokens = text.split(DELIMITER);
        String id = tokens[0];
        String first = tokens[1];
        String last = tokens[2];
        String street = tokens[3];
        String city = tokens[4];
        String state = tokens[5];
        String zip = tokens[6];
        return new Address(id, first, last, street, city, state, zip);
    }
    
    private void readTextFile() {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(ADDRESS_BOOK)))){

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Address add = unmarshallAddress(line);
                address_book.put(add.getId(), add);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("-_- Could not load Address Book into memory.");
        }
    }
}
