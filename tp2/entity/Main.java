package entity;

import service.CocinaService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Despensa despensa = new Despensa();

        Ingrediente agua = new Ingrediente("Agua", 200);
        Ingrediente huevo = new Ingrediente("Huevo", 2);
        Ingrediente carne = new Ingrediente("Carne", 1);
        Ingrediente sal = new Ingrediente("Sal", 1);
        Ingrediente pimienta = new Ingrediente("Pimienta", 20);
        Ingrediente aceite = new Ingrediente("Aceite", 20);

        despensa.agregarIngrediente("Agua", agua);
        despensa.agregarIngrediente("Huevo", huevo);
        despensa.agregarIngrediente("Carne", carne);
        despensa.agregarIngrediente("Sal", sal);
        despensa.agregarIngrediente("Pimienta", pimienta);
        despensa.agregarIngrediente("Aceite", aceite);

        Receta bife = new Bife();
        Receta huevoduro = new HuevoDuro();

        // Preparacion de Receta exitosa
        System.out.println("++++++++++++++ Preparacion de receta exitosa ++++++++++++++\n");
        CocinaService cocina = new CocinaService(despensa);
        System.out.println(cocina.cocinar(huevoduro));
        despensa.imprimirDespensa();
        System.out.println("\n");

        // Faltan todos los ingredientes
        System.out.println("++++++++++++++ Faltan todos los ingredientes ++++++++++++++\n");
        System.out.println(cocina.cocinar(huevoduro));
        despensa.imprimirDespensa();
        System.out.println("\n");

        // Falta un ingrediente
        System.out.println("++++++++++++++ Falta 1 ingrediente ++++++++++++++\n");
        System.out.println(cocina.cocinar(bife));
        System.out.println("\n");







    }
}