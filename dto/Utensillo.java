package dto;

import exceptions.VidaUtilInsuficienteException;

public class Utensillo  implements Reutilizable, Despensable {
    private int vidaUtil;
    private String nombre;

    public Utensillo() {}

    public Utensillo(String nombre, int vidaUtil) {
        this.nombre = nombre;
        this.vidaUtil = vidaUtil;
    }

    @Override
    public String sacar(int cantidad) throws VidaUtilInsuficienteException {
        if (vidaUtil >= cantidad) {
            vidaUtil -= cantidad;
            return "Se han sacado " + cantidad + " usos";
        } else {
            throw new VidaUtilInsuficienteException("No hay suficientes usos, faltan " + (cantidad - vidaUtil) + " usos");
        }
    }

    @Override
    public int getVidaUtil() {
        return vidaUtil;
    }

    @Override
    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Vida util: " + vidaUtil;
    }

    public String getNombre() {
        return nombre;
    }
}
