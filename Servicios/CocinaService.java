package Servicios;

import Entidades.*;
import Excepciones.StockInsuficiente;
import Excepciones.VidaUtilInsuficiente;

import java.util.List;

public class CocinaService {
    private Despensa despensa;

    public CocinaService(Despensa despensa) {
        this.despensa = despensa;
    }

    public void prepararReceta(Receta receta) throws VidaUtilInsuficiente, StockInsuficiente {

        if(DespensaService.verificar(despensa,receta)){
            System.out.println(receta.getPreparacion());

            receta.getIngredientes().stream().forEach(ingrediente -> {
                int cantidadNecesaria = ingrediente.getCantidad();
                String nombreIngrediente = ingrediente.getNombre();
                try {
                    despensa.getDespensable(nombreIngrediente, cantidadNecesaria);
                } catch (VidaUtilInsuficiente e) {
                    throw new RuntimeException(e);
                } catch (StockInsuficiente e) {
                    throw new RuntimeException(e);
                }
            });

            receta.getUtensilios().stream().forEach(utensilio -> {
                int vidaUtilNecesaria = utensilio.getVidaUtil();
                String nombreUtensilio = utensilio.getNombre();
                try {
                    despensa.getDespensable(nombreUtensilio, vidaUtilNecesaria);
                } catch (VidaUtilInsuficiente e) {
                    System.out.println("Vida útil insuficiente para el utensilio: " + nombreUtensilio);
                } catch (StockInsuficiente e) {
                    throw new RuntimeException(e);
                }
            });

            System.out.println("Cantidad de objetos restantes en la despensa:");
            System.out.println(despensa);
        }
    }
}
