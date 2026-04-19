package examen;

public class Camara extends Dispositivo implements IEmitirAlerta {
    private String resolucion;
    private boolean grabando;
    private boolean alertaActiva;
    private String mensajeAlerta;

    public Camara(String nombre, String marca, double precio, String resolucion) {
        super(nombre, marca, precio);
        this.resolucion = resolucion;
        this.grabando = false;
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }

    public void iniciarGrabacion() throws DispositivoApagadoException {
        if (!isEncendido()) throw new DispositivoApagadoException();
        this.grabando = true;
    }

    public void detenerGrabacion() {
        this.grabando = false;
    }

    @Override
    public void activar(String mensaje) throws DispositivoApagadoException {
        if (!isEncendido()) throw new DispositivoApagadoException();
        this.alertaActiva = true;
        this.mensajeAlerta = mensaje;
    }

    @Override
    public void desactivar() throws DispositivoApagadoException {
        if (!isEncendido()) throw new DispositivoApagadoException();
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }

    @Override
    public boolean isAlertaActiva() {
        return alertaActiva;
    }

    @Override
    public String toString() {
        String estadoGrabacion = grabando ? "GRABANDO" : "En espera";
        String estadoAlerta = alertaActiva ? " !!! ALERTA: " + mensajeAlerta + " !!!" : " OK";
        return super.toString() + " | Res: " + resolucion + " | " + estadoGrabacion + estadoAlerta;
    }
}