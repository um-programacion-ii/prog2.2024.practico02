package entidades;

import interfaces.Despensable;

public class Utensilio implements Despensable {

    private String nombre;
    private int usos;

    public Utensilio(String nombre, int usos) {
        this.nombre = nombre;
        this.usos = usos;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUsos() {
        return usos;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    public String toString(){
        return("Utensilio: " + nombre + " con " + usos + " usos");
    }

    @Override
    public void sacar(int cantidad) {
        if (this.usos >= cantidad){
            this.usos -= cantidad;
        }else{
            System.out.println("No hay suficientes usos");
            System.out.println("Faltan " + (cantidad - this.usos) + " usos de " + this.nombre);
        }
    }


}
