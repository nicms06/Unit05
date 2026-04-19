package examen;

public interface IEmitirAlerta {
    void activar(String mensaje) throws DispositivoApagadoException;
    void desactivar() throws DispositivoApagadoException;
    boolean isAlertaActiva();
}
