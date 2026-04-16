package ejercicio03;

public class Producto {
    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        setPrecio(precio);
    }

    public void setPrecio(double precio){
        if (precio < 0){
            throw new IllegalArgumentException("ERROR: Precio no válido.");
        }
        this.precio = precio;
    }

    public double Calcular(int cantidadProductos){
        return precio * cantidadProductos;
    }

    @Override
    public String toString(){
        return nombre + ": " + precio + "$";
    }
}