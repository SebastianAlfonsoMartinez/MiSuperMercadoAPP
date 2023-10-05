package org.miApp;

import org.miApp.product.Product;
import org.miApp.product.ProductArray;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main mainApp = new Main();

/*        Product productCoffe = new Product("Juan valdez", "cafe premium", "cafe", "Cafes", 20000, "www.google.com.co", 5 );
//        mainApp.runMenu();
        System.out.println(productCoffe.getProductName());
        System.out.println(productCoffe.setProductName("Juan Valdez Volcan"));
        System.out.println(productCoffe.getDescription());
        System.out.println(productCoffe.setDescription("Cafe tonalida fuerte"));
        System.out.println(productCoffe.getCategory());
        System.out.println(productCoffe.setCategory("Cafe colombiano"));
        System.out.println(productCoffe.getLabel());
        System.out.println(productCoffe.setLabel("Cafe premium"));
        System.out.println(productCoffe.getPrice());
        System.out.println(productCoffe.setPrice(25000));
        System.out.println(productCoffe.getUrlPhoto());
        System.out.println(productCoffe.setUrlPhoto("https://www.juanvaldezcafestore.com/wp-content/uploads/2021/06/Cold-Brew-HD.jpg"));
        System.out.println(productCoffe.getStock());
        System.out.println(productCoffe.setStock(10));
        System.out.println(productCoffe.stockProduct(15));
        productCoffe.higherPriceValidation(24000);
        productCoffe.validatioPriceLessThanEqual(27000);
        productCoffe.productContainsTextParameter("volcan");
        System.out.println(productCoffe.toString());
        Product productMilk = new Product("Alqueria", "Leche entera", "Lacteos", "Leche", 4500, "www.google.com", 10);
        System.out.println(productMilk.getPrice());
        Product chocolatina = new Product("Jet", "Chocolatina", "Dulces", "Chocolatina", 2000, "askhjfdajsfh", 50);
        chocolatina.higherPriceValidation(2500);*/
//        ProductArray arrayProductos = new ProductArray(new String[]{"leche", "pan", "huevos", "harina", "Higado", "Agua", "COCO", "durazno", "chocolate", "Wisky" });
//        arrayProductos.toString();
//        arrayProductos.ordenarArrayAlfabeticamente(arrayProductos.getArray());
/*        Product caldo = new Product("Caldo costilla", "caldo con papa y costilla", "Sopas", "Caldo", 6000, "www.caldo.com", 5);
        System.out.println(caldo);


        caldo.setPrice(8000);
        System.out.println("el precio del caldo es: " + caldo.getPrice());*/
        Product celular = new Product("Celular s20", "celular andoid", "smartPhone", "telefono", 900000, "www.fkldjltfsed.com", 20);
//        System.out.println(celular);
//        celular.higherPriceValidation(950000);
        celular.productContainsTextParameter("c");








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