/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaw L Than
 */
public class AddressDaoImpl implements AddressDao {
    
    Map<String, Address> address_book = new HashMap<>();

    @Override
    public Address addAddress(String id, Address add) {
        return address_book.put(id, add);
    }

    @Override
    public Address removeAddress(String id) {
        return address_book.remove(id);
    }

    @Override
    public List<Address> getAllAddresses() {
        return new ArrayList<Address>(address_book.values());
    }

    @Override
    public int numberOfAddress() {
        return address_book.size();
    }

    @Override
    public Address findAddressByLastName(String lastName) {
        return address_book.values().stream().filter(x -> x.getLastName().equalsIgnoreCase(lastName)).findAny().get();
    } 
}
