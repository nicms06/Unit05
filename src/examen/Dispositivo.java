package examen;

public abstract class Dispositivo implements Comparable{
    protected String nombreComercial;
    protected String marca;
    protected double precio;
    protected boolean indicadorEncendido;
    protected final boolean INDICADOR_PREDETERMINADO = false;

    /**
     * COnstructor de la clase Discpositivo
     * @param nombreComercial Nombre del dispositivo
     * @param marca Marca del dispositivo
     * @param precio Precio del dispositivo
     */
    public Dispositivo(String nombreComercial, String marca, double precio){
        this.nombreComercial = nombreComercial;
        this.marca = marca;
        setPrecio(precio);
        this.indicadorEncendido = INDICADOR_PREDETERMINADO;
    }

    /**
     * Setter que cvalida que el precio no sea negativo
     * @param precio Precio a validar
     */
    public void setPrecio(double precio){
        if (precio < 0){
            throw new IllegalArgumentException("ERROR: Precio no válido");
        }
        this.precio = precio;
    }

    /**
     * Metodo que enciende el dispositivo
     */
    public void encender(){
        if (indicadorEncendido){
            throw new IllegalArgumentException("ERROR: El dispositivo ya se encuentra encendido");
        }
        this.indicadorEncendido = true;
    }

    /**
     * Metodo que apaga el dispositivo
     */
    public void apagar(){
        if (!indicadorEncendido){
            throw new IllegalArgumentException("ERROR: El dispositivo ya se encuentra apagado");
        }
        this.indicadorEncendido = false;
    }

    /**
     * Metodo que devuelve si un dispositivo está encendido o apagado
     * @return Devolvemos true o false
     */
    public boolean isEncendido(){
        return indicadorEncendido;
    }

    /**
     * Metodo equals que comprieba si dos dispositivos son iguales (Nombre y marca)
     * @param objeto   the reference object with which to compare.
     * @return Devolvemos true si son iguales y false si no lo son
     */
    @Override
    public boolean equals(Object objeto) {
        boolean iguales = false;

        if (objeto instanceof Dispositivo) {
            Dispositivo dispo = (Dispositivo) objeto;
            iguales = (this.nombreComercial.equalsIgnoreCase(dispo.nombreComercial) &&
                    this.marca.equals(dispo.marca));
        }

        return iguales;
    }

    /**
     * Metodo compare to
     * @param obj
     * @return Devolvemos el objeto ordenado
     */
    public int compareTo(Object obj){
        int res = 0;
        Dispositivo dispo = (Dispositivo) obj;
        if (this.precio < dispo.precio){
            res = -1;
        } else if(this.precio > dispo.precio){
            res = 1;
        }
        return res;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombreComercial + "| Marca: " + marca + "|Precio: " + precio + "|Encendido: " + indicadorEncendido;
    }
}