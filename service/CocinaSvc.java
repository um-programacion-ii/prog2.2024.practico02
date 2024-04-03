package service;

import dto.*;
import exceptions.StockInsuficienteException;
import exceptions.VidaUtilInsuficienteException;

public class CocinaSvc {

    Despensa despensa;

    public CocinaSvc(Despensa despensa) {
        this.despensa = despensa;
    }

    public String cocinar(Receta receta) throws StockInsuficienteException, VidaUtilInsuficienteException {
        if (receta.sePuedeCocinar(despensa)) {
            System.out.println("Cocinando: \n");
            System.out.println(receta.getPreparacion() + "\n");
            for (int i = 0; i < receta.getIngredientes().size(); i++) {
                if (receta.getIngredientes().get(i) != null) {
                    despensa.getDespensable(
                            receta.getIngredientes().get(i).getNombre(),
                            receta.getIngredientes().get(i).getCantidad());
                }
            }

            for (int i = 0; i < receta.getUtensilios().size(); i++) {
                if (receta.getUtensilios().get(i) != null) {
                    despensa.getDespensable(
                            receta.getUtensilios().get(i).getNombre(),
                            receta.getUtensilios().get(i).getVidaUtil());
                }
            }
            return "Se ha cocinado la receta";
        } else {
            return "No se puede cocinar la receta "
                    + receta.getClass().getSimpleName()
                    + "\n"
                    + receta.queFalta(despensa);
        }
    }

}
