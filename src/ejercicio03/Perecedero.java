package ejercicio03;

public class Perecedero extends Producto{
    private int diasCaducar;

    public Perecedero(String nombre, double precio, int diasCaducar){
        super(nombre, precio);
        setDiasCaducar(diasCaducar);
    }

    public void setDiasCaducar(int diasCaducar){
        if (diasCaducar < 0){
            throw new IllegalArgumentException("ERROR: Número de días no válido.");
        }
        this.diasCaducar = diasCaducar;
    }

    @Override
    public double Calcular(int cantidadProductos){
        double precioTotal = super.Calcular(cantidadProductos);

        return switch (diasCaducar) {
            case 1 -> precioTotal / 4;
            case 2 -> precioTotal / 3;
            case 3 -> precioTotal / 2;
            default -> precioTotal;
        };
    }

    @Override
    public String toString(){
        return super.toString() + diasCaducar;
    }
}