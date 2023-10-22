package org.miApp.store.interfaces;
import org.miApp.product.Product;
import org.miApp.stock.Stock;

import java.util.Optional;

public interface MethodsStoreI {

    void addProduct(Product product);

    Optional<Product> delProduct(Integer productId);

    Optional<Product> updateProduct(Integer productId, String productName, String description, String category, String label, Double price, String urlPhoto, Stock stock);

    Optional<Product> suspendProduct(Integer productId);

    Optional<Product> findProductByIdOrName(String idOrName);


}
