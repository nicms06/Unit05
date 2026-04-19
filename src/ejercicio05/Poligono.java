package ejercicio05;

abstract class Poligono {
     protected int numeroLados;

    /**
     * COnstructor de la clase poligono
     * @param numeroLados Parámetro a asignar
     */
    public Poligono(int numeroLados){
        setNumeroLados(numeroLados);
    }

    /**
     * Setter que valida que el número de lados no sea menor a 3
     * @param numeroLados Número de lados que queremos validar
     */
     public void setNumeroLados(int numeroLados){
         if (numeroLados < 3){
             throw new IllegalArgumentException("ERROR: Número de lados no válido.");
         }
         this.numeroLados = numeroLados;
     }

    /**
     * Getter para el número de lados
     * @return devolvemos el número de lados
     */
    public int getNumeroLados(){
         return numeroLados;
    }

    /**
     * Metodo abstracto para el cálculo de área
     * @return devolvemos el área
     */
    public abstract double area();

     @Override
     public String toString(){
         return "Número de lados: " + numeroLados;
     }
}