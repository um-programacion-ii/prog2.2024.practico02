package entidades;

import interfaces.Despensable;
import interfaces.Reutilizable;

public class Utensilio implements Despensable, Reutilizable {

    private String nombre;
    private int vidaUtil;

    public Utensilio(String nombre, int vidaUtil) {
        this.nombre = nombre;
        this.vidaUtil = vidaUtil;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public int getCantidadDisponible() {
        return vidaUtil;
    }
    @Override
    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public String toString(){
        return("Utensilio: " + nombre + " con " + vidaUtil + " usos");
    }

    @Override
    public void sacar(int cantidad) {
        if (this.vidaUtil >= cantidad){
            this.vidaUtil -= cantidad;
        }else{
            System.out.println("No hay suficientes usos");
            System.out.println("Faltan " + (cantidad - this.vidaUtil) + " usos de " + this.nombre);
        }
    }


}
