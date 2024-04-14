package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Receta {
    protected int tiempoCoccion;
    protected String preparacion;
    protected List<Ingrediente> ingredientes; // Cambio de arreglo a lista

    public Receta() {
        ingredientes = new ArrayList<>(); // Inicializamos la lista
    }

    public Receta(int tiempoCoccion, String preparacion, List<Ingrediente> ingredientes) {
        this.tiempoCoccion = tiempoCoccion;
        this.preparacion = preparacion;
        this.ingredientes = ingredientes;
    }

    public int getTiempoCoccion() {
        return tiempoCoccion;
    }

    public void setTiempoCoccion(int tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "Receta: [Tiempo de coccion: " + tiempoCoccion + ", Ingredientes: " + Arrays.toString(new List[]{ingredientes}) + ", Preparacion: " + preparacion + "]";
    }


}
