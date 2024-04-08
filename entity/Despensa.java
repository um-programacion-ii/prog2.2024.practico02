package entity;

import entity.customExceptions.InvalidIngredientException;
import entity.customExceptions.NotEnoughStockException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Despensa {
    private Map<String, Ingrediente> ingredientes;
    private Map<String, Ingrediente> utensilios;

    public Despensa() {
        this.utensilios = new HashMap<>();
        this.ingredientes = new HashMap<>();
    }

    public Despensa(Map<String, Ingrediente> ingredientes, Map<String, Ingrediente> utensilios) {
        this.ingredientes = ingredientes;
        this.utensilios = utensilios;
    }

    public Map<String, Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Map<String, Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Map<String, Ingrediente> getUtensilios() {
        return utensilios;
    }

    public void setUtensilios(Map<String, Ingrediente> utensilios) {
        this.utensilios = utensilios;
    }

    @Override
    public String toString() {
        return "\nIngredientes en despensa:" + this.showItems(this.ingredientes)+"\nUtensilios en despensa:" + this.showItems(this.utensilios);
    }

    private StringBuilder showItems(Map<String, Despensable> despensableMap) {
        StringBuilder ingredientes = new StringBuilder();
        Iterator<Map.Entry<String, Ingrediente>> iterator = this.ingredientes.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Ingrediente> entry = iterator.next();
            if (iterator.hasNext()) {
                ingredientes.append("\n").append(entry.getValue()).append(", ");
            } else {
                ingredientes.append("\n").append(entry.getValue());
            }
        }
        return ingredientes;
    }

    public void addIngrediente(Ingrediente ingrediente) {
        try {
            Ingrediente ingredienteDisp = this.inspectIngrediente(ingrediente.getNombre());
            ingredienteDisp.setCantidad(ingredienteDisp.getCantidad()+ingrediente.getCantidad());
        } catch (InvalidIngredientException e) {
            Ingrediente[] newIngredientes = new Ingrediente[this.ingredientes.size() + 1];
            System.arraycopy(this.ingredientes, 0, newIngredientes, 0, this.ingredientes.size());
            newIngredientes[this.ingredientes.size()] = ingrediente;
            this.ingredientes = newIngredientes;
        }
    }

    public String getIngrediente(String name, int amount) throws NotEnoughStockException, InvalidIngredientException {
        for (Ingrediente ingrediente : ingredientes) {
            if (ingrediente.getNombre().trim().equalsIgnoreCase(name.trim())) {
                return ingrediente.sacar(amount);
            }
        }
        throw new InvalidIngredientException("The ingredient doesn't exist.");
    }

    public Ingrediente inspectIngrediente(String name) throws InvalidIngredientException {
        for (Ingrediente ingrediente : ingredientes) {
            if (ingrediente.getNombre().trim().equalsIgnoreCase(name.trim())) {
                return ingrediente;
            }
        }
        throw new InvalidIngredientException("The ingredient "+name+" doesn't exist.");
    }

}
