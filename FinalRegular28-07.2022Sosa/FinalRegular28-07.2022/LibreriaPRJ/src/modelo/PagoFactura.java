package modelo;
import java.time.LocalDate;

/**
 * 
 */
public class PagoFactura {
    private Factura factura;
    private Pago pago;
    /**
     * Default constructor
     */
    public PagoFactura(Pago pago, Factura factura, double totalPagado) {
        this.pago = pago;
        this.factura = factura;
        this.totalPagado = totalPagado;
    }

    /**
     * 
     */
    private double totalPagado;

    /**
     * 
     */
    public double getTotalPagado() {
        return this.totalPagado;
    }

    public LocalDate getfchEmision() {
        return this.factura.getfchEmision();
    }

    /**
     *
     */
    public int getNumero() {
        return this.factura.getNumero();
    }

    /**
     *
     */
    public double getTotal() {
        return this.factura.getTotal();
    }

}