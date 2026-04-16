package ejercicio01;

public class HoraExacta extends Hora{
    private int segundo;

    HoraExacta(int hora, int minuto, int segundo){
        super(hora, minuto);
        setSegundo(segundo);
    }

    public void setSegundo(int segundo){
        if (segundo > 59 || segundo < 0){
            throw new IllegalArgumentException("ERROR: Segundos no válidos.");
        }
        this.segundo = segundo;
    }

    public void inc(){
        segundo ++;
        if (segundo > 59){
            segundo = 0;
            super.inc();
        }
    }

    @Override
    public String toString(){
        return super.toString() + String.format(":%02d", segundo);
    }
}