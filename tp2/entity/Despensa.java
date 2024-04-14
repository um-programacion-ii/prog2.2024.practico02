package entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Despensa {
    private Map<String, Ingrediente> ingredientes;
    private Map<String, Utensilio> utensilios;

    public Despensa()
    {
        ingredientes = new HashMap<>();
        utensilios = new HashMap<>();
    }

    public void agregarUtensilio(String nombre, Utensilio utensilio) {
        utensilios.put(nombre, utensilio);
    }

    public String getUtensilio(String nombre, int cantidad_vida_util) {
        Utensilio utensilio = utensilios.get(nombre);
        if (utensilio != null) {
            return utensilio.utilizar(cantidad_vida_util);
        } else {
            return "El ingrediente " + nombre + " no se encuentra en la despensa";
        }
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

    public boolean dispUtensilio(String nombre, int cantidad_vida_util)
    // Retorna falso si no hay cantidad_vida_util de ingredientes suficientes, o si el ingrediente no se encuentra en la despensa
    {
        Utensilio utensilio = utensilios.get(nombre);
        if (utensilio != null) {
            return utensilio.getVidaUtil() >= cantidad_vida_util;
        }
        return false;
    }

    public void imprimirDespensa() {
        System.out.println("Contenido de la despensa:");
        ingredientes.values().forEach(ingrediente -> System.out.println(ingrediente.getNombre() + ": " + ingrediente.getCantidad()));
        utensilios.values().forEach(utensilio -> System.out.println(utensilio.getNombre() + ": " + utensilio.getVidaUtil()));
    }

}
