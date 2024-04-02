package entidades;

import interfaces.Cocinable;
import interfaces.Despensable;

public class Despensa implements Cocinable {
    private Ingrediente[] ingredientes;

    private Utensilio[] utensilios;


    private int cantidadIngredientes;
    private  int cantidadUtensilios;


    public Despensa(Ingrediente[] ingredientes, Utensilio[] utensilios) {
        this.ingredientes = ingredientes;
        this.utensilios = utensilios;
    }
    public void addIngrediente(Ingrediente ingrediente){
        ingredientes[cantidadIngredientes] = ingrediente;
        cantidadIngredientes++;
    }

    public void addUtensilio(Utensilio utensilio){
        utensilios[cantidadIngredientes] = utensilio;
        cantidadUtensilios++;
    }

    public void mostrarIngredientes(){
        for (int i = 0; i < cantidadIngredientes; i++) {
            System.out.println(ingredientes[i].toString());
        }
    }
    public void mostrarUtensilios(){
        for (int i = 0; i < cantidadUtensilios; i++) {
            System.out.println(utensilios[i].toString());
        }
    }

    public void getIngrediente(String nombre, int cantidad){
        for (int i = 0; i < cantidadIngredientes; i++) {
            if (ingredientes[i].getNombre().equals(nombre)){
                ingredientes[i].sacar(cantidad);
            }
        }
    }

    public void getUtensilio(String nombre, int cantidad){
        for (int i = 0; i < cantidadUtensilios; i++) {
            if (utensilios[i].getNombre().equals(nombre)){
                utensilios[i].sacar(cantidad);
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

    public boolean contieneSuficienteUtensilio(Utensilio utensilio) {
        for (Utensilio despensaUtensilio : utensilios) {
            if (despensaUtensilio != null && despensaUtensilio.getNombre().equals(utensilio.getNombre()) && despensaUtensilio.getUsos() >= utensilio.getUsos()) {
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

    public int getCantidadUtensilio(Utensilio utensilio) {
        for (Utensilio despensaUtensilio : utensilios) {
            if (despensaUtensilio != null && despensaUtensilio.getNombre().equals(utensilio.getNombre())) {
                return despensaUtensilio.getUsos();
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

    public void sacarUtensilio(Utensilio utensilio) {
        for (int i = 0; i < utensilios.length; i++) {
            if (utensilios[i] != null && utensilios[i].getNombre().equals(utensilio.getNombre())) {
                if (utensilios[i].getUsos() >= utensilio.getUsos()) {
                    utensilios[i].setUsos(utensilios[i].getUsos() - utensilio.getUsos());
                    System.out.println("La/El  " + utensilio.getNombre() + " diminuyó su uso " + utensilio.getUsos() + " vez/veces.");
                    return;
                } else {
                    System.out.println("No hay suficientes usos de " + utensilio.getNombre() + " en la despensa.");
                    System.out.println("Faltan " + (utensilio.getUsos() - utensilios[i].getUsos()) + " usos.");
                    return;
                }
            }
        }
        System.out.println("No se encontró " + utensilio.getNombre() + " en la despensa.");
    }








}
