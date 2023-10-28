package org.miApp.product;

import org.miApp.store.Store;

import java.util.Optional;

public interface MethodsProductI {
    CategoryProduct selectCategory();
    void addProduct(Store store);

    void updateProduct(Store store);
    void  suspendProduct(Store store);

}
