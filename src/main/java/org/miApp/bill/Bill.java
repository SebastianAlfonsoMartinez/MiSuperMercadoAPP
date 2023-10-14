package org.miApp.bill;

import org.miApp.customer.Customer;
import org.miApp.product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bill {

    //ATRIBUTOS

    private static int conId = 0;
    private Integer idBill;
    private List<Product> listProduct;
    private LocalDateTime dateAndHourSale;
    private Customer customer;


    //CONSTRUCTORES


    public Bill(Customer customer) {
        this.dateAndHourSale = LocalDateTime.now();
        this.idBill = ++conId;
        this.customer = customer;
    }



    //GETTER AND SETTER

    public Integer getIdBill() {
        return idBill;
    }


    public List<Product> getAddProduct() {
        return listProduct;
    }

    public LocalDateTime getDateAndHourSale() {
        return dateAndHourSale;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    //METODOS

    //Añadir un producto a la lista de productos

    public boolean addProductList(Product product) {
        if (listProduct == null) {
            listProduct = new ArrayList<Product>();
        }
        if (!listProduct.contains(product)) {
            listProduct.add(product);
            return true;
        }
        return false;
    }

        public void searchProductByLetter(char letter) {
            boolean found = false;
            for (Product product : listProduct) {
                if (product.getProductName().toLowerCase().charAt(0) == Character.toLowerCase(letter)) {
                    if (!found) {
                        System.out.println("Se encontraron productos con la letra ingresada: " + letter + "\n los cuales son: ");
                    }
                    System.out.println(product + " ");
                    found = true;
                }
            }
            if (!found){
                System.out.println("No se encontraron productos por la letra: " + letter);
            }
        }

    //Agregar una lista de productos a un array

    public Object[] addProductsArray() {
        Product[] arrayProduct = new Product[listProduct.size()];
        listProduct.toArray(arrayProduct);
        for (int i = 0; i <arrayProduct.length ; i++) {
            System.out.println(arrayProduct[i]);
        }
        return arrayProduct;
    }

    public void ordenarArrayAlfabeticamente(Object[] arrayProduct) {
        // Utilizar el método sort de la clase Arrays para ordenar el array alfabéticamente
        Arrays.sort(arrayProduct);
        for (Object product: arrayProduct) {
            System.out.println(product);

        }
    }


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





