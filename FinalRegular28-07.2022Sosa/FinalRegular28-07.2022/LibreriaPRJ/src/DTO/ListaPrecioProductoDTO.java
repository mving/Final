package DTO;

import java.util.Date;

public class ListaPrecioProductoDTO {
    private double precio;
    private Date fchPrecio;

    public ListaPrecioProductoDTO(double precio, Date fchPrecio){
        this.precio = precio;
        this.fchPrecio = fchPrecio;
    }
}
