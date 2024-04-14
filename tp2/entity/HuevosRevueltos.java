package entity;

import java.util.ArrayList;

public class HuevosRevueltos extends Receta{

    public HuevosRevueltos() {
        super(5,
                "Romper dos huevos en la sarten con aceite y batirlos hasta estar cocidos",
                new ArrayList<Ingrediente>() {{
                    add(new Ingrediente("Huevo",2));
                    add(new Ingrediente("Aceite", 20));
                }},
                new ArrayList<Utensilio>() {{
                    add(new Utensilio("Sarten", 2));
                    add(new Utensilio("Espatula", 1));
                }});
    }
}
