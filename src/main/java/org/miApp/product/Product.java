package org.miApp.product;
import org.miApp.stock.Stock;

public class Product implements Comparable<Product>{
    //Atributos

    private static int contadorId = 0;
    private Integer id;
    private String productName;
    private String description;
    private String category;
    private String label;
    private Double price;
    private String urlPhoto;
    private Boolean isSuspended;
    private Stock stock;


    //Contructores
    public Product() {
        System.out.println("se creo un producto vacio");
    }

    public Product(Integer id, String productName, String description, Double price, Stock stock) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Product(String productName, String description, String category, String label, Double price, String urlPhoto, Stock stock) {
        this.id = ++contadorId;
        this.productName = productName;
        this.description = description;
        this.category = category;
        this.label = label;
        this.price = price;
        this.urlPhoto = urlPhoto;
        this.stock = stock;
        isSuspended = false;
    }

    //Metodos
    // getters and setters
    public String getProductName() {
        return productName;
    }

    public String setProductName(String productName) {
        this.productName = productName;
        return this.productName;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String setDescription(String description) {
        this.description = description;
        return this.description;
    }

    public String getCategory() {
        return category;
    }

    public String setCategory(String category) {
        this.category = category;
        return this.category;
    }

    public String getLabel() {
        return label;
    }

    public String setLabel(String label) {
        this.label = label;
        return this.label;
    }

    public double getPrice() {
        return price;
    }

    public double setPrice(double price) {
        this.price = price;
        return this.price;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public String setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
        return this.urlPhoto;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Boolean getSuspended() {
        return isSuspended;
    }

    public void setSuspended(Boolean suspended) {
        isSuspended = suspended;
    }

    private String shortenUrl(String url, int maxLength) {
        if (url.length() <= maxLength) {
            return url;
        } else {
            // Acorta la URL a la longitud deseada
            return url.substring(0, maxLength);
        }
    }

    @Override
    public String toString() {
        String shortenedUrl = shortenUrl(urlPhoto, 15);

        return String.format("| %5s | %-70s | %-30s | %-30s | %-15s | %-10s | %20s | %5s |",
                id, productName, description, category, label, price, shortenedUrl, isSuspended, stock, "\n");
    }

    @Override
    public int compareTo(Product o) {
        return productName.compareTo(o.productName);
    }
}