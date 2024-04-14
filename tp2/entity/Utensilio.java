package entity;

import interfaces.Despensable;
import interfaces.Reutilizable;

public class Utensilio implements Despensable, Reutilizable {
    private String nombre;
    private int vidaUtil;

    public Utensilio() {
    }

    public Utensilio(String nombre, int vidaUtil) {
        this.nombre = nombre;
        this.vidaUtil = vidaUtil;
    }

    @Override
    public void utilizar() {
        if (vidaUtil > 0) {
            vidaUtil--;
            System.out.println("Utensilio utilizado. Vida útil restante: " + vidaUtil);
        } else {
            System.out.println("El utensilio está desgastado y necesita ser reemplazado.");
        }
    }
}
