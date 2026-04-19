package examen;

public class Luz extends Dispositivo implements IConfigurable {
    private String color;
    private int brillo;
    private final int BRILLO_PREDETERMINADO = 50;
    private final int MIN_BRILLO = 0;
    private final int MAX_BRILLO = 100;
    private final int INCREMENTO = 10;

    public Luz(String nombre, String marca, double precio, String color) {
        super(nombre, marca, precio);
        this.color = color;
        this.brillo = BRILLO_PREDETERMINADO;
    }

    @Override
    public void subir() throws DispositivoApagadoException {
        if (!isEncendido()) throw new DispositivoApagadoException();

        brillo += INCREMENTO;
        if (brillo > MAX_BRILLO) brillo = MAX_BRILLO;
    }

    @Override
    public void bajar() throws DispositivoApagadoException {
        if (!isEncendido()) throw new DispositivoApagadoException();

        brillo -= INCREMENTO;
        if (brillo < MIN_BRILLO) brillo = MIN_BRILLO;
    }

    @Override
    public String toString() {
        return super.toString() + " | Color: " + color + " | Brillo: " + brillo + "%";
    }
}