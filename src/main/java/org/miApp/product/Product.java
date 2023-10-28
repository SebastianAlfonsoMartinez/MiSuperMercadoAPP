package org.miApp.product;
import org.miApp.stock.Stock;
import org.miApp.store.Store;

import javax.sound.midi.Soundbank;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class Product implements Comparable<Product>, MethodsProductI{
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

    public CategoryProduct selectCategory(){
        System.out.println("Select a category by entering the corresponding number: ");
        for (int i = 0; i < CategoryProduct.values().length; i++) {
            System.out.println((i + 1) + ". " + CategoryProduct.values()[i].getValue());
        }
        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();

        if (choise >= 1 && choise <= CategoryProduct.values().length)
            return CategoryProduct.values()[choise - 1];
        else {
            System.out.println("Invalid choise. Please select a valid category.");
            return selectCategory();
        }
    }
    public void addProduct(Store store){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product name");
        String productName = scanner.nextLine();
        System.out.println("Enter the product description");
        String description = scanner.nextLine();

        CategoryProduct category = selectCategory();
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
        Product product = new Product(productName, description, category.getValue(), label, price, urlPhoto, stock1);

        store.addProductToInventory(product);


        System.out.println("|----------------------------------- Se agrego un producto -----------------------------------|\n"+product.toString());
    }


    public void updateProduct(Store store) {

        Boolean udateMoreProduct = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product ID to update");
        Integer productId = scanner.nextInt();
        scanner.nextLine();

        while (udateMoreProduct) {
            Optional<Product> productToUpdate = store.getProductList().stream()
                    .filter(product -> product.getId() == productId)
                    .findFirst();

            if (productToUpdate.isPresent()) {
                Product product = productToUpdate.get();
                System.out.println("±----------------------------------------±");
                System.out.println("|   Select the value to update:          |");
                System.out.println("±----------------------------------------±");
                System.out.println("1. Product Name");
                System.out.println("2. Description");
                System.out.println("3. Category");
                System.out.println("4. Label");
                System.out.println("5. Price");
                System.out.println("6. URL Photo");
                System.out.println("7. Stock");
                System.out.println("Select the value to update (enter the corresponding number):");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter the new product name");
                        product.setProductName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter the new description");
                        product.setDescription(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Enter the new category");
                        product.setCategory(product.selectCategory().name());
                        break;
                    case 4:
                        System.out.println("Enter the new label");
                        product.setLabel(scanner.nextLine());
                    case 5:
                        System.out.println("Enter the new price");
                        product.setPrice(scanner.nextDouble());
                        scanner.nextLine();
                        break;
                    case 6:
                        System.out.println("Enter the new URL Photo");
                        product.setUrlPhoto(scanner.nextLine());
                        break;
                    case 7:
                        System.out.println("Enter the new stock");
                        Integer stock = scanner.nextInt();
                        product.setStock(new Stock(stock));
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }

                System.out.println("|----------------------------------- Product Updated -----------------------------------|\n" + product);
            } else {
                System.out.println("Product not found with the given ID.");
            }
            System.out.println("Desea actualizar mas atributos (Si/No)");
            String requestToBuy = scanner.nextLine();
            udateMoreProduct = requestToBuy.equalsIgnoreCase("si");
        }
    }



    public void  suspendProduct(Store store){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product ID to suspend");
        Integer productId = scanner.nextInt();
        Optional<Product> productToSuspend = store.getProductList().stream().
                filter(product -> product.getId() == productId).findFirst();
        productToSuspend.ifPresent(product -> product.setSuspended(true));


        System.out.println("|----------------------------------- Se suspendio un producto -----------------------------------|");
        System.out.println(productToSuspend.get());
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