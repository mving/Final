package modelo;

import DTO.ProductoRemitoDTO;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Remito {
    private Cliente cliente;
    private ArrayList<RemitoProducto> productos = new ArrayList<RemitoProducto>();
    /**
     * Default constructor
     */
    public Remito(Cliente cliente, int remitoID, LocalDate fecha) {
        this.cliente = cliente;
        this.remitoID = remitoID;
        this.fecha = fecha;
    }

    public int agregarProducto(Producto p, int cantidad, double precio)
    {
        this.productos.add(new RemitoProducto(p, cantidad, precio));
        return this.productos.size();
    }

    /**
     * 
     */
    private int remitoID;

    /**
     * 
     */
    private LocalDate fecha;


    /**
     * 
     */
    public LocalDate getFecha() {
        return this.fecha;
    }

    /**
     * 
     */
    public ArrayList<ProductoRemitoDTO> getListaProductos() {
        ArrayList<ProductoRemitoDTO> result = new ArrayList<ProductoRemitoDTO>();

        for (RemitoProducto rp: this.productos) {
            ProductoRemitoDTO p = new ProductoRemitoDTO(rp.getProductoID(), rp.getCantidad(), 0);
            result.add(p);
        }
        return result;
    }

}