package interfaces.ejerciciosinterfaces.ejercicio01;

public class Socio implements Comparable{
    private int id;
    private String nombre;
    private int edad;

    public Socio(int id, String nombre, int edad){
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int compareTo(Object obj){
        int res = 0;
        Socio socio1 = (Socio) obj;
        if (this.id < socio1.id){
            res = -1;
        } else if(this.id > socio1.id){
            res = 1;
        }
        return res;
    }

    @Override
    public String toString(){
        return "id: " + id + "| Nombre: " + nombre + "| Edad: " + edad;
    }
}
