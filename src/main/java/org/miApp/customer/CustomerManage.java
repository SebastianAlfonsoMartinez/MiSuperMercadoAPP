package org.miApp.customer;

import org.miApp.menu.SuperKeyBoard;

public class CustomerManage {

    public Customer createCustomer(){
        System.out.println("Enter the client name");
        String clientName = SuperKeyBoard.readText();
        Customer customer = new Customer(clientName);
        return customer;
    }
}
