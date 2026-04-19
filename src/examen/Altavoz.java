package examen;

public class Altavoz  extends Dispositivo implements IConfigurable{
    private String nombreAsistente;
    private int nivelVolumen;
    private final int VOLUMEN_PREDETERMINADO = 30;
    private final int MIN_VOLUMEN = 0;
    private final int MAX_VOLUMEN = 100;
    private final int INCREMENTO = 5;

    public Altavoz (String nombre, String marca, double precio, String nombreAsistente){
        super(nombre, marca, precio);
        this.nivelVolumen = VOLUMEN_PREDETERMINADO;
        this. nombreAsistente = nombreAsistente;
    }

    public void setNivelVolumen(int nivelVolumen) {
        if (this.nivelVolumen > 100 || this.nivelVolumen < 0){
            throw new IllegalArgumentException("ERROR: Volumen no válido");
        }
        this.nivelVolumen = nivelVolumen;
    }

    @Override
    public void subir() throws DispositivoApagadoException{
        if (!isEncendido()){
            throw new DispositivoApagadoException();
        }

        nivelVolumen += INCREMENTO;
        if (nivelVolumen > 100){
            nivelVolumen = 100;
        }
    }

    @Override
    public void bajar() throws DispositivoApagadoException{
        if (!isEncendido()){
            throw new DispositivoApagadoException();
        }

        nivelVolumen -= INCREMENTO;
        if (nivelVolumen < 0){
            nivelVolumen = 0;
        }
    }

    @Override
    public String toString(){
        return nombreAsistente + "| Nivel Volumen: " + nivelVolumen;
    }
}
