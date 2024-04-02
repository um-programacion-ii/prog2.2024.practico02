package recetas;

import entidades.Ingrediente;
import entidades.Receta;
import entidades.Utensilio;

public class Torta extends Receta {
    public Torta() {
        super(30, new Ingrediente[]{new Ingrediente("Huevo", 3), new Ingrediente("Harina", 100), new Ingrediente("Azucar", 100), new Ingrediente("Leche", 100), new Ingrediente("Aceite", 50), new Ingrediente("Polvo de hornear", 25)}, new Utensilio[]{new Utensilio("Bowl",1), new Utensilio("Batidora",1),new Utensilio("Horno",1)},"Mezclar los ingredientes, empezamos por mezclar los liquidos y luego ingresamos los secos, tamizados previamente. Y hornear durante 30 minutos");
    }
}
