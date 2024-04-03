package entidades;

import interfaces.Cocinable;
import interfaces.Despensable;

public class Ingrediente implements Despensable{
    private String nombre;
    private int cantidad;

public Ingrediente(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    public Ingrediente() {
    }


    @Override
    public String toString() {
        return "Ingrediente{" + "nombre=" + nombre + ", cantidad=" + cantidad + '}';
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
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public void sacar(int cantidad){
    if (this.cantidad >= cantidad){
        this.cantidad -= cantidad;
    }else{
        System.out.println("No hay suficiente ingrediente");
        System.out.println("Faltan " + (cantidad - this.cantidad) + " unidades de " + this.nombre);
    }
    }

}
