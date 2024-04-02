package recetas;

import entidades.Ingrediente;
import entidades.Receta;
import entidades.Utensilio;

public class HuevoDuro extends Receta {
    public HuevoDuro() {
        super(10, new Ingrediente[]{new Ingrediente("Huevo", 1)},new Utensilio[]{new Utensilio("Olla",1),new Utensilio("Cucharon",1)}, "Poner el huevo en agua hirviendo durante 10 minutos");    }

}

