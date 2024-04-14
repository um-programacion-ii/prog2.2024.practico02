package service;

import entity.Despensa;
import entity.Ingrediente;
import entity.Receta;
import entity.Utensilio;
import excepciones.StockInsuficiente;
import excepciones.VidaUtilInsuficiente;

public class DespensaService {

    Despensa despensa;

    public DespensaService() {
    }

    public DespensaService(Despensa despensa) {
        this.despensa = despensa;
    }

    public boolean check_ingredients (Despensa despensa, Receta receta) throws VidaUtilInsuficiente, StockInsuficiente {
        // Checkeo si falta algun ingrediente, con que falte solo uno ya dara false
        for(Ingrediente ingrediente_necesario : receta.getIngredientes())
        {
            if (!despensa.dispIngrediente(ingrediente_necesario.getNombre(), ingrediente_necesario.getCantidad()))
            {
                throw new StockInsuficiente("Falta stock del o no se encuentra en la despensa --> " + ingrediente_necesario.getNombre());
            }
        }
        for(Utensilio utensilio_necesario : receta.getUtensilios())
        {
            if (!despensa.dispUtensilio(utensilio_necesario.getNombre(), utensilio_necesario.getVidaUtil()))
            {
                throw new VidaUtilInsuficiente("No le queda vida útil o no se encuentra en la despensa --> " + utensilio_necesario.getNombre());
            }
        }
        return true;
    }

    public void reset_utensilio(Utensilio utensilio)
    {
        utensilio.setVidaUtil(1000);
    }
}
