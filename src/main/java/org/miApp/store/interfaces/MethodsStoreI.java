package org.miApp.store.interfaces;
import org.miApp.bill.Bill;
import org.miApp.product.Product;
import org.miApp.store.Store;

import java.util.Optional;

public interface MethodsStoreI {

    void addProductToInventory(Product product);
    void addBillToInventory(Bill bill);
    Optional<Bill> findBillById(Integer id);
    void searchProduct(Store store);
    Optional<Product> findProductByIdOrName(String idOrName);
    void searchBillToInventory(Store store);

}
