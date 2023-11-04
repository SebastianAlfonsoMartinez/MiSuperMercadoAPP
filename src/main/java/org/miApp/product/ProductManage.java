package org.miApp.product;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.miApp.bill.Bill;
import org.miApp.bill.BillManage;
import org.miApp.customer.Customer;
import org.miApp.customer.CustomerManage;
import org.miApp.menu.SuperKeyBoard;
import org.miApp.menu.enums.Menus;
import org.miApp.stock.Stock;


import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ProductManage {

    private final Set<Product> productList = new HashSet<>();

    public ProductManage() {
    }

    public Set<Product> getProductList() {
        return productList;
    }

    public void addProductToInventory(Product product) {
        if (!productList.contains(product)) {
            productList.add(product);

        }
    }

    public void addProduct() {
        System.out.println("Enter the product name");
        String productName = SuperKeyBoard.readText();
        System.out.println("Enter the product description");
        String description = SuperKeyBoard.readText();
        CategoryProduct category = selectCategory();
        System.out.println("Enter the product label");
        String label = SuperKeyBoard.readText();
        System.out.println("Enter the product url Photo");
        String urlPhoto = SuperKeyBoard.readText();
        System.out.println("Enter the product price");
        Double price = SuperKeyBoard.readDecimalNumber();
        System.out.println("Enter the product Stock");
        Integer stock = SuperKeyBoard.readNumber();

        Stock stock1 = new Stock(stock);
        Product product = new Product(productName, description, category.getValue(), label, price, urlPhoto, stock1);

        addProductToInventory(product);
        System.out.println("|----------------------------------- Se agrego un producto -----------------------------------|\n"
                + product.toString());
    }

    public void addProductToListProductTheBill(Product product, Bill bill) {
        if (!bill.getListProduct().contains(product)) {
            bill.getListProduct().add(product);
        }
    }

    public void addProductToBill(ProductManage productManage, BillManage billManage) {

        Customer customer = new CustomerManage().createCustomer();
        Bill bill1 = new Bill(customer);

        Boolean addMoreProduct = true;
        while (addMoreProduct) {
            addMoreProduct = validateOptionAddNewProduct(productManage, bill1, billManage);
        }
        billManage.addBillToInventory(bill1);
        System.out.println(bill1);
    }



    public Boolean validateOptionAddNewProduct(ProductManage productManage, Bill bill, BillManage billManage) {
        System.out.println("Enter the product ID to buy");
        String productNameOrId = SuperKeyBoard.readText();
        System.out.println("Enter the amount the Products to buy");
        Integer quantityProducts = SuperKeyBoard.readNumber();

        Optional<Product> optionalProduct = productManage.findProductByIdOrName(productNameOrId);

        if (!optionalProduct.isEmpty()) {
            productManage.saleProduct(optionalProduct, quantityProducts, bill, billManage);
        } else
            System.out.println("|----------------------------------- No se encontro el Producto -----------------------------------|\n");

        System.out.println("Desea comprar mas productos (Si/No)");
        String requestToBuy = SuperKeyBoard.readText();
        billManage.totalPriceToBill(bill);
        return "si".equalsIgnoreCase(requestToBuy);
    }

    public Optional<Product> findProductByIdOrName(String idOrName) {
        return productList.stream()
                .filter(product -> String.valueOf(product.getId()).equals(idOrName) || product.getProductName().equals(idOrName))
                .findAny();
    }

    public void searchProduct() {
        System.out.println("Enter the product name or ID to search");
        String productNameOrId = SuperKeyBoard.readText().toLowerCase();

        List<Product> matchingProducts = productList.stream()
                .filter(product -> String.valueOf(product.getId()).equalsIgnoreCase(productNameOrId) || product.getProductName().toLowerCase().contains(productNameOrId))
                .collect(Collectors.toList());

        if (matchingProducts.isEmpty()) {
            System.out.println("No se encontraron productos que coincidan con la búsqueda.");
        } else {
            System.out.println("|----------------------------------- Resultados de la búsqueda -----------------------------------|");
            for (Product product : matchingProducts) {
                System.out.println(product);
            }
        }
    }


    public CategoryProduct selectCategory() {
        System.out.println("Select a category by entering the corresponding number: ");
        for (int i = 0; i < CategoryProduct.values().length; i++) {
            System.out.println((i + 1) + ". " + CategoryProduct.values()[i].getValue());
        }
        int choise = SuperKeyBoard.readNumber();

        if (choise >= 1 && choise <= CategoryProduct.values().length)
            return CategoryProduct.values()[choise - 1];
        else {
            System.out.println("Invalid choise. Please select a valid category.");
            return selectCategory();
        }
    }

    public void removeProductToInventory() {
        System.out.println("Enter the product id to remove");
        Integer productId = SuperKeyBoard.readNumber();

        Optional<Product> productToRemove = getProductList().stream().
                filter(product -> product.getId() == productId).findFirst();
        productToRemove.ifPresent(getProductList()::remove);

        System.out.println("|----------------------------------- Se elimino un producto -----------------------------------|\n");
        System.out.println(productToRemove);
    }


    public void updateProduct() {
        System.out.println("Enter the product ID to update");
        String productId = SuperKeyBoard.readText();
        Optional<Product> productToUpdate = findProductByIdOrName(productId);

        if (productToUpdate.isPresent()) {
            Product product = productToUpdate.get();
            Boolean updateMoreProduct = true;

            while (updateMoreProduct) {
                updateMoreProduct = validateOptionUpdateProduct(product);
            }
        } else {
            System.out.println("Product not found with the given ID or name.");
        }
    }

    public Boolean validateOptionUpdateProduct(Product product) {
        Menus.Category_Menu.getValue();
        int choice = SuperKeyBoard.readNumber();

        switch (choice) {
            case 1:
                System.out.println("Enter the new product name");
                product.setProductName(SuperKeyBoard.readText());
                break;
            case 2:
                System.out.println("Enter the new description");
                product.setDescription(SuperKeyBoard.readText());
                break;
            case 3:
                System.out.println("Enter the new category");
                product.setCategory(selectCategory().name());
                break;
            case 4:
                System.out.println("Enter the new label");
                product.setLabel(SuperKeyBoard.readText());
                break;
            case 5:
                System.out.println("Enter the new price");
                product.setPrice(SuperKeyBoard.readDecimalNumber());
                break;
            case 6:
                System.out.println("Enter the new URL Photo");
                product.setUrlPhoto(SuperKeyBoard.readText());
                break;
            case 7:
                System.out.println("Enter the new stock");
                product.getStock().setStock(SuperKeyBoard.readNumber());
                break;
            case 0:
                return false;
            default:
                System.out.println("Invalid choice");
                break;
        }
        System.out.println("|----------------------------------- Product Updated -----------------------------------|\n" + product);
        System.out.println("Desea actualizar mas atributos (Si/No)");
        String requestToBuy = SuperKeyBoard.readText();
        return requestToBuy.equalsIgnoreCase("si");
    }

    public void productsManagement(){
        System.out.println("Agrega un producto al inventario");

        Boolean manageMoreProduct = true;
        while (manageMoreProduct) {
            manageMoreProduct = validateOptionMenuProduts();
            }
        }

    public Boolean validateOptionMenuProduts(){
        Menus.PRODUCT_MENU.getValue();
        int choice = SuperKeyBoard.readNumber();

        switch (choice) {
            case 1-> addProduct();
            case 2 -> removeProductToInventory();
            case 3 -> updateProduct();
            case 4 -> suspendProduct();
            case 5 -> searchProduct();
            case 6 -> searchProductByLetter();
            case 7 -> viewInventory();
            case 8 -> loadInventory();
            case 0 -> {
                System.out.println("Saliendo");
                return false; // Salir del bucle
            }
            default -> System.out.println("Invalid choice");
        }
        System.out.println("Desea gestionar mas productos (Si/No)");
        String requestManageProducts = SuperKeyBoard.readText();
        return requestManageProducts.equalsIgnoreCase("si");
    }


    public void suspendProduct() {
        System.out.println("Enter the product ID to suspend");
        Integer productId = SuperKeyBoard.readNumber();
        Optional<Product> productToSuspend = getProductList().stream().
                filter(product -> product.getId() == productId).findFirst();
        productToSuspend.ifPresent(product -> product.setSuspended(true));

        System.out.println("|----------------------------------- Se suspendio un producto -----------------------------------|");
        System.out.println(productToSuspend.get());
    }

    public void viewInventory() {
        System.out.println("|----------------------------------- Verificando inventario de productos -----------------------------------\n|");
        System.out.println(getProductList().toString());
    }

    public void searchProductByLetter() {
        System.out.println("Ingrese la letra para buscar los productos que inicien con dicha letra");
        char letter = SuperKeyBoard.readCharacter();
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
        if (!found) {
            System.out.println("No se encontraron productos por la letra: " + letter);
        }
    }

    public void saleProduct(Optional<Product> productOptional, Integer quantity, Bill bill, BillManage billManage) {

        if (productOptional.isPresent() && (productOptional.get().getStock().getStock() >= quantity)) {
            Product product = productOptional.get();
            product.getStock().setStock(product.getStock().getStock() - quantity);
            Product productBill = new Product(product.getId(), product.getProductName(), product.getDescription(),
                    product.getPrice(), new Stock(quantity));
            addProductToListProductTheBill(productBill, bill);
            billManage.totalPriceToBill(bill);
            System.out.println("Producto agregado con exito");
        } else
            System.out.println("No hay suficientes unidades del producto, unidades en stock: " + productOptional.get().getStock().getStock());
    }

    public void loadInventory (){
        Random random = new Random();
        try {
            FileReader fileReader = new FileReader("C:/Users/SEBASTIAN/Downloads/Ejercicios_de_Ejemplo/MiSuperMercadoAPP/src/main/resources/inventory/inventory.csv");
            CSVParser csvParser = CSVFormat.EXCEL.withHeader("Nombre", "Descripcion", "Categoria", "Etiquetas", "Precio", "URL FOTO").withDelimiter(';').parse(fileReader);

            for (CSVRecord csvRecord : csvParser) {
                String name = validateText(csvRecord.get("Nombre"));
                String description = validateText(csvRecord.get("Descripcion"));
                String category = validateText(csvRecord.get("Categoria"));
                String tags = validateText(csvRecord.get("Etiquetas"));
                Double price = validatePrice(csvRecord.get("Precio"));
                String imgUrl = validateText(csvRecord.get("URL FOTO"));
                Integer stock = random.nextInt(100);

                Stock stock1 = new Stock(stock);

                addProductToInventory(new Product(name, description, category, tags, price, imgUrl, stock1));
                System.out.println(getProductList());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String validateText(String text) {
        return (text != null && !text.isEmpty()) ? text : "N/A";
    }

    private static Double validatePrice(String num) {
        if (num != null && !num.isEmpty() && !num.equalsIgnoreCase("N/A")) {
            try {
                return Double.parseDouble(num);
            } catch (NumberFormatException e) {
                return 0.0D;
            }
        }
        return 0.0D;
    }

    @Override
    public String toString() {
        return "ProductManage{" +
                "productList=" + productList +
                '}';
    }
}

