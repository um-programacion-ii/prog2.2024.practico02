package entity;

import java.util.ArrayList;
import java.util.Arrays;

public class HuevoDuro extends Receta{

    public HuevoDuro() {
        super(10,
                "Poner un huevo en agua hirviendo durante 10 minutos",
                new ArrayList<Ingrediente>() {{
                    add(new Ingrediente("Huevo", 2));
                    add(new Ingrediente("Agua", 200));
                }},
                new ArrayList<Utensilio>() {{
                    add(new Utensilio("Olla", 1));
                }});
    }

}
