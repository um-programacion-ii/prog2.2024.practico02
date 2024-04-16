package service;

import entity.*;
import entity.customExceptions.ObjectAlreadyExistsException;
import entity.recetas.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main (String[] args) {
        // ################ TP 2 PUNTO 2 ################
        System.out.print("\u001B[31m");
        System.out.println("\nTP2 Punto2:\n");
        System.out.print("\u001B[0m");
        Chef chef = new Chef("Fernando", 2);
        Despensa despensa = new Despensa();
        DespensaService despensaService = new DespensaService(despensa);
        CocinaService cocinaService = new CocinaService();
        cocinaService.setDespensaService(despensaService);
        Map<String, Receta> recetas = new HashMap<>() {{
            put("ensalada", new Ensalada());
            put("fideos", new Fideos());
            put("huevoDuro", new HuevoDuro());
            put("pizza", new Pizza());
        }};
        cocinaService.setRecetas(recetas);
        for (Receta receta: cocinaService.getRecetas().values()) {
            for (Cocinable cocinable: receta.getIngredientes().values()) {
                despensa.addIngrediente(cocinable);
            }
            for (Reutilizable reutilizable: receta.getUtensilios().values()) {
                try {
                    despensa.addUtensilio(reutilizable);
                } catch (ObjectAlreadyExistsException e) {
                    despensa.inspectUtensilio(reutilizable.getNombre())
                }
            }
        }
        CocinaService cocinaService = new CocinaService(despensa, new Receta[]{ensalada, fideos, huevoDuro, pizza});
        System.out.println("El chef "+ chef + " va a preparar tres de las siguientes recetas:");
        System.out.println(cocinaService.showRecetas());
        try {
            Integer[] recetasArray = {2,4,1,4};
            for (Integer receta: recetasArray) {
                System.out.println("\nPreparación receta "+receta+":  ");
                System.out.println(cocinaService.makeReceta(receta));
                System.out.println(cocinaService.getDespensa());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}