package modelo;

/**
 * 
 */
public class RemitoProducto {
    Producto producto;
    /**
     * Default constructor
     */
    public RemitoProducto(Producto producto, int cantidad, double precio) {
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

    /**
     * 
     */
    public int getProductoID() {
        // TODO implement here
        return producto.getProductoID();
    }

    /**
     * 
     */
    public int getCantidad() {
        // TODO implement here
        return cantidad;
    }

}