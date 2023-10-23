package org.miApp.product;

import com.sun.source.tree.IfTree;
import org.miApp.stock.Stock;
import org.miApp.store.Store;

import java.util.Scanner;


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
    //Metodos con funcionalidades

    public void addProduct(Store store){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product name");
        String productName = scanner.nextLine();
        System.out.println("Enter the product description");
        String description = scanner.nextLine();
        System.out.println("Enter the product category");
        String category = scanner.nextLine();
        System.out.println("Enter the product label");
        String label = scanner.nextLine();
        System.out.println("Enter the product url Photo");
        String urlPhoto = scanner.nextLine();
        System.out.println("Enter the product price");
        Double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter the product Stock");
        Integer stock = scanner.nextInt();

        Stock stock1 = new Stock(stock);
        Product product = new Product(productName, description, category, label, price, urlPhoto, stock1);

        store.addProduct(product);


        System.out.println("|----------------------------------- Se agrego un producto -----------------------------------|\n"+product.toString());
    }

    public void removeProduct(Store store){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product id to remove");
        Integer productId = scanner.nextInt();
        store.delProduct(productId);

        System.out.println("|----------------------------------- Se elimino un producto -----------------------------------|\n");
    }

    public void updateProduct(Store store){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product ID to update");
        Integer productId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the product name to update");
        String productName = scanner.nextLine();
        System.out.println("Enter the product description to update");
        String description = scanner.nextLine();
        System.out.println("Enter the product category to update");
        String category = scanner.nextLine();
        System.out.println("Enter the product label to update");
        String label = scanner.nextLine();
        System.out.println("Enter the product url Photo to update");
        String urlPhoto = scanner.nextLine();
        System.out.println("Enter the product price to update");
        Double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter the product Stock to update");
        Integer stock = scanner.nextInt();

        Stock stock1 = new Stock(stock);
        store.updateProduct(productId,productName,description,category,label,price,urlPhoto,stock1);
        System.out.println("|----------------------------------- Se actualizo un producto -----------------------------------|");
    }
    public void  suspendProduct(Store store){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product ID to suspend");
        Integer productId = scanner.nextInt();

        store.suspendProduct(productId);
        System.out.println("|----------------------------------- Se suspendio un producto -----------------------------------|");
    }


    //Validacion si hay productos en inventario de los solicitados.
/*    public String stockProduct(long amount) {
        if (amount >= stock) {
            return "Si hay productos disponibles en inventario. Total dew productos disponibles: " + stock;
        } else {
            return "No hay los productos suficientes. En inventario existentes:  " + stock;
        }
    }*/

    //Determinar si el precio de un producto es mayor a un valor pasado por parametro.
    public void higherPriceValidation(double price) {
        if (this.price > price) {
            System.out.println("Precio del producto es mayor al valor pasado por parametro" + this.price);
        } else {
            System.out.println("El precio ingresado es mayor al valor del producto" + price);
        }

    }

    //Determinar si el precio de un producto es menor o igual a un valor pasado por parametro.
    public void validatioPriceLessThanEqual(double price) {
        if (this.price <= price) {
            System.out.println("El precio es de menor precio o igual al valor pasado por parametro");
        }
    }


    //Determinar si el nombre del producto contiene una palabra pasada por parametro.
    public void productContainsTextParameter(String productName) {
        String palabra = this.productName.toLowerCase();
        if (palabra.contains(productName.toLowerCase())) {
            System.out.println("El producto contiene la palabra " + productName + " Producto:" + this.productName);
        } else {
            System.out.println("No se encontro producto con la palabra " + productName);
        }
    }

    //Implementa una metodo para mostrar los productos que comienzan por una letra pasada por parámetro.

/*    public void searchProductByLetter(String l) {
        System.out.println("Se encontraron productos con la letra ingresada: " + l + "\n los cuales son: ");
        for (String product : this.array) {
            if (product.startsWith(l)) {
                System.out.println(product + " ");
            }
        }
    }*/


    //el método está sobreescribiendo un método de la clase padre. devuelve una cadena JSON que contiene los valores de los atributos de la clase.


    @Override
    public String toString() {
        return "Product:" +
                "id=" + id +
                "\n productName='" + productName + '\'' +
                "\n description='" + description + '\'' +
                "\n category='" + category + '\'' +
                "\n label='" + label + '\'' +
                "\n price=" + price +
                "\n urlPhoto='" + urlPhoto + '\'' +
                "\n isSuspended=" + isSuspended +
                "\n stock=" + stock +
                "\n |================================================\n";
    }

    @Override
    public int compareTo(Product o) {
        return productName.compareTo(o.productName);
    }
}