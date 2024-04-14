package entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Despensa {
    private Map<String, Ingrediente> ingredientes;

    public Despensa()
    {
        ingredientes = new HashMap<>();
    }

    public void agregarIngrediente(String nombre, Ingrediente ingrediente) {
       ingredientes.put(nombre, ingrediente);
    }


    // Usar sacar ingrediente, arreglar
    public String getIngrediente(String nombre, int cantidad) {
        Ingrediente ingrediente = ingredientes.get(nombre);
        if (ingrediente != null) {
            return ingrediente.sacar(cantidad);
        } else {
            return "El ingrediente " + nombre + " no se encuentra en la despensa";
        }
    }

    public Ingrediente getIngrediente2(String nombre) {
        return ingredientes.get(nombre);
    }

    public boolean dispIngrediente(String nombre, int cantidad)
    // Retorna falso si no hay cantidad de ingredientes suficientes, o si el ingrediente no se encuentra en la despensa
    {
        Ingrediente ingrediente = ingredientes.get(nombre);
        if (ingrediente != null) {
            return ingrediente.getCantidad() >= cantidad;
        }
        return false;
    }

    public void imprimirDespensa() {
        System.out.println("Contenido de la despensa:");
        for (Ingrediente ingrediente : ingredientes.values()) {
            System.out.println(ingrediente.getNombre() + ": " + ingrediente.getCantidad());
        }
    }

}
