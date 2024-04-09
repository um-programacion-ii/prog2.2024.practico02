package entity.customExceptions;

public class NotEnoughUseTimeException extends Exception{

    public NotEnoughUseTimeException(String mensaje) {
        super(mensaje);
    }
}
