package org.miApp.product;

    public enum CategoryProduct {
        ASEO_DE_HOGAR("Aseo de Hogar"),
        BEBIDAS("Bebidas"),
        CARNES_FRIAS_Y_CONGELADOS("Carnes frías y Congelados"),
        CIGARRILLOS("Cigarrillos"),
        CUIDADO_BEBE("Cuidado Bebé"),
        CUIDADO_PERSONAL("Cuidado Personal"),
        CUIDADO_ROPA("Cuidado Ropa"),
        DESPENSA("Despensa"),
        DROGERIA("Droguería"),
        DULCES_Y_POSTRES("Dulces y Postres"),
        ELECTRODOMESTICOS("Electrodomésticos"),
        HELADOS("Helados"),
        HOGAR_Y_DECORACION("Hogar y Decoración"),
        ILUMINACION_Y_ELECTRICOS("Iluminación y Eléctricos"),
        LACTEO_HUEVOS_Y_REFRIGERADOS("Lácteo/Huevos y Refrigerados"),
        LIMPIEZA_COCINA("Limpieza Cocina"),
        MASCOTAS("Mascotas"),
        PANADERIA_Y_PASTELERIA("Panadería y Pastelería"),
        PRODUCTOS_CONGELADOS("Productos Congelados"),
        VINOS_Y_LICORES("Vinos y Licores");

        private final String value;

        CategoryProduct(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


