package org.miApp.bill;

import org.miApp.customer.Customer;
import org.miApp.product.Product;
import org.miApp.store.Store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bill {

    //ATRIBUTOS

    private static int conId = 0;
    private Integer idBill;
    final List<Product> listProduct = new ArrayList<>();
    private LocalDateTime dateAndHourSale;
    private Integer amoutProducts;



    //CONSTRUCTORES




    public Bill() {
        this.dateAndHourSale = LocalDateTime.now();
        this.idBill = ++conId;
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

    public void addProductToBill(Product product){
        if (!listProduct.contains(product)){
            listProduct.add(product);
        }
    }

    public void viewBillInformation(Store store){
        System.out.println(store.getBillList().toString());
    }





    //Añadir un producto a la lista de productos



    //Agregar una lista de productos a un array





    @Override
    public String toString() {
        return "Bill{" +
                "idBill=" + idBill +
                ", listProduct=" + listProduct +
                ", dateAndHourSale=" + dateAndHourSale +
                '}';
    }
}





