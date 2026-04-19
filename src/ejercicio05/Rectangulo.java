package ejercicio05;

public class Rectangulo extends Poligono{
    private double lado1;
    private double lado2;

    private final double LADO_PREDETERMINADO = 1;

    /**
     * Constructor de la clase Rectangulo sin parámetros
     */
    public Rectangulo(){
        super(4);
        this.lado1 = LADO_PREDETERMINADO;
        this.lado2 = LADO_PREDETERMINADO;
    }

    /**
     * Constructor de la clase Rectangulo con parámetros
     * @param lado1 Lado 1 a asignar
     * @param lado2 Lado 2 a asignar
     */
    public Rectangulo(double lado1, double lado2){
        super(4);
        setLado1(lado1);
        setLado2(lado2);
    }

    /**
     * Getter de lado 1
     * @return devuelve el lado 1
     */
    public double getLado1(){
        return lado1;
    }

    /**
     * Getter del lado 2
     * @return devuelve el lado 2
     */
    public double getLado2(){
        return lado2;
    }

    /**
     * Setter de lado 1 que valida que no sea negativo
     * @param lado1 lado a validar
     */
    public void setLado1(double lado1){
        if (lado1 < 0){
            throw new IllegalArgumentException("ERROR: Lado no válido");
        }
        this.lado1 = lado1;
    }

    /**
     * Setter de lado 2 que valida que no sea negativo
     * @param lado2 lado a validar
     */
    public void setLado2(double lado2){
        if (lado2 < 0){
            throw new IllegalArgumentException("ERROR: Lado no válido");
        }
        this.lado2 = lado2;
    }

    /**
     * Metodo que calcula el área del rectángulo
     * @return devuelve el área
     */
    @Override
    public double area(){
        return lado1 * lado2;
    }

    @Override
    public String toString(){
        return super.toString() + "| Rectángulo | Lado 1: " + lado1 + " | Lado 2: " + lado2;
    }
}