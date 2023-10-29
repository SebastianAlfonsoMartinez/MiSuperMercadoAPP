package org.miApp.menu;

import org.miApp.bill.Bill;
import org.miApp.bill.BillManage;
import org.miApp.menu.enums.Menus;
import org.miApp.product.Product;
import org.miApp.product.ProductManage;
import org.miApp.store.Store;

import java.util.Scanner;

public class DisplayMenu {
    public DisplayMenu() {
    }

    public static void runApplication() {

        BillManage billManage = new BillManage();
        ProductManage productManage = new ProductManage();
        int option = displayMenu();
        while (option != 0) {

            switch (option) {
                case 1 -> productManage.productsManagement();
                case 2 -> productManage.addProductToBill(productManage, billManage);
                case 3 -> billManage.manageMenuBill();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion invalida. por favor intenta de nuevo");
            }
            option = displayMenu();
        }

    }

    private static int displayMenu() {
        Menus.MAIN_MENU.getValue();
        int option = 3;
        try {
            option = SuperKeyBoard.readNumber();
            if (option < 0 || option > 3) {
                System.out.println("| The Option selected is not valid. Please try again |");
                displayMenu();
            }
        } catch (Exception e) {
            System.out.println("| The Option selected is not valid. Please try again |");
            displayMenu();
        }
        return option;
    }
}
