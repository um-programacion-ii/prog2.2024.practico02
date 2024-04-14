package entity;

import java.util.ArrayList;
import java.util.List;

public class Bife extends Receta {
    public Bife() {
        super(15,
                "Colocarle sal y pimienta al bife, tirar aceite en la sarten y colocar el bife en la misma",
                inicializarIngredientes());
    }

    private static List<Ingrediente> inicializarIngredientes() {
        List<Ingrediente> ingredientes = new ArrayList<>();
        ingredientes.add(new Ingrediente("Carne", 1));
        ingredientes.add(new Ingrediente("Sal", 20));
        ingredientes.add(new Ingrediente("Pimienta", 20));
        ingredientes.add(new Ingrediente("Aceite", 20));
        return ingredientes;
    }
}
