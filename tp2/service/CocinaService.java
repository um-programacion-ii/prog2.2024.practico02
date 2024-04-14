package service;

import entity.Despensa;
import entity.Ingrediente;
import entity.Receta;
import entity.Utensilio;

public class CocinaService {
    // El chef utilizará CocinaService para preparar una receta
    Despensa despensa;
    public CocinaService(Despensa despensa) {
        this.despensa = despensa;
    }


//    Cocinar
    public String cocinar(Receta receta)
    {
        if(receta.check_ingredients(despensa))
        {
            System.out.println(receta.getPreparacion());
            for(Ingrediente ingrediente_cocinar : receta.getIngredientes())
            {
                despensa.getIngrediente(ingrediente_cocinar.getNombre(),ingrediente_cocinar.getCantidad());
                Ingrediente ingrediente_despensa = despensa.getIngrediente2(ingrediente_cocinar.getNombre());
                System.out.println("Restante en despensa: " + ingrediente_despensa.getCantidad() + " " + ingrediente_despensa.getNombre());
            }

            for(Utensilio utensilio_utilizado : receta.getUtensilios())
            {
                despensa.getUtensilio(utensilio_utilizado.getNombre(),utensilio_utilizado.getVidaUtil());
            }

            return "Se realizo la receta correctamente";
        }
        else{
            receta.ingredientes_faltantes(despensa);
            return "No se pudo realizar la receta";
        }
    }






}
