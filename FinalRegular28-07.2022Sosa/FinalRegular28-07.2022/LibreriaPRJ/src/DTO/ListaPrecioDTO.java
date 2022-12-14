package DTO;

import modelo.Cliente;
import modelo.Producto;

import java.util.ArrayList;

public class ListaPrecioDTO {
    private int listaPreciosID;
    private String descripcion;
    private ArrayList<ProductoDTO> productos;
    public ListaPrecioDTO(int listaPreciosID, String descripcion, ArrayList<ProductoDTO> productos){
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

    public int addCliente(int codCliente){
        return 0;
    }
}
