package entity;

import entity.customExceptions.VidaUtilInsuficienteException;

public interface Reutilizable extends Despensable{

    public void use(int time) throws VidaUtilInsuficienteException;

    public void renew(int usageTime);

    public String getNombre();

    public Integer getVidaUtil();

}
