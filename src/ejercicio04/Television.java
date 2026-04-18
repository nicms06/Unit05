package ejercicio04;

public class Television extends Electrodomestico{
    private double resolucion;
    private boolean sintonizador;

    private final double RESOLUCION_DEF = 20;
    private final boolean SINTONIZADOR_DEF = false;

    /**
     * Constructor de la clase Televisión con los atributos precioBase y peso. Los demás atributos por defecto
     * @param precioBase Precio a asignar
     * @param peso peso a asignar
     */
    public Television(double precioBase, double peso){
        super(precioBase, peso);
        this.resolucion = RESOLUCION_DEF;
        this.sintonizador = SINTONIZADOR_DEF;
    }

    /**
     * COnstructor con todos los atributos
     * @param resolucion Resolucion a asignar
     * @param sintonizador Sintonizador a asignar
     * @param precioBase Precio base a asignar
     * @param color Color a asignar
     * @param consumoEnergetico Consumo a asignar
     * @param peso Peso a asignar
     */
    public Television(double resolucion, boolean sintonizador, double precioBase, String color, char consumoEnergetico, double peso){
        super(precioBase, color, consumoEnergetico, peso);
        setResolucion(resolucion);
        this.sintonizador = sintonizador;
    }

    /**
     * Setter que comprueba que la resolucion no se anegativa. Si lo es se le da el valor por defecto
     * @param resolucion Resolución a validar
     */
    public void setResolucion(double resolucion){
        if (resolucion < 0){
            this.resolucion = RESOLUCION_DEF;
        } else{
            this.resolucion = resolucion;
        }
    }

    public double precioFinal(){
        double precioFinal = super.precioFinal();

        if (resolucion > 40){
            precioFinal += (precioFinal * 30 / 100);
        }

        if (sintonizador){
            precioFinal += 50;
        }

        return precioFinal;
    }

}




















