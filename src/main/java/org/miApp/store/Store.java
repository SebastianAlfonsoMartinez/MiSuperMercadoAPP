package org.miApp.store;

import org.miApp.bill.Bill;
import org.miApp.product.Product;
import org.miApp.stock.Stock;
import org.miApp.store.interfaces.MethodsStoreI;

import java.util.*;

public class Store implements MethodsStoreI {
    private final Set<Product> productList = new HashSet<>();
    private final Set<Bill> billList = new HashSet<>();
    private final List<Product> removedProducts = new ArrayList<>();


    public Set<Product> getProductList() {
        return productList;
    }

    public Set<Bill> getBillList() {
        return billList;
    }




    public void addProductToInventory(Product product){
        if (!productList.contains(product)){
            productList.add(product);

        }
    }
    public void addBillToInventory(Bill bill){
        if (!billList.contains(bill)){
            billList.add(bill);
        }
    }
    public void totalPriceToBill(Bill bill){
        double totalPrice = 0.0;
        for (Product product : bill.getListProduct()){
            totalPrice += (product.getPrice() * product.getStock().getStock());
        }
        double tax = 0.19 * totalPrice;
        double totalPriceWithTax = totalPrice + tax;
        bill.setTotalPrice(totalPriceWithTax);
    }

    public void removeProductToInventory(Store store){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product id to remove");
        Integer productId = scanner.nextInt();

        Optional<Product> productToRemove = store.getProductList().stream().
                filter(product -> product.getId()==productId).findFirst();
        productToRemove.ifPresent(store.getProductList()::remove);

        System.out.println("|----------------------------------- Se elimino un producto -----------------------------------|\n");
        System.out.println(productToRemove);
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
        Optional<Product> optionalProduct = productList.stream()
                .filter(product -> String.valueOf(product.getId()).equalsIgnoreCase(productNameOrId) || product.getProductName().equalsIgnoreCase(productNameOrId))
                .findAny();
        System.out.println("|----------------------------------- Busqueda del producto -----------------------------------|\n"
        + optionalProduct.get());
    }
    public void searchBillToInventory(Store store){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Bill ID to search");
        Integer productNameOrId = scanner.nextInt();

        System.out.println(store.findBillById(productNameOrId));
        System.out.println("|----------------------------------- Busqueda del producto -----------------------------------|\n");
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
            totalPriceToBill(bill);
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
