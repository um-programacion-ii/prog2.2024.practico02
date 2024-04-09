package service;

import entity.Despensa;
import entity.Ingrediente;
import entity.customExceptions.InvalidIngredientException;
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

    public Despensa verifyStock(Set<Ingrediente> ingredienteSet) {
        Despensa ingredientesFaltantes = new Despensa();
        for (Ingrediente ingrediente: ingredienteSet) {
            try {
                Ingrediente ingredienteDisp = this.despensa.inspectIngrediente(ingrediente.getNombre());
                if (ingredienteDisp.getCantidad() < ingrediente.getCantidad()) {
                    ingrediente.setCantidad(ingrediente.getCantidad()-ingredienteDisp.getCantidad());
                    ingredientesFaltantes.addIngrediente(ingrediente);
                }
            } catch (InvalidIngredientException e) {
                ingredientesFaltantes.addIngrediente(ingrediente);
            }
        }
        return ingredientesFaltantes;
    }



    public void renovarUtensilios() {}
}
