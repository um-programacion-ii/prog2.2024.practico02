package recetas;

import entidades.Ingrediente;
import entidades.Receta;
import entidades.Utensilio;

public class HuevoFrito extends Receta {


    public HuevoFrito() {
        super(5, new Ingrediente[]{new Ingrediente("Huevo", 1), new Ingrediente("Aceite", 25)}, new Utensilio[]{new Utensilio("Sarten",1),new Utensilio("Espatula",1)},"Colocar el huevo en una sarten con aceite caliente durante 5 minutos");
    }
}
