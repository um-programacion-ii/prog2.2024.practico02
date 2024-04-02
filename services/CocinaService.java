package services;

import entidades.*;

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
        Ingrediente[] ingredientes = receta.getIngredientes();
        Utensilio[] utensilios = receta.getUtensilios();
        boolean suficientesIngredientes = true;
        boolean suficientesUtensilios = true;
        for(Ingrediente ingrediente : ingredientes){
            if (!despensa.contieneSuficienteIngrediente(ingrediente)) {
                suficientesIngredientes = false;
                System.out.println("No hay suficiente " + ingrediente.getNombre() + " en la despensa.");
                System.out.println("Faltan " + (ingrediente.getCantidad() - despensa.getCantidadIngrediente(ingrediente)) + " unidades.");
            }
        }
        for(Utensilio utensilio : utensilios){
            if (!despensa.contieneSuficienteUtensilio(utensilio)) {
                suficientesUtensilios = false;
                System.out.println("No hay suficientes usos de  " + utensilio.getNombre() + " en la despensa.");
                System.out.println("Faltan " + (utensilio.getUsos() - despensa.getCantidadUtensilio(utensilio)) + " usos.");
            }
        }
        if (suficientesIngredientes && suficientesUtensilios) {
            // Preparar la receta
            for (Ingrediente ingrediente : ingredientes) {
                despensa.sacarIngrediente(ingrediente);
            }
            for (Utensilio utensilio : utensilios) {
                despensa.sacarUtensilio(utensilio);
            }
            System.out.println("La Receta preparada correctamente por el Chef " + chef.getNombre());
        } else {
            System.out.println("El Chef " + chef.getNombre() + " no pudo preparar la receta debido a la falta de ingredientes.");
        }
    }
}




