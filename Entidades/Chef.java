package Entidades;


import Excepciones.StockInsuficiente;
import Excepciones.VidaUtilInsuficiente;
import Servicios.CocinaService;
import Servicios.DespensaService;

public class Chef {
    private String nombre;
    private int estrellasMichelin;

    public Chef(String nombre, int estrellasMichelin){
        this.estrellasMichelin = estrellasMichelin;
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getEstrellasMichelin(){
        return estrellasMichelin;
    }

    public void setEstrellasMichelin(int estrellasMichelin){
        this.estrellasMichelin = estrellasMichelin;
    }

    public void cocinar(CocinaService cocina, Receta receta) throws VidaUtilInsuficiente, StockInsuficiente {
        System.out.println("Hola soy " + nombre);
        cocina.prepararReceta(receta);
    }

    public void renovarDespensa(Despensa despensa){
        DespensaService.renovarUtensilios(despensa);
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + ", Cantidad de estrellas michelin: " + estrellasMichelin;
    }
}

