package org.miApp.bill;

import org.miApp.customer.Customer;
import org.miApp.menu.SuperKeyBoard;
import org.miApp.menu.enums.Menus;
import org.miApp.product.Product;
import org.miApp.product.ProductManage;
import org.miApp.store.Store;

import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class BillManage {

    private final Set<Bill> billList = new HashSet<>();

    public BillManage() {
    }

    public Set<Bill> getBillList() {
        return billList;
    }


    public void addBillToInventory(Bill bill){
        if (!billList.contains(bill)){
            billList.add(bill);
        }
    }


    public Optional<Bill> findBillById(Integer id){
        return billList.stream().
                filter(bill -> bill.getIdBill()
                        .equals(id)).findAny();
    }
    public void searchBillToInventory(){
        System.out.println("Enter the Bill ID to search");
        Integer billId = SuperKeyBoard.readNumber();
        System.out.println(findBillById(billId));
        System.out.println("|----------------------------------- Busqueda del producto -----------------------------------|\n");
    }
    public void totalPriceToBill(Bill bill){
        double totalPrice = 0.0;
        for (Product product : bill.getListProduct()){
            totalPrice += (product.getPrice() * product.getStock().getStock());
        }
        double tax = 0.19 * totalPrice;
        double totalPriceWithTax = totalPrice + tax;
        bill.setTotalPrice(totalPriceWithTax);
    }
    public void viewBillInformation(){
        System.out.println(getBillList().toString());
    }

    public void manageMenuBill(){
        Boolean manageMoreBills = true;
        while (manageMoreBills) {
            manageMoreBills = validateOptionMenuBills();
        }
    }

    public Boolean validateOptionMenuBills(){
        Menus.BILL_MENU.getValue();
        int choice = SuperKeyBoard.readNumber();

        switch (choice){
            case 1 -> searchBillToInventory();
            case 2 -> viewBillInformation();
            case 0 -> {
                System.out.println("Saliendo...");
                return false;
            }
            default -> System.out.println("Invalid choice");
        }
        System.out.println("Desea gestionar mas facturas (Si/No)");
        String requestManageBills = SuperKeyBoard.readText();
        return requestManageBills.equalsIgnoreCase("si");
    }
}
