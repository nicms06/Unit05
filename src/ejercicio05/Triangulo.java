package ejercicio05;

public class Triangulo extends Poligono{
    private double lado1;
    private double lado2;
    private double lado3;

    private final double LADO_PREDETERMINADO = 1;

    /**
     * Constructor de la clase Triángulo sin parámetros
     */
    public Triangulo(){
        super(3);
        this.lado1 = LADO_PREDETERMINADO;
        this.lado2 = LADO_PREDETERMINADO;
        this.lado3 = LADO_PREDETERMINADO;
    }

    /**
     * Constructor de la clase Triángulo con parámetros
     * @param lado1 Lado a asignar
     * @param lado2 Lado a asignar
     * @param lado3 Lado a asignar
     */
    public Triangulo(double lado1, double lado2, double lado3){
        super(3);
        setLado1(lado1);
        setLado2(lado2);
        setLado3(lado3);
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
     * Getter del lado 3
     * @return devuelve el lado 3
     */
    public double getLado3(){
        return lado3;
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
     * Setter de lado 2 que valida que no sea negativo
     * @param lado3 lado a validar
     */
    public void setLado3(double lado3){
        if (lado3 < 0){
            throw new IllegalArgumentException("ERROR: Lado no válido");
        }
        this.lado3 = lado3;
    }

    /**
     * Metodo que calcula el área del triángulo dado los 3 lados
     * @return Devolvemos el área
     */
    @Override
    public double area(){
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s-lado1) * (s-lado2) * (s-lado3));
    }

    @Override
    public String toString(){
        return super.toString() + "| Triángulo | Lado 1: " + lado1 + " | Lado 2: " + lado2 + " | Lado 3: " + lado3;
    }

}