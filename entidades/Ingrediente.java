package entidades;

public class Ingrediente {
    private String nombre;
    private int cantidad;

public Ingrediente(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    public Ingrediente() {
    }


    @Override
    public String toString() {
        return "entidades.Ingrediente{" + "nombre=" + nombre + ", cantidad=" + cantidad + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void sacarIngrediente(int cantidad){
    if (this.cantidad >= cantidad){
        this.cantidad -= cantidad;
    }else{
        System.out.println("No hay suficiente ingrediente");
        System.out.println("Faltan " + (cantidad - this.cantidad) + " unidades de " + this.nombre);
    }
    }

}
