package interfaces.ejerciciosinterfaces.ejercicio01;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Socio[] listaSocios = new Socio[4];

        listaSocios[0] = new Socio(50, "Marta", 30);
        listaSocios[1] = new Socio(10, "Juan", 25);
        listaSocios[2] = new Socio(100, "Ana", 22);
        listaSocios[3] = new Socio(5, "Pedro", 40);

        System.out.println("--- Socios antes de ordenar ---");
        for (Socio s : listaSocios) {
            System.out.println(s);
        }
        Arrays.sort(listaSocios);

        System.out.println("\n--- Socios ordenados por ID (creciente) ---");
        for (Socio s : listaSocios) {
            System.out.println(s);
        }

        System.out.println("\n--- Prueba de comparación manual ---");
        Socio s1 = new Socio(1, "A", 20);
        Socio s2 = new Socio(2, "B", 20);

        if (s1.compareTo(s2) < 0) {
            System.out.println("El socio con ID " + s1 + " va antes que el de ID " + s2);
        }
    }
}