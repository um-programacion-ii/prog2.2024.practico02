package recetas;

import entidades.Ingrediente;
import entidades.Receta;

public class HuevoDuro extends Receta {
    public HuevoDuro() {
        super(10, new Ingrediente[]{new Ingrediente("Huevo", 1)}, "Poner el huevo en agua hirviendo durante 10 minutos");    }

}

