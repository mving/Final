package generico;

/**
 * 
 */
public class FacturaProducto {
    Producto producto;
    /**
     * Default constructor
     */
    public FacturaProducto(Producto producto, int cantidad, double precio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    /**
     * 
     */
    private int cantidad;

    /**
     * 
     */
    private double precio;

}