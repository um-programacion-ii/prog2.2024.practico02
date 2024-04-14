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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    @Override
    public String utilizar(int cantidad_vida_util) {
        if (vidaUtil >= cantidad_vida_util) {
            vidaUtil = vidaUtil - cantidad_vida_util;
             return "Utensilio utilizado. Vida útil restante: " + vidaUtil ;
        } else {
            return "El utensilio está desgastado y necesita ser reemplazado.";
        }
    }


}
