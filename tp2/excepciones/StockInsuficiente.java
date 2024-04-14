package excepciones;

public class StockInsuficiente extends Exception{
    public StockInsuficiente() {
    }

    public StockInsuficiente(String message) {
        super(message);
    }
}
