package modelo;

import DTO.ListaPrecioDTO;
import DTO.ProductoDTO;

import java.util.ArrayList;

public class ListaPrecio {
    private int listaPreciosID;
    private String descripcion;
    private ArrayList<Producto> productos;

    public ListaPrecio(int listaPreciosID, String descripcion, ArrayList<Producto> productos){
        this.listaPreciosID = listaPreciosID;
        this.descripcion = descripcion;
        this.productos = productos;
    }

    public int getListaPreciosID() {
        return listaPreciosID;
    }

    public ArrayList<Cliente> getClientes(){
        return null;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public int addCliente(int codCliente){
        return 0;
    }

    public ListaPrecioDTO toDTO() throws Exception {
        return new ListaPrecioDTO(this.getListaPreciosID(), this.getDescripcion(), ProductoDTO.listToDTO(this.getProductos()));
    }
}
