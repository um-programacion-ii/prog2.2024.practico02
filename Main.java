import entidades.Chef;
import entidades.Despensa;
import entidades.Ingrediente;
import recetas.HuevoDuro;
import recetas.HuevoFrito;
import recetas.Torta;
import services.CocinaService;

public class Main {
    public static void main(String[] args) {

        System.out.println("----------------------- Ejercicio 1 -----------------------");

        System.out.println(" ");
        Ingrediente ingrediente1 = new Ingrediente("Azucar", 100);
//        System.out.println(ingrediente1.toString());

        Ingrediente ingrediente2 = new Ingrediente();
        ingrediente2.setNombre("Sal");
        ingrediente2.setCantidad(200);
//        System.out.println(ingrediente2.toString());



        System.out.println(" ");

        System.out.println("----------------------- Ejercicio 2 -----------------------");

        System.out.println(" ");

        ingrediente2.sacarIngrediente(300);
        Ingrediente harina = new Ingrediente("Harina", 200);
        Ingrediente polvoHornear = new Ingrediente("Polvo de hornear", 100);
        Ingrediente leche = new Ingrediente("Leche", 300);
        Ingrediente huevo = new Ingrediente("Huevo", 10);
        Ingrediente aceite = new Ingrediente("Aceite", 50);

        Despensa despensa = new Despensa(new Ingrediente[10]);
        despensa.addIngrediente(ingrediente1);
        despensa.addIngrediente(ingrediente2);
        despensa.addIngrediente(harina);
        despensa.addIngrediente(polvoHornear);
        despensa.addIngrediente(leche);
        despensa.addIngrediente(huevo);
        despensa.addIngrediente(aceite);

        despensa.mostrarIngredientes();

        despensa.getIngrediente("Azucar", 25);

        despensa.mostrarIngredientes();

        System.out.println(" ");
        System.out.println("----------------------- Ejercicio 3 -----------------------");
        System.out.println(" ");

        HuevoFrito huevoFrito = new HuevoFrito();
        huevoFrito.mostrarReceta();

        HuevoDuro huevoDuro = new HuevoDuro();
        huevoDuro.mostrarReceta();

        Torta torta = new Torta();
        torta.mostrarReceta();
        System.out.println(" ");
        System.out.println("----------------------- Ejercicio 4 -----------------------");
        System.out.println(" ");

        Chef chef = new Chef ("Linguini",3);
        CocinaService cocinaService = new CocinaService(chef, despensa);

        System.out.println("Preparando huevo frito");
        cocinaService.prepararPlatos(huevoFrito);
        System.out.println(" ");

        System.out.println("Preparando huevo duro");
        cocinaService.prepararPlatos(huevoDuro);
        System.out.println(" ");
        System.out.println("Preparando torta");
        cocinaService.prepararPlatos(torta);


        despensa.mostrarIngredientes();






    }












    }

