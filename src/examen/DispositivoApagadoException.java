package examen;

public class DispositivoApagadoException extends Exception {
    public DispositivoApagadoException() {
        super("ERROR: El dispositivo está apagado.");
    }
}
