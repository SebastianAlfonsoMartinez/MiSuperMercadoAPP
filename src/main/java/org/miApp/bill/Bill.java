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
    private Double totalPrice;

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

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    //METODOS





    //Añadir un producto a la lista de productos


    @Override
    public String toString() {
        return "Bill" +
                "idBill=" + idBill +
                ", listProduct=" + listProduct +
                ", dateAndHourSale=" + dateAndHourSale +
                ", customer=" + customer +
                ", totalPrice=" + totalPrice;
    }
}





