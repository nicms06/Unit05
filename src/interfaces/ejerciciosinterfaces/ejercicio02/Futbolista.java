package interfaces.ejerciciosinterfaces.ejercicio02;

import java.util.Objects;

public class Futbolista implements Comparable{
    private int numeroCamiseta;
    private String nombre;
    private int edad;
    private int numeroGoles;

    public Futbolista(int numeroCamiseta, String nombre, int edad, int numeroGoles){
        this.numeroCamiseta = numeroCamiseta;
        this.nombre = nombre;
        this.edad = edad;
        this.numeroGoles = numeroGoles;
    }

    @Override
    public String toString(){
        return "Número: " + numeroCamiseta + "| Nombre: " + nombre + "| Edad: " + edad + "| Goles: " + numeroGoles;
    }

    @Override
    public boolean equals(Object objeto) {
        boolean iguales = false;

        if (objeto instanceof Futbolista) {
            Futbolista otro = (Futbolista) objeto;
            iguales = (this.numeroCamiseta == otro.numeroCamiseta &&
                    this.nombre.equals(otro.nombre));
        }

        return iguales;
    }

    v
}
