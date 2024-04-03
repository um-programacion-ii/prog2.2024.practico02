package dto;

import exceptions.StockInsuficienteException;
import exceptions.VidaUtilInsuficienteException;
import service.CocinaSvc;

public class Chef {

    String nombre;

    int estrellasMichelin;

    public Chef() {}
    public Chef(String nombre, int estrellasMichelin) {
        this.nombre = nombre;
        this.estrellasMichelin = estrellasMichelin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstrellasMichelin() {
        return estrellasMichelin;
    }

    public void setEstrellasMichelin(int estrellasMichelin) {
        this.estrellasMichelin = estrellasMichelin;
    }

    public String cocinar(CocinaSvc cocina, Receta receta) throws VidaUtilInsuficienteException, StockInsuficienteException {
        System.out.println("Hola soy " + this);
        return cocina.cocinar(receta);
    }

    @Override
    public String toString() {
        return "Chef: " + nombre + ", Estrellas Michelin: " + estrellasMichelin;
    }
}
