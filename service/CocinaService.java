package service;

import entity.Despensa;
import entity.Ingrediente;
import entity.customExceptions.StockInsuficienteException;
import entity.customExceptions.VidaUtilInsuficienteException;
import entity.recetas.Receta;

import java.util.Map;
import java.util.stream.Collectors;


public class CocinaService {
    private Map<String, Receta> recetas;
    private DespensaService despensaService;

    public CocinaService() {
    }

    public CocinaService(Despensa despensa, Map<String, Receta> recetas, DespensaService despensaService) {
        this.recetas = recetas;
        this.despensaService = despensaService;
    }

    public Map<String, Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(Map<String, Receta> recetas) {
        this.recetas = recetas;
    }

    public DespensaService getDespensaService() {
        return despensaService;
    }

    public void setDespensaService(DespensaService despensaService) {
        this.despensaService = despensaService;
    }

    @Override
    public String toString() {
        return "CocinaService, " + this.showRecetas() + this.despensaService;
    }

    public String showRecetas() {
        return "recetas: " +this.recetas.values().stream().map(item -> toString()).collect(Collectors.joining("", "\n\n", ""));
    }

    public String makeReceta(String name) throws StockInsuficienteException, VidaUtilInsuficienteException {
        Despensa ingredientesFaltantes = this.verifyAvaReceta(recetaNumber);
        if (!ingredientesFaltantes.getIngredientes().isEmpty()) {
            throw new StockInsuficienteException("Faltan los siguientes ingredientes:  "+ingredientesFaltantes.showIngredientes());
        }
        for (Ingrediente ingrediente: this.recetas[recetaNumber-1].getIngredientes()) {
            try {
                this.despensa.getIngrediente(ingrediente.getNombre(), ingrediente.getCantidad());
            } catch (Exception e) {
                throw new StockInsuficienteException(e.getMessage());
            }
        }
        return this.recetas[recetaNumber-1].getPreparacion();
    }

}
