package generico;

import java.util.*;

/**
 * 
 */
public class ClienteController {
    private List<Cliente> clientes = new ArrayList<Cliente>();


    /**
     * Default constructor
     */
    public ClienteController() {
    }

    /**
     * @param lpID
     */
    public List<ClienteDTO> getClientesPorListaPrecio(int lpID) {
       return  null;
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