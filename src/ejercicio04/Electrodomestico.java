package ejercicio04;

import java.util.Locale;

public class Electrodomestico {
    protected double precioBase;
    protected String color;
    protected char consumoEnergetico;
    protected double peso;

    private final String COLOR_DEF = "blanco";
    private final char CONSUMO_DEF = 'F';
    private final double PRECIO_BASE_DEF = 100;
    private final double PESO_DEF = 5;

    /**
     * Constructor inicializado con el precioBase y el peso. El resto de atributos serán por defecto.
     * @param precioBase Precio base a asignar
     * @param peso Peso a asignar
     */
    public Electrodomestico(double precioBase, double peso){
        setPrecioBase(precioBase);
        this.color = COLOR_DEF;
        this.consumoEnergetico = CONSUMO_DEF;
        setPeso(peso);
    }

    /**
     * COnstructor con todos los atributos
     * @param precioBase Precio baser a asignar
     * @param color Color a asignar
     * @param consumoEnergetico Consumo energético a asignar
     * @param peso Peso a asignar
     */
    public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso){
        setPrecioBase(precioBase);
        comprobarColor(color);
        comprobarConsumoEnergetico(consumoEnergetico);
        setPeso(peso);
    }

    /**
     * Metodo que comprueba que el color es válido. Si es válido se le asigna el valor y
     * si no lo es se le asigna el valor por defecto
     * @param color Color que se quiere comprobar
     */
    private void comprobarColor(String color){
        String[] colores = {"blanco", "negro", "rojo", "azul", "gris"};

        boolean colorEncontrado = false;

        for (String c : colores){
            if (color.equalsIgnoreCase(c)) {
                colorEncontrado = true;
                this.color = color.toLowerCase();
                break;
            }
        }

        if (!colorEncontrado){
            this.color = COLOR_DEF;
        }
    }

    /**
     * Metodo que comprueba la letra del consumo energético. Si es válida la asigna y si no asigna la letra por defecto
     * @param letra Letra a asignar
     */
    private void comprobarConsumoEnergetico(char letra){
        letra = Character.toUpperCase(letra);

        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F'};

        boolean letraEncontrada = false;

        for (char l : letras){
            if(letra == l){
                letraEncontrada = true;
                this.consumoEnergetico = letra;
                break;
            }
        }

        if (!letraEncontrada){
            this.consumoEnergetico = CONSUMO_DEF;
        }
    }

    /**
     * Setter que valida que el precio base no sea negativo
     * @param precio Precio a validar
     */
    public void setPrecioBase(double precio){
        if (precio < 0){
            this.precioBase = PRECIO_BASE_DEF;
        } else{
            this.precioBase = precio;
        }
    }

    /**
     * Setter que valida que el peso no sea negativo
     * @param peso Peso a validar
     */
    public void setPeso(double peso){
        if (peso < 0){
            this.peso = PESO_DEF;
        }else {
            this.peso = peso;
        }
    }

    /**
     * Metodo que calcula el precio final
     * @return Devolvemo el precio base sumado a los aumentos
     */
    public double precioFinal(){
        double aumentoPrecio = 0;

        switch (consumoEnergetico){
            case 'A':
                aumentoPrecio += 100;
                break;
            case 'B':
                aumentoPrecio += 80;
                break;
            case 'C':
                aumentoPrecio += 60;
                break;
            case 'D':
                aumentoPrecio += 50;
                break;
            case 'E':
                aumentoPrecio += 30;
                break;
            case 'F':
                aumentoPrecio += 10;
                break;
        }

        if (peso > 0 && peso <= 19){
            aumentoPrecio += 10;
        } else if (peso > 19 && peso <= 49) {
            aumentoPrecio += 50;
        } else if (peso > 49 && peso <=79){
            aumentoPrecio += 80;
        } else{
            aumentoPrecio += 100;
        }

        return precioBase + aumentoPrecio;
    }

}