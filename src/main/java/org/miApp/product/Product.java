package org.miApp.product;

public class Product {
    //Atributos
    private String productName;
    private String description;
    private String category;
    private String label;
    private double price;
    private String urlPhoto;
    private long stock;
    private String[] array;



    //Contructores
    public Product(){
        System.out.println("se creo un producto vacio");
    }
    public Product(String productName, String description, String category, String label, double price, String urlPhoto, long stock){
        this.productName = productName;
        this. description = description;
        this. category = category;
        this.label = label;
        this.price = price;
        this.urlPhoto = urlPhoto;
        this.stock = stock;
    }
    public Product(String[] array){
        this.array = array;
    }
    //Metodos
    // getters and setters
    public String getProductName(){
        return productName;
    }
    public String setProductName (String productName){
        this.productName = productName;
        return  this.productName;
    }
    public String getDescription(){
        return description;
    }
    public String setDescription(String description){
        this.description = description;
        return this.description;
    }
    public String getCategory(){
        return category;
    }
    public String setCategory(String category){
        this.category = category;
        return this.category;
    }
    public String getLabel(){
        return label;
    }
    public String setLabel(String label){
        this.label = label;
        return this.label;
    }
    public double getPrice(){
        return price;
    }
    public double setPrice(double price){
        this.price = price;
        return this.price;
    }
    public String getUrlPhoto(){
        return urlPhoto;
    }
    public String setUrlPhoto(String urlPhoto){
        this.urlPhoto = urlPhoto;
        return this.urlPhoto;
    }
    public long getStock(){
        return stock;
    }
    public long setStock(long stock){
        this.stock = stock;
        return this.stock;
    }
    public String[] getArray() {
        for (String arrayProduct: this.array) {
            System.out.println(arrayProduct);
        }
        return this.array;
    }
    public String[] setArray(String[] array) {
        this.array = array;
        return this.array;
    }
    //Metodos con funcionalidades

    //Validacion si hay productos en inventario de los solicitados.
    public String stockProduct (long amount){
        if (amount >= stock){
            return  "Si hay productos disponibles en inventario. Total dew productos disponibles: " + stock;
        }else {
            return "No hay los productos suficientes. En inventario existentes:  " + stock;
        }
    }
    //Determinar si el precio de un producto es mayor a un valor pasado por parametro.
    public void higherPriceValidation(double price){
        if(this.price > price){
            System.out.println("Precio del producto es mayor al valor pasado por parametro" + this.price);
        }else{
            System.out.println("El precio ingresado es mayor al valor del producto" + price);
        }

    }
    //Determinar si el precio de un producto es menor o igual a un valor pasado por parametro.
    public void validatioPriceLessThanEqual (double price){
        if(this.price <= price){
            System.out.println("El precio es de menor precio o igual al valor pasado por parametro");
        }
    }


    //Determinar si el nombre del producto contiene una palabra pasada por parametro.
    public void productContainsTextParameter (String productName){
        this.productName.indexOf(productName);
        System.out.println("El producto contiene la palabra ingresada por parametro" + this.productName);
    }

    //Implementa una metodo para mostrar los productos que comienzan por una letra pasada por parámetro.
    public void searchProductByLetter (String l){
        for (String product: this.array) {
            if (product.startsWith(l)) {
                System.out.println("Se encontraron productos con la letra ingresada: " + l + "\n los cuales son: " + product + " ");
            }
        }
    }



    //el método está sobreescribiendo un método de la clase padre. devuelve una cadena JSON que contiene los valores de los atributos de la clase.
    @Override
    public String toString(){
        return "{'Nombre': " + productName + ", Descripcion: " + description + ", Categoria: \n" + category + ", Etiqueta: " + label + ", Precio: "
                + price + ", Unidades en inventario: " + stock + ", Url de imagen: " + urlPhoto + "}";
    }

}
