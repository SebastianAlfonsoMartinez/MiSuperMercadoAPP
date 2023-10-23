package org.miApp;

import org.miApp.bill.Bill;
import org.miApp.product.Product;
import org.miApp.store.Store;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Store store = new Store();
        Product product = new Product();
        Bill bill = new Bill();
        int option = displayMenu();
        while (option != 10) {

            switch (option) {
                case 1 -> product.addProduct(store);
                case 2 -> product.removeProduct(store);
                case 3 -> product.updateProduct(store);
                case 4 -> product.suspendProduct(store);
                case 5 -> store.searchProduct(store);
                case 6 -> store.viewInventory(store);
                case 7 -> bill.addProductToBill(store);
                case 8 -> bill.viewBillInformation(store);
                case 9 -> bill.searchBill(store);
                case 10 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion invalida. por favor intenta de nuevo");
            }
            option = displayMenu();
        }

    }



    private static int displayMenu() {

        System.out.println(
                """
                        |================================================.
                              .-.   .-.     .--.                         |
                             | OO| | OO|   / _.-'  .-.   .-.  .-.   .''. |
                             |   | |   |   \\  '-.  '-'   '-'  '-'   '..' |
                             '^^^' '^^^'    '--'                         |
                         ===============.  .-.  .================.  .-.  |
                                        | |   | |                |  '-'  |
                                        | |   | |                |       |
                                        | ':-:' |                |  .-.  |
                         l42            |  '-'  |                |  '-'  |
                         ==============='       '================'       |""");
        System.out.println("±----------------------------------------±");
        System.out.println("|   Administrador Mi Tienda de Barrio    |");
        System.out.println("±----------------------------------------±");
        System.out.println("1. Agregar producto                      |");
        System.out.println("2. Eliminar producto                     |");
        System.out.println("3. Actualizar producto                   |");
        System.out.println("4. suspender producto                    |");
        System.out.println("5. Buscar producto                       |");
        System.out.println("6. Ver Inventario de productos           |");
        System.out.println("7. Vender Productos                      |");
        System.out.println("8. Ver facturas                          |");
        System.out.println("9. Buscar facturas                       |");
        System.out.println("10. Salir                                 |");
        System.out.println("±----------------------------------------±");
        System.out.print("   Ingresa tu opción:    (1 - 9)  ");
        Scanner scanner = new Scanner(System.in);
        int option = 9;
        try {
            option = scanner.nextInt();
            if (option < 1 || option > 9) {
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