package entity;

import java.util.ArrayList;
import java.util.List;

public class Bife extends Receta {
    public Bife() {
        super(15,
                "Prepara la carne con sal y pimienta, poner aceite en la sarten y echar el bife a la sarten por 15 minutos",
                new ArrayList<Ingrediente>() {{
                    add(new Ingrediente("Carne", 1));
                    add(new Ingrediente("Sal", 20));
                    add(new Ingrediente("Pimienta", 20));
                    add(new Ingrediente("Aceite", 20));
                }},
                new ArrayList<Utensilio>() {{
                    add(new Utensilio("Cuchillo", 10));
                    add(new Utensilio("Sarten", 5));
                    add(new Utensilio("Espatula", 5));
                }});
    }
}
