package generico;

import java.util.*;

/**
 * 
 */
public class Recibo {
    private Cliente cliente;
    private List<Pago> listaPagos = new ArrayList<Pago>();
    /**
     * Default constructor
     */
    public Recibo() {
    }

    /**
     * 
     */
    public String getCuitCliente() {
        // TODO implement here
        return cliente.getCuit();
    }

    /**
     * 
     */
    public String getRazonSocialCliente() {
        // TODO implement here
        return cliente.getRazonSocial();
    }

    /**
     * 
     */
    public List<InfoPagoDTO> obtenerInfoPagos() {
        // TODO implement here
        List<InfoPagoDTO> result = new ArrayList<InfoPagoDTO>();
        for (Pago p: listaPagos) {
            InfoPagoDTO unDTO = new InfoPagoDTO();
            unDTO.fecha = p.getFecha();
            unDTO.banco = p.getBanco();
            unDTO.cuenta = p.getCuenta();
            unDTO.importe = p.getImporte();
            unDTO.infoFactura = p.getInfoFacturas();
        }

        return result;
    }

}