package org.miApp.product;

public class Product {
    //Atributos
    private String productName;
    private String description;
    private String category;
    private String label;
    private double price;
    private String urlPhoto;

    //Contructores
    public Product(){
        System.out.println("se creo un producto vacio");
    }
    public Product(String productName, String description, String category, String label, double price, String urlPhoto){
        this.productName = productName;
        this. description = description;
        this. category = category;
        this.label = label;
        this.price = price;
        this.urlPhoto = urlPhoto;
    }
    //Metodos



}
