package ejercicio02;

public class Empleado {
    private String nombre;

    public Empleado(String nombre){
        setNombre(nombre);
    }

    public void setNombre(String nombre){
        String[] nombreSeparado = nombre.split("");

        for (String letra : nombreSeparado){
            if (Character.isDigit(letra.charAt(0))){
                throw new IllegalArgumentException("ERROR: Nombre inválido.");
            }
        }

        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    @Override
    public String toString(){
        return  "Empleado " + nombre;
    }
}
