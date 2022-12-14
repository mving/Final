package modelo;

import DTO.ClienteDTO;

import java.util.*;

/**
 * 
 */
public class Cliente {
    private ArrayList<Factura> facturas = new ArrayList<Factura>();
    private ArrayList<FacturaProducto> productos = new ArrayList<FacturaProducto>();

    /**
     * Default constructor
     */
    public Cliente(String cuit, String razonSocial, TipoCliente tipoCliente) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.tipoCliente = tipoCliente;

    }

    /**
     * 
     */
    private String cuit;

    /**
     * 
     */
    private String razonSocial;

    /**
     * 
     */
    private TipoCliente tipoCliente;

    /**
     * 
     */
    public String getCuit() {
        return this.cuit;
    }

    /**
     * 
     */
    public String getRazonSocial() {
        return this.razonSocial;
    }

    /**
     * 
     */
    public ClienteDTO toDTO() {
        ClienteDTO result = new ClienteDTO();
        result.cuit = this.cuit;
        result.razonSocial = this.razonSocial;
        result.tipoCliente = this.tipoCliente;
        return result;
    }

    public int agregarFactura(Factura f)
    {
        this.facturas.add(f);
        return this.facturas.size();
    }

    /**
     * @param cantFacturas
     */
    public boolean tieneFacturasImpagas(int cantFacturas) {
        boolean result;
        int facturasImpagas = 0;
        for (Factura f: this.facturas) {
            if (f.getTotal() > f.getTotalPagado())
                facturasImpagas++;
        }
        result = (facturasImpagas >= cantFacturas);
        return result;
    }

}