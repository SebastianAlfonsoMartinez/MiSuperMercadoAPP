package org.miApp.bill;

import org.miApp.customer.Customer;
import org.miApp.product.Product;
import org.miApp.store.Store;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Bill {

    //ATRIBUTOS

    private static int conId = 0;
    private Integer idBill;
    private final List<Product> listProduct = new ArrayList<>();
    private LocalDateTime dateAndHourSale;
    private Customer customer;
    Integer amountProducts;

    //CONSTRUCTORES
    public Bill(){}



    public Bill(Customer customer) {
        this.dateAndHourSale = LocalDateTime.now();
        this.idBill = ++conId;
        this.customer = customer;
    }



    //GETTER AND SETTER

    public Integer getIdBill() {
        return idBill;
    }


    public List<Product> getListProduct() {
        return listProduct;
    }

    public LocalDateTime getDateAndHourSale() {
        return dateAndHourSale;
    }



    //METODOS

    public void addProductToBill(Store store) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the client name");
        String clientName = scanner.nextLine();
        Customer customer = new Customer(clientName);
        Bill bill1 = new Bill(customer);

        Boolean addMoreProduct = true;


        while (addMoreProduct) {
            System.out.println("Enter the product ID to buy");
            String productNameOrId = scanner.nextLine();
            System.out.println("Enter the amount the Products to buy");
            Integer quantityProducts = scanner.nextInt();
            Optional optional = store.findProductByIdOrName(productNameOrId);

            if (!optional.isEmpty()) {
                store.saleProduct(optional,quantityProducts, bill1);
            } else{
                System.out.println("|----------------------------------- No se encontro el Producto -----------------------------------|\n");
            }
            System.out.println("Desea comprar mas productos (Si/No)");
            scanner.nextLine();
            String requestToBuy = scanner.nextLine();
            addMoreProduct = requestToBuy.equalsIgnoreCase("si");
        }
        store.addBill(bill1);
    }

    public void addProductToBill(Product product){
        if (!listProduct.contains(product)){
            listProduct.add(product);
        }
    }

    public void viewBillInformation(Store store){
        System.out.println(store.getBillList().toString());
    }

    public void searchBill(Store store){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Bill ID to search");
        Integer productNameOrId = scanner.nextInt();

        System.out.println(store.findBillById(productNameOrId));
        System.out.println("|----------------------------------- Busqueda del producto -----------------------------------|\n");
    }



    //Añadir un producto a la lista de productos


    @Override
    public String toString() {
        return "Bill{" +
                "idBill=" + idBill +
                ", listProduct=" + listProduct +
                ", dateAndHourSale=" + dateAndHourSale +
                ", customer=" + customer +
                '}';
    }
}





