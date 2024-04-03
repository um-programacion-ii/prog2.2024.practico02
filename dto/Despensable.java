package dto;

import exceptions.StockInsuficienteException;
import exceptions.VidaUtilInsuficienteException;

public interface Despensable {

    String sacar(int cantidad) throws VidaUtilInsuficienteException, StockInsuficienteException;
}
