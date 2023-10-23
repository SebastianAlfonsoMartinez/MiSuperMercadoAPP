package org.miApp.store;

import org.miApp.bill.Bill;
import org.miApp.product.Product;
import org.miApp.stock.Stock;
import org.miApp.store.interfaces.MethodsStoreI;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Store implements MethodsStoreI {
    private final List<Product> productList = new ArrayList<>();
    private final List<Bill> billList = new ArrayList<>();


    public List<Product> getProductList() {
        return productList;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void addProduct(Product product){
        if (!productList.contains(product)){
            productList.add(product);
        }
    }
    public void addBill(Bill bill){
        if (!billList.contains(bill)){
            billList.add(bill);
        }
    }
    public Optional<Product> delProduct(Integer productId){
            Optional<Product> productToRemove = productList.stream().
                    filter(product -> product.getId()==productId).findFirst();
            productToRemove.ifPresent(productList::remove);
            return productToRemove;
    }

    public Optional<Product> updateProduct(Integer productId, String productName, String description, String category, String label, Double price, String urlPhoto, Stock stock){
        Optional<Product> productToUpdate = productList.stream().
                filter(product -> product.getId()==productId).findFirst();
        productToUpdate.ifPresent(product -> {
            product.setProductName(productName);
            product.setDescription(description);
            product.setCategory(category);
            product.setLabel(label);
            product.setPrice(price);
            product.setUrlPhoto(urlPhoto);
            product.setStock(stock);
        });
        return productToUpdate;
    }

    public Optional<Product> suspendProduct(Integer productId) {
        Optional<Product> productToSuspend = productList.stream().
                filter(product -> product.getId() == productId).findFirst();
        productToSuspend.ifPresent(product -> product.setSuspended(true));
        return productToSuspend;
    }

    public Optional<Product> findProductByIdOrName(String idOrName) {
        return productList.stream()
                .filter(product -> String.valueOf(product.getId()).equals(idOrName) || product.getProductName().equals(idOrName))
                .findAny();
    }

    public Optional<Bill> findBillById(Integer id){
        return billList.stream().
                filter(bill -> bill.getIdBill()
                        .equals(id)).findAny();
    }

    public void searchProduct(Store store) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product name or ID to search");
        String productNameOrId = scanner.nextLine();

        store.findProductByIdOrName(productNameOrId);
        System.out.println("|----------------------------------- Busqueda del producto -----------------------------------|\n"+ store.findProductByIdOrName(productNameOrId));
    }
    public void viewInventory(Store store){
        System.out.println("|----------------------------------- Verificando inventario de productos -----------------------------------\n|");
        System.out.println(store.getProductList().toString());
    }

    public void searchProductByLetter(char letter) {
        boolean found = false;
        for (Product product : productList) {
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

    public void saleProduct(Optional<Product> productOptional, Integer quantity, Bill bill){

        if (productOptional.isPresent() && (productOptional.get().getStock().getStock() >= quantity) ){
            Product product = productOptional.get();
            product.getStock().setStock(product.getStock().getStock()-quantity);
            Product productBill = new Product(product.getId(),product.getProductName(), product.getDescription(),
                    product.getPrice(), new Stock(quantity));
            bill.addProductToBill(productBill);
            System.out.println("Producto agregado con exito");
        }else
            System.out.println("No hay suficientes unidades del producto, unidades en stock: " + productOptional.get().getStock().getStock());
    }
    @Override
    public String toString() {
        return "Store{" +
                "productList=" + productList +
                ", billList=" + billList +
                '}';
    }
}
