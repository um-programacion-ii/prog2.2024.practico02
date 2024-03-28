package recetas;

import entidades.Ingrediente;
import entidades.Receta;

public class HuevoFrito extends Receta {


    public HuevoFrito() {
        super(5, new Ingrediente[]{new Ingrediente("Huevo", 1), new Ingrediente("Aceite", 25)}, "Colocar el huevo en una sarten con aceite caliente durante 5 minutos");
    }
}
