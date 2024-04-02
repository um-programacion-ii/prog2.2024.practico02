package entidades;

public class Receta {
    private int tiempoCoccion;
    private Ingrediente[] ingredientes;

    private Utensilio[] utensilios;

    private String preparacion;

    public Receta(int tiempoCoccion, Ingrediente[] ingredientes,Utensilio[] utensilios, String preparacion) {
        this.tiempoCoccion = tiempoCoccion;
        this.ingredientes = ingredientes;
        this.utensilios = utensilios;
        this.preparacion = preparacion;
    }

    public void mostrarReceta(){
        System.out.println("Tiempo de coccion: " + tiempoCoccion);
        System.out.println("Ingredientes: ");
        for (int i = 0; i < ingredientes.length; i++) {
            System.out.println(ingredientes[i].toString());
        }
        System.out.println("Utensilios: ");
        for (int i = 0; i < utensilios.length; i++) {
            System.out.println(utensilios[i].toString());
        }
        System.out.println("Preparacion: " + preparacion);
    }


    public Ingrediente[] getIngredientes() {
        return ingredientes;
    }

    public Utensilio[] getUtensilios() {
        return utensilios;
    }

//    public void setIngredientes(entidades.Ingrediente[] ingredientes) {
//        this.ingredientes = ingredientes;
//    }
}






