package modelo;

import java.util.*;
import java.time.*;

/**
 * 
 */
public class Factura {
    private Cliente cliente;
    private List<PagoFactura> pagos = new ArrayList<PagoFactura>();
    private List<FacturaImpuesto> impuestos = new ArrayList<FacturaImpuesto>();

    private List<FacturaProducto> productos = new ArrayList<FacturaProducto>();
    /**
     * Default constructor
     */
    public Factura(Cliente cliente, int sucursalID, int numero, LocalDate fchEmision) {
        this.cliente = cliente;
        this.sucursalID = sucursalID;
        this.numero = numero;
        this.fchEmision = fchEmision;
        this.total = 0;
        this.cliente.agregarFactura(this);
    }

    public int agregarProducto(Producto p, int cantidad, double precio)
    {
        this.productos.add(new FacturaProducto(p, cantidad, precio));
        this.total = this.total + (cantidad*precio);
        return this.productos.size();
    }

    public int agregarImpuesto(TipoImpuesto tipoImpuesto, double porcentaje, double importe)
    {
        this.impuestos.add(new FacturaImpuesto(tipoImpuesto, porcentaje, importe));
        return this.impuestos.size();
    }

    public int agregarPago(PagoFactura pago)
    {
        this.pagos.add(pago);
        return this.pagos.size();
    }
    /**
     * 
     */
    private int sucursalID;

    /**
     * 
     */
    private int numero;

    /**
     * 
     */
    private LocalDate fchEmision;

    /**
     * 
     */
    private double total;

    /**
     * 
     */
    public LocalDate getfchEmision() {
        return this.fchEmision;
    }

    /**
     * 
     */
    public int getNumero() {
        return this.numero;
    }

    /**
     * 
     */
    public double getTotal() {
        return this.total;
    }

    /**
     * 
     */
    public double getTotalPagado() {
        double result = 0;
        for (PagoFactura p: this.pagos) {
            result = result + p.getTotalPagado();
        }
        return result;
    }

}