package entity;

import entity.customExceptions.InvalidIngredientException;
import entity.customExceptions.NotEnoughStockException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class Despensa {
    private Map<String, Despensable> ingredientes;
    private Map<String, Despensable> utensilios;

    public Despensa() {
        this.utensilios = new HashMap<>();
        this.ingredientes = new HashMap<>();
    }

    public Despensa(Map<String, Despensable> ingredientes, Map<String, Despensable> utensilios) {
        this.ingredientes = ingredientes;
        this.utensilios = utensilios;
    }

    public Map<String, Despensable> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Map<String, Despensable> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Map<String, Despensable> getUtensilios() {
        return utensilios;
    }

    public void setUtensilios(Map<String, Despensable> utensilios) {
        this.utensilios = utensilios;
    }

    @Override
    public String toString() {
        return "\nIngredientes en despensa:" + this.showItems(this.ingredientes)+"\nUtensilios en despensa:" + this.showItems(this.utensilios);
    }

    private StringBuilder showItems(Map<String, Despensable> despensableMap) {
        //ingredientesStr = despensableMap.values().stream().map(Object -> "\n"+Object+", ").forEach(item -> {});
        StringBuilder despensables = new StringBuilder();
        Iterator<Map.Entry<String, Despensable>> iterator = this.despensables.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Despensable> entry = iterator.next();
            if (iterator.hasNext()) {
                despensables.append("\n").append(entry.getValue()).append(", ");
            } else {
                despensables.append("\n").append(entry.getValue());
            }
        } return despensables;
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
