package org.miApp.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class SuperKeyBoard {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static Integer readNumber() {
        int number = 0;
        try {
            number = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException | IOException e) {
            // validar el tipo de excepcion
            if (e instanceof NumberFormatException){
                System.out.println("El numero que digitaste es incorrecto, intenta nuevamente:");
            } else {
                System.out.println("El valor que ingresaste no fue leido, intenta nuevamente:");
            }
            number = readNumber();
        }
        return number;
    }

    public static String readText() {
        try {
            String input = reader.readLine();
            if (input != null && !input.trim().isEmpty())
                return input;
            else {
                System.out.println("No puedes ingresar un campo vacío. Intenta nuevamente.");
                return readText();
            }
        } catch (IOException e) {
            System.out.println("El valor que ingresaste no fue leido, intenta nuevamente");
            return readText();
        }
    }

    public static char readCharacter() {
        try {
            return reader.readLine().charAt(0);
        } catch (IOException e) {
            System.out.println("El valor que ingresaste no fue leido, intenta nuevamente");
            return readCharacter();
        }
    }

    public static Double readDecimalNumber() {
        double number = 0;
        try {
            number = Double.parseDouble(reader.readLine());
        } catch (NumberFormatException | IOException e) {
            // validar el tipo de excepcion
            if (e instanceof NumberFormatException){
                System.out.println("El numero que digitaste es incorrecto, intenta nuevamente:");
            } else {
                System.out.println("El valor que ingresaste no fue leido, intenta nuevamente:");
            }
            number = readDecimalNumber();
        }
        return number;
    }

    public static Long readBigNumber(){
        long number = 0;
        try {
            number = Long.parseLong(reader.readLine());
        } catch (NumberFormatException | IOException e) {
            // validar el tipo de excepcion
            if (e instanceof NumberFormatException){
                System.out.println("El numero que digitaste es incorrecto, intenta nuevamente:");
            } else {
                System.out.println("El valor que ingresaste no fue leido, intenta nuevamente:");
            }
            number = readBigNumber();
        }
        return number;
    }

}
