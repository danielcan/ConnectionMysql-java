package Modelo;

/**
 *libreria actualizable.
 * @since 2.0
 * @author PC LIFE
 */
public class Producto {

    private int id;
    private String codigo;
    private String nombre;
    private Double Precio;
    private int cantidad;

    public Producto(int id, String codigo, String nombre, Double Precio, int cantidad) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.Precio = Precio;
        this.cantidad = cantidad;
    }

    public Producto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
