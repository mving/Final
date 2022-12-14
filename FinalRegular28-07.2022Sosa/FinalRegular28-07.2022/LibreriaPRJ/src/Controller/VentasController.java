package Controller;

import DTO.*;
import modelo.*;

import java.time.LocalDate;

import java.util.*;

/**
 * 
 */
public class VentasController {
    private ArrayList<Remito> remitos = new ArrayList<Remito>();
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private ArrayList<Factura> facturas = new ArrayList<Factura>();
    private static VentasController instancia;
    /**
     * Default constructor
     */
    public VentasController() {
    }
    public static synchronized VentasController getInstances(){
        if (instancia == null)
            instancia = new VentasController();
        return instancia;
    }

    /**
     * @return
     */
    public List<RemitosEmitidosDTO> consultarRemitosEmitidos() {
        // TODO implement here
        return null;
    }

    public ProductoDTO idProdtoProd(int id){
        for(int i=0;i<productos.size();i++){
            if(i == id)
                return productos.get(i).toDTO();
        }
        return null;
    }

    public ArrayList<ProductoDTO> getAllProducto(){
        ArrayList<ProductoDTO> listDto = new ArrayList<>();
        for (Producto p: productos){
            listDto.add(p.toDTO());
        }
        return listDto;
    }
    Producto getProducto(int id)
    {
        for (Producto p: this.productos){
            if (p.getProductoID() == id)
                return p;
        }
        return null;
    }
    Factura getFactura(int numero)
    {
        for (Factura f: this.facturas){
            if (f.getNumero() == numero)
                return f;
        }
        return null;
    }
    public int agregarRemito(String cuitCliente, RemitosEmitidosDTO remito)
    {
        //Cliente unCliente = ClienteController.getInstance().getCliente(cuitCliente);
        Cliente unCliente = null;
        Remito r =new Remito(unCliente, this.remitos.size() + 1, LocalDate.now());

        for (ProductoRemitoDTO pr: remito.productos) {
            Producto p = getProducto(pr.productoID);
            r.agregarProducto(p, pr.cantidad, pr.precio);
        }

        return this.remitos.size();
    }

    public int agregarFactura(String cuitCliente, FacturaDTO factura)
    {
        //Cliente unCliente = ClienteController.getInstance().getCliente(cuitCliente);
        Cliente unCliente = null;
        Factura f =new Factura(unCliente, factura.sucursalID, factura.numero, factura.fchEmision);

        for (ProductoFacturaDTO pr: factura.productos) {
            Producto p = getProducto(pr.productoID);
            f.agregarProducto(p, pr.cantidad, pr.precio);
        }

        return this.remitos.size();
    }
    /**
     * @param fchDesde 
     * @param fchHasta
     */
    public int productoMasVendido(LocalDate fchDesde, LocalDate fchHasta) {
        ArrayList<ProductoRemitoDTO> consolidado = new ArrayList<ProductoRemitoDTO>();
        for (Remito r: this.remitos) {
            if (r.getFecha().isAfter(fchDesde) && r.getFecha().isBefore(fchHasta)) {
                ArrayList<ProductoRemitoDTO> lista = r.getListaProductos();

                for (ProductoRemitoDTO prod: lista) {
                    boolean encontrado = false;
                    for (ProductoRemitoDTO prodConsoli: consolidado) {
                        if (prod.productoID == prodConsoli.productoID)
                        {
                            prodConsoli.cantidad += prod.cantidad;
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado)
                        consolidado.add(prod);
                }
            }
        }

        if (consolidado.size() == 0)
            return -1;
        else {
            ProductoRemitoDTO masvendido = consolidado.get(0);
            for (ProductoRemitoDTO p: consolidado) {
                if (p.cantidad > masvendido.cantidad)
                    masvendido = p;
            }
            return masvendido.productoID;
        }
    }
}