/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Address;
import java.util.List;

/**
 *
 * @author Zaw L Than
 */
public interface AddressDao {
    Address addAddress(String id, Address add);
    Address removeAddress(String id);
    List<Address> getAllAddresses();
    int numberOfAddress();
    Address findAddressByLastName(String lastName);
}
