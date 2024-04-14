package entity;

public class Chef {
    private String nombre;
    private int estrellasM;

    public Chef(){}

    public Chef(String nombre, int estrellasM) {
        this.nombre = nombre;
        this.estrellasM = estrellasM;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return estrellasM;
    }

    public void setCantidad(int estrellasM) {
        this.estrellasM = estrellasM;
    }

    @Override
    public String toString(){
        return "Chef: [Nombre: " + nombre + ",Estrellas Michelin: " + estrellasM + " ]";
    }
}
