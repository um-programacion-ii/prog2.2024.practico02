package entity;

import entity.customExceptions.NotEnoughStockException;
import entity.customExceptions.NotEnoughUseTimeException;

public interface Reutilizable {

    public String usar(int time) throws NotEnoughStockException, NotEnoughUseTimeException;
}
