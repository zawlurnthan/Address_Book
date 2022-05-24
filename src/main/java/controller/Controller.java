/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Scanner;
import view.AddressView;

/**
 *
 * @author Zaw L Than
 */
public class Controller {
    AddressView view = new AddressView();
    
    public void run(){
        boolean keepGoing = true;
        
        while (keepGoing) {
            int menuSelection = getSelection();
            
            switch(menuSelection) {
                case 1:
                    System.out.println("=== Add New Address ===");
                    break;
                    
                case 2:
                    System.out.println("=== Remove Address ===");
                    break;
                    
                case 3:
                    System.out.println("=== Numbers of Addresses ===");
                    break;
                    
                case 4:
                    System.out.println("=== List of Address ===");
                    break;
                    
                case 5:
                    System.out.println("=== Find Address by Last Name ===");
                    break;
                    
                case 6:
                    keepGoing = false;
                    break;
                    
                default:
                    System.out.println("UNKNOWN COMMAND");
            }
        }
        System.out.println("GOOD BYE!");
    }
    
    
    private int getSelection() {
        return view.printMenuAndGetSelection();
    }
}
