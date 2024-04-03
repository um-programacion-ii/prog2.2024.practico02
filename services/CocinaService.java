package services;

import entidades.*;
import interfaces.Despensable;

public class CocinaService {

    private Chef chef;
    private Despensa despensa;

    public CocinaService() {
    }
    public CocinaService(Chef chef, Despensa despensa) {
        this.chef = chef;
        this.despensa = despensa;
    }

    public void prepararPlatos(Receta receta) {

        if (verificarDisponibilidad(receta)) {
            // Sacar los ingredientes y utensilios de la despensa
            for (Despensable ingrediente : receta.getIngredientes()) {
                despensa.sacar(ingrediente.getNombre(), ingrediente.getCantidadDisponible());
            }
            for (Despensable utensilio : receta.getUtensilios()) {
                despensa.sacar(utensilio.getNombre(), utensilio.getCantidadDisponible());
            }
            // Preparar la receta
            System.out.println("El Chef " + chef.getNombre() + " ha preparado exitosamente la receta: " + receta.getClass().getSimpleName());
        } else {
            System.out.println("No hay suficientes ingredientes o utensilios en la despensa para preparar la receta: " + receta.getClass().getSimpleName());
        }
    }

    private boolean verificarDisponibilidad(Receta receta) {
        // Verificar si hay suficientes ingredientes y utensilios en la despensa
        for (Despensable ingrediente : receta.getIngredientes()) {
            if (!despensa.contieneSuficienteDespensable(ingrediente)) {
                return false;
            }
        }
        for (Despensable utensilio : receta.getUtensilios()) {
            if (!despensa.contieneSuficienteDespensable(utensilio)) {
                return false;
            }
        }
        return true;
    }

//    public void prepararPlatos(Receta receta){
//        Ingrediente[] ingredientes = receta.getIngredientes();
//        Utensilio[] utensilios = receta.getUtensilios();
//        boolean suficientesIngredientes = true;
//        boolean suficientesUtensilios = true;
//        for(Ingrediente ingrediente : ingredientes){
//            if (!despensa.contieneSuficienteIngrediente(ingrediente)) {
//                suficientesIngredientes = false;
//                System.out.println("No hay suficiente " + ingrediente.getNombre() + " en la despensa.");
//                System.out.println("Faltan " + (ingrediente.getCantidad() - despensa.getCantidadIngrediente(ingrediente)) + " unidades.");
//            }
//        }
//        for(Utensilio utensilio : utensilios){
//            if (!despensa.contieneSuficienteUtensilio(utensilio)) {
//                suficientesUtensilios = false;
//                System.out.println("No hay suficientes usos de  " + utensilio.getNombre() + " en la despensa.");
//                System.out.println("Faltan " + (utensilio.getUsos() - despensa.getCantidadUtensilio(utensilio)) + " usos.");
//            }
//        }
//        if (suficientesIngredientes && suficientesUtensilios) {
//            // Preparar la receta
//            for (Ingrediente ingrediente : ingredientes) {
//                despensa.sacarIngrediente(ingrediente);
//            }
//            for (Utensilio utensilio : utensilios) {
//                despensa.sacarUtensilio(utensilio);
//            }
//            System.out.println("La Receta preparada correctamente por el Chef " + chef.getNombre());
//        } else {
//            System.out.println("El Chef " + chef.getNombre() + " no pudo preparar la receta debido a la falta de ingredientes.");
//        }
//    }
}




