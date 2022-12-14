package modelo;

import DTO.ProductoDTO;

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

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public ProductoDTO toDTO(){
        return new ProductoDTO(this.getProductoID(), this.getDescripcion(), this.getPrecioUnitario());
    }
}