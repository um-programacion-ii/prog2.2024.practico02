package services;

import entidades.*;
import interfaces.Despensable;

import java.util.ArrayList;
import java.util.List;

public class CocinaService {

    private Chef chef;
    private Despensa despensa;

    public CocinaService() {
    }
    public CocinaService(Chef chef, Despensa despensa) {
        this.chef = chef;
        this.despensa = despensa;
    }

public void prepararPlatos(Receta receta){
    List<Despensable> ingredientes = receta.getIngredientes();
    List<Despensable> utensilios = receta.getUtensilios();
    boolean suficientesIngredientes = true;
    boolean suficientesUtensilios = true;

    List<Despensable> faltantesIngredientes = new ArrayList<>();
    List<Despensable> faltantesUtensilios = new ArrayList<>();

    for(Despensable ingrediente : ingredientes){
        if (!despensa.contieneSuficienteDespensable(ingrediente)) {
            suficientesIngredientes = false;
            faltantesIngredientes.add(ingrediente);
        }
    }
    for(Despensable utensilio : utensilios){
        if (!despensa.contieneSuficienteDespensable(utensilio)) {
            suficientesUtensilios = false;
            faltantesUtensilios.add(utensilio);
        }
    }

    if (suficientesIngredientes && suficientesUtensilios) {
        // Preparar la receta
        for (Despensable ingrediente : ingredientes) {
            despensa.sacar(ingrediente.getNombre(), ingrediente.getCantidadDisponible());
        }
        for (Despensable utensilio : utensilios) {
            despensa.sacar(utensilio.getNombre(), utensilio.getCantidadDisponible());
        }
        System.out.println("El Chef " + chef.getNombre() + " ha preparado exitosamente la receta: " + receta.getClass().getSimpleName());
    } else {
        System.out.println("No hay suficientes ingredientes o utensilios en la despensa para preparar la receta: " + receta.getClass().getSimpleName());
        if (!faltantesIngredientes.isEmpty()) {
            System.out.println("Ingredientes faltantes:");
            for (Despensable ingrediente : faltantesIngredientes) {
                int cantidadFaltante = ingrediente.getCantidadDisponible() - despensa.getCantidadDisponible(ingrediente.getNombre());
                System.out.println("- " + ingrediente.getNombre() + ": faltan " + cantidadFaltante);
            }
        }
        if (!faltantesUtensilios.isEmpty()) {
            System.out.println("Utensilios faltantes:");
            for (Despensable utensilio : faltantesUtensilios) {
                int cantidadFaltante = utensilio.getCantidadDisponible() - despensa.getCantidadDisponible(utensilio.getNombre());
                System.out.println("- " + utensilio.getNombre());
            }
        }
    }
}

}




