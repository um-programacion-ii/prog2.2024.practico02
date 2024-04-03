package services;

import entidades.*;
import excepciones.StockInsuficienteException;
import interfaces.Despensable;
import excepciones.VidaUtilInsuficienteException;

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


    public String prepararPlatos(Receta receta) throws StockInsuficienteException, VidaUtilInsuficienteException {
        List<Despensable> ingredientes = receta.getIngredientes();
        List<Despensable> utensilios = receta.getUtensilios();
        boolean sePuedePreparar = true;
        for (Despensable ingrediente : ingredientes) {
            if (!despensa.contieneSuficienteDespensable(ingrediente)) {
                sePuedePreparar = false;
            }
        }
        for (Despensable utensilio : utensilios) {
            if (!despensa.contieneSuficienteDespensable(utensilio)) {
                sePuedePreparar = false;
            }
        }

            for (Despensable ingrediente : ingredientes) {
                despensa.sacar(ingrediente.getNombre(), ingrediente.getCantidadDisponible());

            }

            for (Despensable utensilio : utensilios) {
                despensa.sacar(utensilio.getNombre(), utensilio.getCantidadDisponible());
                       }

        if (sePuedePreparar) {
            return "El Chef " + chef.getNombre() + " ha preparado exitosamente la receta: " + receta.getClass().getSimpleName();
        } else {
            return "No se pudo preparar la receta: " + receta.getClass().getSimpleName();
        }


    }
}
















