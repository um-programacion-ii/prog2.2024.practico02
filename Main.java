import Entidades.Chef;
import Entidades.Despensa;
import Entidades.Ingrediente;
import Entidades.Utensilio;
import Excepciones.StockInsuficiente;
import Excepciones.VidaUtilInsuficiente;
import Recetas.HuevoDuro;
import Recetas.HuevosRevueltos;
import Servicios.CocinaService;

public class Main {
    public static void main(String[] args) throws StockInsuficiente, VidaUtilInsuficiente {

        Ingrediente Huevo = new Ingrediente("Huevo", 4);
        Ingrediente Aceite = new Ingrediente("Aceite", 2);
        Ingrediente Agua = new Ingrediente("Agua", 2);
        Utensilio Olla = new Utensilio("Olla", 3);

        Despensa despensa = new Despensa();
        despensa.addDespensable("Huevo",Huevo);
        despensa.addDespensable("Aceite",Aceite);
        despensa.addDespensable("Agua",Agua);
        despensa.addDespensable("Olla", Olla);

        Chef chef = new Chef("Juan", 1);

        CocinaService cocinaService = new CocinaService(despensa);

        HuevoDuro huevoDuro = new HuevoDuro();

        System.out.println("\nEscenario 1: Ingredientes suficientes");
        chef.cocinar(cocinaService, huevoDuro);

        HuevosRevueltos huevosRevueltos = new HuevosRevueltos();

        System.out.println("\nEscenario 2: Ingredientes insuficientes");
        chef.cocinar(cocinaService, huevosRevueltos);

    }
}

