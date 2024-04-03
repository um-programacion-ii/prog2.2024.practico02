package entidades;

import interfaces.Cocinable;
import interfaces.Despensable;


import java.util.Map;

public class Despensa implements Cocinable {

    private Map<String, Despensable> despensableMap;

    public Despensa(Map<String, Despensable> despensableMap) {
        this.despensableMap = despensableMap;
    }

    public void sacar(String nombre, int cantidad) {
        Despensable despensable = despensableMap.get(nombre);
        if (despensable != null) {
            despensable.sacar(cantidad);
        } else {
            System.out.println("No se encontró el elemento en la despensa: " + nombre);
        }
    }

    public boolean contieneSuficienteDespensable(Despensable despensable) {
        Despensable despensaItem = despensableMap.get(despensable.getNombre());
        return despensaItem != null && despensaItem.getCantidadDisponible() >= despensable.getCantidadDisponible();
    }

    public int getCantidadDisponible(String nombreDespensable) {
        Despensable despensable = despensableMap.get(nombreDespensable);
        return despensable != null ? despensable.getCantidadDisponible() : 0;
    }

}


