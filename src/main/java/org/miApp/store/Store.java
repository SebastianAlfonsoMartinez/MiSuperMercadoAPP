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
    final List<Product> productList = new ArrayList<>();
    final List<Bill> billList = new ArrayList<>();


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

    public static void searchProduct(Store store) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product name or ID to search");
        String productNameOrId = scanner.nextLine();

        store.findProductByIdOrName(productNameOrId);
        System.out.println("|----------------------------------- Busqueda del producto -----------------------------------|\n"+ store.findProductByIdOrName(productNameOrId));
    }
    public static void viewInventory(Store store){
        System.out.println("|----------------------------------- Verificando inventario de productos -----------------------------------\n|");
        System.out.println(store.getProductList().toString());
    }
    public static void manageBill(Store store){
        System.out.println("|----------------------------------- Control de Ventas -----------------------------------|\n"+store.getBillList());
        Scanner scanner =new Scanner(System.in);
        System.out.println("Ingrese el ID o el Nombre del producto a vender");
        Integer productId = scanner.nextInt();
        System.out.println("Ingrese la cantidad del producto a vender");
        Integer quantityProducts = scanner.nextInt();
        Bill bill = new Bill();
        store.saleProduct(productId, quantityProducts, bill);
        store.addBill(bill);
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

    public void saleProduct(Integer productId, Integer quantity, Bill bill){
        Optional<Product> productOptional = productList.stream().
                filter(product -> product.getId().equals(productId)).findFirst();

        if (productOptional.isPresent() && (productOptional.get().getStock().getStock() >= quantity) ){
            Product product = productOptional.get();
            product.getStock().setStock(product.getStock().getStock()-quantity);
            bill.addProductToBill(product);
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
