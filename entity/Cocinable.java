package entity;

import entity.customExceptions.NotEnoughStockException;

public interface Cocinable {

    public String sacar(int amount) throws NotEnoughStockException;
}
