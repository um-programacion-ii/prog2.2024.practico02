package entity;

import entity.customExceptions.InvalidIngredientException;
import entity.customExceptions.StockInsuficienteException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Despensa {
    private Map<String, Cocinable> ingredientes;
    private Map<String, Reutilizable> utensilios;

    public Despensa() {
        this.utensilios = new HashMap<>();
        this.ingredientes = new HashMap<>();
    }

    public Despensa(Map<String, Cocinable> ingredientes, Map<String, Reutilizable> utensilios) {
        this.ingredientes = ingredientes;
        this.utensilios = utensilios;
    }

    public Map<String, Cocinable> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Map<String, Cocinable> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Map<String, Reutilizable> getUtensilios() {
        return utensilios;
    }

    public void setUtensilios(Map<String, Reutilizable> utensilios) {
        this.utensilios = utensilios;
    }

    @Override
    public String toString() {
        return "\nIngredientes en despensa:" + this.showItems(this.ingredientes)+"\nUtensilios en despensa:" + this.showItems(this.utensilios);
    }

    public String showItems(Map<String, ? extends Despensable> despensableMap) {
        return despensableMap.values().stream().map(item -> toString()).collect(Collectors.joining(", ", "\n", ""));
    }

    public void addIngrediente(Cocinable ingrediente) {
        try {
            Cocinable existingIngrediente = this.inspectIngrediente(ingrediente.getNombre());
            existingIngrediente.restock(ingrediente.getCantidad());
        } catch (InvalidIngredientException e) {
            this.ingredientes.put(ingrediente.getNombre(), ingrediente);
        }
    }

    public void getIngrediente(String name, int amount) throws StockInsuficienteException, InvalidIngredientException {
        Cocinable ingrediente = this.inspectIngrediente(name);
        ingrediente.sacar(amount);
    }

    public Cocinable inspectIngrediente(String name) throws InvalidIngredientException {
        Cocinable ingrediente = this.ingredientes.get(name.trim().toLowerCase());
        if (ingrediente != null) {
            return ingrediente;
        } else {
            throw new InvalidIngredientException("The ingredient "+name+" doesn't exist.");
        }
    }

}
