package org.miApp.product;

import java.util.Arrays;

public class ProductArray {

    //ATRIBUTOS
    private String[] array;

    public ProductArray(String[] array) {
        this.array = array;
    }


    //CONSTRUCTORES


    //GETTER AND SETTER
    public String[] getArray() {
        for (String arrayProduct : this.array) {
            //System.out.println(arrayProduct);
        }
        return this.array;
    }

    public String[] setArray(String[] array) {
        this.array = array;
        return this.array;
    }

    //METODOS

    public void searchProductByLetter(String l) {
        System.out.println("Se encontraron productos con la letra ingresada: " + l + "\n los cuales son: ");
        for (String product : this.array) {
            if (product.startsWith(l)) {
                System.out.println(product + " ");
            }
        }
    }

    public static void ordenarArrayAlfabeticamente(String[] array) {
        // Utilizar el método sort de la clase Arrays para ordenar el array alfabéticamente
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].toLowerCase();

        }
        Arrays.sort(array);
        for (String productos : array) {
            System.out.println(productos);

        }
    }

    @Override
    public String toString() {
        return "ProductArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}





