package ejercicio04;

public class Lavadora extends Electrodomestico{
    private double carga;
    private final double CARGA_DEF = 5;

    /**
     * Constructor de la clase lavadora que se inicializa con el precio y el peso. El resto de atributos por defecto
     * @param precioBase Precio base a asignar
     * @param peso Peso a asignar
     */
    public Lavadora(double precioBase, double peso){
        super(precioBase, peso);
        this.carga = CARGA_DEF;
    }

    /**
     * Constriuctor con la carga y todos los atributos heredados de Electrodoméstico.
     * @param carga Carga a asignar
     * @param precioBase Precio a asignar
     * @param color Color a asignar
     * @param consumoEnergetico Consumo a asignar
     * @param peso Peso a asignar
     */
    public Lavadora(double carga, double precioBase, String color, char consumoEnergetico, double peso){
        super(precioBase, color, consumoEnergetico, peso);
        setCarga(carga);
    }

    /**
     * Setter que valida que la carga es válida. Si no lo es se le asigna el valor por defecto.
     * @param carga Carga a asignar;
     */
    public void setCarga(double carga){
        if (carga < 0){
            this.carga = CARGA_DEF;
        } else{
            this.carga = carga;
        }
    }

    /**
     * Si tiene una carga mayor de 30 kg, aumentará el precio 50 €, si no es así, no se incrementará el precio.
     * @return Devolvemos el precio Final
     */
    public double precioFinal(){
        double precioFinal = super.precioFinal();

        if (carga > 30){
            precioFinal += 50;
        }

        return precioFinal;
    }

}
