package generico;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Pago {
    private List<PagoFactura> facturas = new ArrayList<PagoFactura>();

    /**
     * Default constructor
     */
    public Pago(LocalDate fecha, double importe, String banco, String cuenta) {
        this.fecha = fecha;
        this.importe = importe;
        this.banco = banco;
        this.cuenta = cuenta;
    }

    public int agregarFacturaAsociada(Factura f, double importe)
    {
        PagoFactura pf = new PagoFactura(this, f, importe);
        f.agregarPago(pf);
        this.facturas.add(pf);
        return this.facturas.size();
    }
    /**
     * 
     */
    private LocalDate fecha;

    /**
     * 
     */
    private double importe;

    /**
     * 
     */
    private String banco;

    /**
     * 
     */
    private String cuenta;

    /**
     * 
     */
    public LocalDate getFecha() {
        return this.fecha;
    }

    /**
     * 
     */
    public String getBanco() {
        return this.banco;
    }

    /**
     * 
     */
    public String getCuenta() {
        return this.cuenta;
    }

    /**
     * 
     */
    public double getImporte() {
        return this.importe;
    }

    /**
     * 
     */
    public List<InfoFacturaDTO> getInfoFacturas() {
        List<InfoFacturaDTO> result = new ArrayList<InfoFacturaDTO>();

        for (PagoFactura f: this.facturas) {
            InfoFacturaDTO unaFactura = new InfoFacturaDTO();
            unaFactura.fchEmision = f.getfchEmision();
            unaFactura.numero = f.getNumero();
            unaFactura.total = f.getTotal();

            result.add(unaFactura);
        }
        return result;
    }

}