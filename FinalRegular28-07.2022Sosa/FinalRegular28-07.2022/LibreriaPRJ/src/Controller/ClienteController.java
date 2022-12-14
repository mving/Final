package Controller;

import DTO.ClienteDTO;
import DTO.ListaPrecioDTO;
import DTO.ProductoDTO;
import modelo.Cliente;
import modelo.ListaPrecio;
import modelo.Producto;
import modelo.TipoCliente;

import java.util.*;

/**
 * 
 */
public class ClienteController {
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<ListaPrecio> listasP = new ArrayList<>();
    private static ClienteController instancia;

    /**
     * Default constructor
     */
    public ClienteController() {
    }

    public static synchronized ClienteController getInstances(){
        if (instancia == null)
            instancia = new ClienteController();
        return instancia;
    }

    public void agregarClientes(String CUIT, String rz, TipoCliente tipoCliente){
        clientes.add(new Cliente(CUIT,rz,tipoCliente));
    }

    public void datosPrueba(){
        agregarClientes("7382", "razon1", TipoCliente.Exento);
        agregarClientes("7322", "razon2", TipoCliente.ConsumidorFinal);
        agregarClientes("722", "razon3", TipoCliente.ResponsableInscripto);
        agregarClientes("382", "razon4", TipoCliente.Exento);
    }

    /**
     * @param lpID
     */
    public List<ClienteDTO> getClientesPorListaPrecio(int lpID) {
        ArrayList<ClienteDTO> lista = new ArrayList<ClienteDTO>();
        ArrayList<Cliente> laLista = null;
        for (ListaPrecio lp : listasP) {
            if (lp.getListaPreciosID() == lpID) {
                laLista = lp.getClientes();
            }
        }
        for (Cliente c : laLista)
            lista.add(c.toDTO());
        return lista;
    }

    public ArrayList<ListaPrecioDTO> getAllListaP() throws Exception {
        ArrayList<ListaPrecioDTO> listDto = new ArrayList<>();
        for (ListaPrecio lp: listasP){
            listDto.add(lp.toDTO());
        }
        return listDto;
    }

    public ArrayList<ProductoDTO> getAllListaP_producto(ProductoDTO entrada) throws Exception {
        ArrayList<ProductoDTO> listDto = new ArrayList<>();
        for (ListaPrecio lp: listasP){
            for (Producto p: lp.getProductos()) {
                if (entrada.equals(p))
                    listDto.add(p.toDTO());
            }
        }
        return listDto;
    }


    /**
     * @param cantFacturas
     */
    public List<ClienteDTO>  getClienteConFacturasAdeudadas(int cantFacturas) {
        ArrayList<ClienteDTO> result = new ArrayList<ClienteDTO>();
        for (Cliente c: this.clientes) {
                if (c.tieneFacturasImpagas(cantFacturas))
                    result.add(c.toDTO());
        }
        return result;
    }


}