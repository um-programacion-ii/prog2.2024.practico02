package entity;

import interfaces.Cocinable;

public class Ingrediente implements Cocinable {
    private String nombre;
    private int cantidad;

    public Ingrediente() {

    }
    public Ingrediente(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Ingrediente: [Nombre: " + nombre + ", Cantidad: " + cantidad + "]";
    }

    public String sacar(int cantidadSolicitada) {
        if (cantidad >= cantidadSolicitada) {
            cantidad -= cantidadSolicitada;
            return "Se saco la cantidad de " + cantidadSolicitada + " " + nombre;
        } else {
            return "No hay suficiente cantidad de " + nombre + " para sacar. Necesitas " + (cantidadSolicitada-cantidad) + " " + nombre + " más";
        }
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando " + nombre );
    }
}
