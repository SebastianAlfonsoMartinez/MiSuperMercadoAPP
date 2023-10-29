package org.miApp.menu.enums;

public enum Menus {

    MAIN_MENU ("""
        |================================================|
              .-.   .-.     .--.                         |
             | OO| | OO|   / _.-'  .-.   .-.  .-.   .''. |
             |   | |   |   \\  '-.  '-'   '-'  '-'   '..' |
             '^^^' '^^^'    '--'                         |
         ===============.  .-.  .================.  .-.  |
        |               | |   | |                |  '-'  |
        |               | |   | |                |       |
        |               | ':-:' |                |  .-.  |
        |               |  '-'  |                |  '-'  |
         ==============='       '================'       |
        ±------------------------------------------------±
        |    Administrador Mi Tienda de Barrio           |
        ±------------------------------------------------±
        | 1. Gestion de productos                        |
        | 2. Vender Productos                            |
        | 3. Gestion facturas                            |
        | 0. Salir                                      |
        ±------------------------------------------------±
           Ingresa tu opción:    (0 - 3) """),
    Category_Menu("""
        ±------------------------------------------------±
        |    Select the value to update:                 |
        ±------------------------------------------------±
        | 1. Product Name                                |
        | 2. Description                                 |
        | 3. Category                                    |
        | 4. Label                                       |
        | 5. Price                                       |
        | 6. URL Photo                                   |
        | 7. Stock                                       |
        | 0. Back                                        |
        ±------------------------------------------------±
                Select the value to update (0-8):
            """),
    PRODUCT_MENU("""
        ±------------------------------------------------±
        |    Select the product option:                  |
        ±------------------------------------------------±
        | 1. Agregar producto                            |
        | 2. Eliminar producto                           |
        | 3. Actualizar producto                         |
        | 4. suspender producto                          |
        | 5. Buscar producto                             |
        | 6. Buscar productos por letra                  |
        | 6. Ver Inventario de productos                 |                             
        | 0. Back                                        |
        ±------------------------------------------------±
                Select the value to update (1-7):
            """),
    BILL_MENU("""
        ±------------------------------------------------±
        |    Select the product option:                  |
        ±------------------------------------------------±
        | 1. Buscar factura                              |
        | 2. Ver todas las facturas                      |             
        | 0. Back                                        |
        ±------------------------------------------------±
                Select the value to update (0-3):
            """)
    ;

    private final  String value;
    Menus(String value){this.value=value;}

    public void getValue(){
        System.out.println(value);}
}
