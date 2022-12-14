package DTO;

import modelo.Producto;

import java.util.ArrayList;

public class ProductoDTO {

    public ProductoDTO(int productoID, String descripcion, double precioUnitario) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     *
     */
    public int getProductoID() {
        // TODO implement here
        return productoID;
    }

    public static ArrayList<ProductoDTO> listToDTO(ArrayList<Producto> lista) throws Exception {
        ArrayList<ProductoDTO> dtoList = new ArrayList<>();
        for (Producto p : lista) {
            dtoList.add(p.toDTO());
        }
        return dtoList;
    }

}
