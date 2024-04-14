package excepciones;

public class VidaUtilInsuficiente extends Exception{
    public VidaUtilInsuficiente() {
        super("Ocurrio un problema");
    }

    public VidaUtilInsuficiente(String message) {
        super(message);
    }
}
