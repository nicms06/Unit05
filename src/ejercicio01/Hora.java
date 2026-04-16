package ejercicio01;

public class Hora {
    protected int hora;
    protected int minuto;

    public Hora(int hora, int minuto){
        setHora(hora);
        setMinuto(minuto);
    }

    public void setHora(int hora){
        if (hora < 0 || hora > 23){
            throw new IllegalArgumentException("ERROR: Hora no válida.");
        }
        this.hora = hora;
    }

    public void setMinuto(int minuto){
        if (minuto < 0 || minuto > 59){
            throw new IllegalArgumentException("ERROR: Minuto no válida.");
        }
        this.minuto = minuto;
    }

    public void inc(){
        minuto ++;

        if (minuto > 59){
            minuto = 0;
            hora ++;

            if (hora > 23){
                hora = 0;
            }
        }
    }

    @Override
    public String toString(){
        return String.format("%d:%02d", hora, minuto);
    }
}