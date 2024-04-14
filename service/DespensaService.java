package service;

import entity.Cocinable;
import entity.Despensa;
import entity.Ingrediente;
import entity.Reutilizable;
import entity.customExceptions.InvalidIngredientException;
import entity.customExceptions.InvalidUtensilioException;
import entity.customExceptions.StockInsuficienteException;
import entity.customExceptions.VidaUtilInsuficienteException;
import entity.recetas.Receta;

import java.util.Set;

public class DespensaService {
    private Despensa despensa;

    public DespensaService() {
    }

    public DespensaService(Despensa despensa) {
        this.despensa = despensa;
    }

    public Despensa getDespensa() {
        return despensa;
    }

    public void setDespensa(Despensa despensa) {
        this.despensa = despensa;
    }

    @Override
    public String toString() {
        return "DespensaService: \n" + despensa;
    }

    public void verifyStock(Set<Cocinable> ingredienteSet) throws StockInsuficienteException {
        Despensa ingredientesFaltantes = new Despensa();
        for (Cocinable ingrediente: ingredienteSet) {
            try {
                Cocinable ingredienteDisp = this.despensa.inspectIngrediente(ingrediente.getNombre());
                if (ingredienteDisp.getCantidad() < ingrediente.getCantidad()) {
                    ingrediente.setCantidad(ingrediente.getCantidad()-ingredienteDisp.getCantidad());
                    ingredientesFaltantes.addIngrediente(ingrediente);
                }
            } catch (InvalidIngredientException e) {
                ingredientesFaltantes.addIngrediente(ingrediente);
            }
        }
        if (!ingredientesFaltantes.getIngredientes().isEmpty()){
            throw new StockInsuficienteException("Faltan los siguientes ingredientes:  "+ingredientesFaltantes.showItems(ingredientesFaltantes.getIngredientes()));
        }
    }

    public void verifyVidaUtil(Set<Reutilizable> utensilioSet) throws VidaUtilInsuficienteException {
        Despensa utensiliosFaltantes = new Despensa();
        for (Reutilizable utensilio: utensilioSet) {
            try {
                Reutilizable utensilioDisp = this.despensa.inspectUtensilio(utensilio.getNombre());
                if (utensilioDisp.getVidaUtil() < utensilio.getVidaUtil()) {
                    utensilio.setVidaUtil(utensilio.getVidaUtil()-utensilioDisp.getVidaUtil());
                    utensiliosFaltantes.getUtensilios().put(utensilio.getNombre(), utensilio);
                }
            } catch (InvalidUtensilioException e) {
                utensiliosFaltantes.getUtensilios().put(utensilio.getNombre(), utensilio);
            }
        }
        if (!utensiliosFaltantes.getIngredientes().isEmpty()){
            throw new VidaUtilInsuficienteException("Tiempo faltante en los siguientes utensilios:  "+utensiliosFaltantes.showItems(utensiliosFaltantes.getUtensilios()));
        }
    }

    public void renovarUtensilios(Reutilizable utensilio) throws InvalidUtensilioException {
        this.despensa.inspectUtensilio(utensilio.getNombre()).renew();
    }
}
