package examen;

public class Termostato extends Dispositivo implements IEmitirAlerta {
    private double temperaturaObjetivo;
    private String modoFuncionamiento;
    private boolean alertaActiva;
    private String mensajeAlerta;

    // Constantes para los modos (para evitar errores de escritura)
    private final String MODO_ECO = "ECO";
    private final String MODO_INVIERNO = "INVIERNO";
    private final String MODO_VERANO = "VERANO";

    public Termostato(String nombre, String marca, double precio, double temperatura) {
        super(nombre, marca, precio);
        this.temperaturaObjetivo = temperatura;
        this.modoFuncionamiento = MODO_ECO; // Modo inicial por defecto
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }

    /**
     * Alterna el modo de funcionamiento de forma cíclica:
     * ECO -> INVIERNO -> VERANO -> ECO
     */
    public void cambiarModo() {
        switch (this.modoFuncionamiento) {
            case MODO_ECO:
                this.modoFuncionamiento = MODO_INVIERNO;
                break;
            case MODO_INVIERNO:
                this.modoFuncionamiento = MODO_VERANO;
                break;
            case MODO_VERANO:
                this.modoFuncionamiento = MODO_ECO;
                break;
        }
    }

    @Override
    public void activar(String mensaje) throws DispositivoApagadoException {
        // Regla: Solo si está encendido
        if (!isEncendido()) {
            throw new DispositivoApagadoException();
        }
        this.alertaActiva = true;
        this.mensajeAlerta = mensaje;
    }

    @Override
    public void desactivar() throws DispositivoApagadoException {
        if (!isEncendido()) {
            throw new DispositivoApagadoException();
        }
        this.alertaActiva = false;
        this.mensajeAlerta = "";
    }

    @Override
    public boolean isAlertaActiva() {
        return alertaActiva;
    }

    public double getTemperaturaObjetivo() {
        return temperaturaObjetivo;
    }

    public void setTemperaturaObjetivo(double temperaturaObjetivo) {
        this.temperaturaObjetivo = temperaturaObjetivo;
    }

    @Override
    public String toString() {
        String infoAlerta = alertaActiva ? " | !!! ALERTA: " + mensajeAlerta + " !!!" : " | Sin alertas";
        return super.toString() +
                " | Temp. Objetivo: " + temperaturaObjetivo + "°C" +
                " | Modo: " + modoFuncionamiento +
                infoAlerta;
    }
}