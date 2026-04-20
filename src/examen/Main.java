package examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Crear el catálogo de dispositivos
        List<Dispositivo> catalogo = new ArrayList<>();

        // 2. Añadir diferentes dispositivos
        catalogo.add(new Altavoz("Echo Dot", "Amazon", 59.99, "Alexa"));
        catalogo.add(new Luz("Bombilla Inteligente", "Philips Hue", 29.50, "Cálido"));
        catalogo.add(new Termostato("Nest Learning", "Google", 249.00, 21.5));
        catalogo.add(new Camara("Stick Up Cam", "Ring", 99.00, "1080p"));

        // Añadimos uno repetido (según nombre y marca) para probar el equals si fuera necesario
        // catalogo.add(new Luz("Bombilla Inteligente", "Philips Hue", 15.00, "Frío"));

        System.out.println("--- Catálogo sin ordenar ---");
        imprimirCatalogo(catalogo);

        // 3. Ordenar el catálogo por precio (gracias al Comparable en Dispositivo)
        Collections.sort(catalogo);

        System.out.println("\n--- Catálogo ordenado por Precio (Ascendente) ---");
        imprimirCatalogo(catalogo);

        // 4. Prueba de funcionamiento y Excepciones
        System.out.println("\n--- Pruebas de funcionamiento ---");

        Dispositivo miAltavoz = catalogo.get(0); // Supongamos que es el más barato

        try {
            System.out.println("Intentando subir volumen del " + miAltavoz.nombreComercial + "...");
            // Esto fallará porque el dispositivo se crea apagado por defecto
            ((Altavoz) miAltavoz).subir();

        } catch (DispositivoApagadoException e) {
            System.err.println(e.getMessage()); // Imprime: "Error: el dispositivo está apagado."

            System.out.println("Encendiendo dispositivo y reintentando...");
            miAltavoz.encender();

            try {
                ((Altavoz) miAltavoz).subir();
                System.out.println("¡Volumen subido con éxito!");
                System.out.println(miAltavoz);
            } catch (DispositivoApagadoException ex) {
                // No debería entrar aquí
            }
        } catch (ClassCastException e) {
            System.out.println("El primer dispositivo del catálogo no era un Altavoz.");
        }

        // 5. Prueba de Alerta en el Termostato
        for (Dispositivo d : catalogo) {
            if (d instanceof Termostato) {
                try {
                    d.encender();
                    ((Termostato) d).activar("¡Temperatura crítica detectada!");
                    System.out.println("\nEstado del termostato tras alerta:");
                    System.out.println(d);
                } catch (DispositivoApagadoException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    /**
     * Método auxiliar para mostrar el catálogo por consola
     */
    public static void imprimirCatalogo(List<Dispositivo> lista) {
        for (Dispositivo d : lista) {
            System.out.println(d.toString());
        }
    }
}