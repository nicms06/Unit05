package ejercicio05;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Poligono> Poligonos= new ArrayList<>();

        int opcion = 0;
        do{
            menu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("\n--- Nuevo Triángulo ---");
                    System.out.print("Introduce el lado 1: ");
                    double l1 = sc.nextDouble();
                    System.out.print("Introduce el lado 2: ");
                    double l2 = sc.nextDouble();
                    System.out.print("Introduce el lado 3: ");
                    double l3 = sc.nextDouble();

                    try {
                        Triangulo t = new Triangulo(l1, l2, l3);
                        Poligonos.add(t);
                        System.out.println("Triángulo añadido correctamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("\n--- Nuevo Rectángulo ---");
                    System.out.print("Introduce el lado 1: ");
                    l1 = sc.nextDouble();
                    System.out.print("Introduce el lado 2: ");
                    l2 = sc.nextDouble();

                    try {
                        Rectangulo r = new Rectangulo(l1, l2);
                        Poligonos.add(r);
                        System.out.println("Rectángulo añadido correctamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    if (Poligonos.isEmpty()) {
                        System.out.println("La lista está vacía.");
                    } else {
                        System.out.println("\n--- Listado de Polígonos ---");
                        for (Poligono p : Poligonos) {
                            System.out.println(p.toString() + " | Área Total: " + p.area());
                        }
                    }

            }

        } while(opcion != 4);

        sc.close();
    }

    static void menu(){
        System.out.println("============== Menu ==============");
        System.out.println("1. Introducir Triángulo");
        System.out.println("2. Introducir Rectángulo");
        System.out.println("3. Mostrar Polígonos");
        System.out.println("4. Salir");
        System.out.println("==================================");
        System.out.println("\nIntroduce una opción:");
    }
}
