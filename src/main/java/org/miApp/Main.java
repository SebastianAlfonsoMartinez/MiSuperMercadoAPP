package org.miApp;

import org.miApp.product.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main mainApp = new Main();
        Product productMilk = new Product();
        System.out.println(productMilk);
        Product productCoffe = new Product("Juan valdez", "cafe premium", "cafe", "Cafes", 20000, "www.google.com.co" );
        mainApp.runMenu();

    }
    private void handleUserChoice(int choice){
        switch (choice){
            case 1 -> addProduct();
            case 2 -> removeProduct();
            case 3 -> updateProduct();
            case 4 -> suspendProduct();
            case 5 -> searchProduct();
            case 6 -> viewInventory();
            case 7 -> manageSuppliers();
            case 8 -> System.out.println("Saliendo...");
            default -> System.out.println("Opcion invalida. por favor intenta de nuevo");

        }
    }

    private void addProduct(){
        System.out.println("|----------------------------------- Se agrego un producto -----------------------------------|");
    }

    private void removeProduct(){
        System.out.println("|----------------------------------- Se elimino un producto -----------------------------------|");
    }

    private void updateProduct(){
        System.out.println("|----------------------------------- Se actualizo un producto -----------------------------------|");
    }
    private void  suspendProduct(){
        System.out.println("|----------------------------------- Se suspendio un producto -----------------------------------|");
    }
    private  void searchProduct() {
        System.out.println("|----------------------------------- Busqueda del producto -----------------------------------|");
    }
    private void viewInventory(){
        System.out.println("|----------------------------------- Verificando inventario de productos -----------------------------------|");
    }
    private void manageSuppliers(){
        System.out.println("|----------------------------------- Control de proveedores -----------------------------------|");
    }
    private void displayMenu() {

        System.out.println(
                """
                        |o|                         /////////////\\\\\\
                        |o|                        (((((((((((((   \\\\\\
                        |o|                        ))) ~~      ~~   (((
                        |o|                        ((( (*)     (*)  )))
                        |o|                        )))     <        (((\s
                        |o|                        ((( '\\______/`   )))\s
                        |o|                        )))\\___________/(((\s
                        |o|                        (((   _)  (_    )))\s\s
                        |o|                              /\\__/\\""");
        System.out.println("±----------------------------------------±");
        System.out.println("|   Administrador Mi Tienda de Barrio    |");
        System.out.println("±----------------------------------------±");
        System.out.println("1. Agregar producto                      |");
        System.out.println("2. Eliminar producto                     |");
        System.out.println("3. Actualizar producto                   |");
        System.out.println("4. suspender producto                    |");
        System.out.println("5. Ver todos los productos               |");
        System.out.println("6. Buscar producto                       |");
        System.out.println("7. Ver Inventario                        |");
        System.out.println("8. Salir                                 |");
        System.out.println("±----------------------------------------±");
        System.out.print("   Ingresa tu opción:    (1 - 8)  ");
    }

    public void runMenu(){
        int choise;
        Scanner myScanner = new Scanner(System.in);
        do {
            displayMenu();
            choise = myScanner.nextInt();
            myScanner.nextLine();
            handleUserChoice(choise);
        }while (choise != 8);
    }




}