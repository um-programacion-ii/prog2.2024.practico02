package entity;

import entity.customExceptions.VidaUtilInsuficienteException;

public class Utensilio implements Reutilizable {
    private String nombre;
    private Integer vidaUtil;
    private Integer vidaUtilInicial;

    public Utensilio() {
    }

    public Utensilio(String nombre, Integer vidaUtil) {
        this.nombre = nombre;
        this.vidaUtil = vidaUtil;
        this.vidaUtilInicial = vidaUtil;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Integer getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(Integer vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public Integer getVidaUtilInicial() {
        return vidaUtilInicial;
    }

    public void setVidaUtilInicial(Integer vidaUtilInicial) {
        this.vidaUtilInicial = vidaUtilInicial;
    }

    @Override
    public String toString() {
        return nombre + "  Vida útil: "+vidaUtil;
    }

    @Override
    public void use(int usageTime) throws VidaUtilInsuficienteException {
        if (usageTime > this.vidaUtil) {
            this.vidaUtil -= usageTime;
        } else {
            throw new VidaUtilInsuficienteException(String.format("Not enough remaining usage time of %s", this.nombre));
        }
    }

    @Override
    public void renew(int usageTime) {
        this.vidaUtil = this.vidaUtilInicial;
    }
}
