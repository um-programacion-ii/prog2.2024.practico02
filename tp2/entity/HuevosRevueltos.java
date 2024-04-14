package entity;

import java.util.ArrayList;

public class HuevosRevueltos extends Receta{

    public HuevosRevueltos() {
        super(5,
                "Romper dos huevos en la sarten y batirlos hasta estar cocidos",
                new ArrayList<Ingrediente>() {{
                    add(new Ingrediente("Carne", 1));
                    add(new Ingrediente("Sal", 20));
                    add(new Ingrediente("Pimienta", 20));
                    add(new Ingrediente("Aceite", 20));
                }});
    }
}
