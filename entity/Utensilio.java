package entity;

import entity.customExceptions.NotEnoughStockException;
import entity.customExceptions.NotEnoughUseTimeException;

public class Utensilio implements Despensable, Reutilizable{
    private String nombre;
    private Integer cantidad;
    private Integer vidaUtil;
    private Integer remUsageTime;

    public Utensilio() {
    }

    public Utensilio(String nombre, Integer cantidad, Integer vidaUtil) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.vidaUtil = vidaUtil;
        this.remUsageTime = vidaUtil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(Integer vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public Integer getRemUsageTime() {
        return remUsageTime;
    }

    public void setRemUsageTime(Integer remUsageTime) {
        this.remUsageTime = remUsageTime;
    }

    @Override
    public String toString() {
        return nombre + "  Cantidad: "+cantidad+"  Vida útil: "+vidaUtil;
    }

    @Override
    public String usar(int usageTime) throws NotEnoughStockException, NotEnoughUseTimeException {
        while (true) {
            if (usageTime > this.vidaUtil) {
                this.vidaUtil -= usageTime;
                return String.format("Remaining units: %d, remaining usage time: %d", this.cantidad, this.vidaUtil);
            } else if (this.cantidad > 0) {
                usageTime -= this.remUsageTime;
                this.cantidad -= 1;
                this.remUsageTime = this.vidaUtil;
            } else if ()

            } else {
                throw new NotEnoughUseTimeException(String.format("Not enough remaining usage time of %s", this.nombre));
            }
        }
    }
}
