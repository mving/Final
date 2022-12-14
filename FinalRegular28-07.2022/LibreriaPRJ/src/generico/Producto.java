package generico;

import java.util.*;

/**
 * 
 */
public class Producto {

    /**
     * Default constructor
     */
    public Producto(int productoID, String descripcion, double precioUnitario) {
        this.productoID = productoID;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
    }

    /**
     * 
     */
    private int productoID;

    /**
     * 
     */
    private String descripcion;

    /**
     * 
     */
    private double precioUnitario;

    /**
     * 
     */
    public int getProductoID() {
        // TODO implement here
        return productoID;
    }

}