package entidades;

public class Despensa {
    private Ingrediente[] ingredientes;

    private int cantidadIngredientes;


    public Despensa(Ingrediente[] ingredientes) {
        this.ingredientes = ingredientes;
    }
    public void addIngrediente(Ingrediente ingrediente){
        ingredientes[cantidadIngredientes] = ingrediente;
        cantidadIngredientes++;
    }

    public void mostrarIngredientes(){
        for (int i = 0; i < cantidadIngredientes; i++) {
            System.out.println(ingredientes[i].toString());
        }
    }

    public void getIngrediente(String nombre, int cantidad){
        for (int i = 0; i < cantidadIngredientes; i++) {
            if (ingredientes[i].getNombre().equals(nombre)){
                ingredientes[i].sacarIngrediente(cantidad);
            }
        }
    }

    public boolean contieneSuficienteIngrediente(Ingrediente ingrediente) {
        for (Ingrediente despensaIngrediente : ingredientes) {
            if (despensaIngrediente != null && despensaIngrediente.getNombre().equals(ingrediente.getNombre()) && despensaIngrediente.getCantidad() >= ingrediente.getCantidad()) {
                return true;
            }
        }
        return false;
    }

    public int getCantidadIngrediente(Ingrediente ingrediente) {
        for (Ingrediente despensaIngrediente : ingredientes) {
            if (despensaIngrediente != null && despensaIngrediente.getNombre().equals(ingrediente.getNombre())) {
                return despensaIngrediente.getCantidad();
            }
        }
        return 0;
    }
    public void sacarIngrediente(Ingrediente ingrediente) {
        for (int i = 0; i < ingredientes.length; i++) {
            if (ingredientes[i] != null && ingredientes[i].getNombre().equals(ingrediente.getNombre())) {
                if (ingredientes[i].getCantidad() >= ingrediente.getCantidad()) {
                    ingredientes[i].setCantidad(ingredientes[i].getCantidad() - ingrediente.getCantidad());
                    System.out.println("Se sacaron " + ingrediente.getCantidad() + " unidades de " + ingrediente.getNombre() + " de la despensa.");
                    return;
                } else {
                    System.out.println("No hay suficiente " + ingrediente.getNombre() + " en la despensa.");
                    System.out.println("Faltan " + (ingrediente.getCantidad() - ingredientes[i].getCantidad()) + " unidades.");
                    return;
                }
            }
        }
        System.out.println("No se encontró " + ingrediente.getNombre() + " en la despensa.");
    }








}
