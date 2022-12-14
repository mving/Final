package generico;

import java.util.*;

/**
 * 
 */
public class PagosController {
    private List<Recibo> recibos = new ArrayList<Recibo>();
    private List<Pago> pagos = new ArrayList<Pago>();
    /**
     * Default constructor
     */
    public PagosController() {
    }


    /**
     * 
     */
    public List<ReciboEmitidoDTO> obtenerRecibosEmitidos() {
        List<ReciboEmitidoDTO> result = new ArrayList<ReciboEmitidoDTO>();

        for (Recibo r : this.recibos) {
            ReciboEmitidoDTO unRecibo = new ReciboEmitidoDTO();

            unRecibo.cuitCliente = r.getCuitCliente();
            unRecibo.razonSocial = r.getRazonSocialCliente();

            for (InfoPagoDTO pago: r.obtenerInfoPagos()) {
                unRecibo.infoPago.add(pago);
            }

            result.add(unRecibo);
        }

        return result;
    }

    public int agregarPago(InfoPagoDTO nuevoPago)
    {
        Pago p = new Pago(nuevoPago.fecha, nuevoPago.importe, nuevoPago.banco, nuevoPago.cuenta);
        for (InfoFacturaDTO info:nuevoPago.infoFactura) {
            //Factura f = ControllerVentas.getIntance().getFactura(info.numero);
            Factura f = null;
            p.agregarFacturaAsociada(f, info.total);
        }
        this.pagos.add(p);
        return this.pagos.size();
    }
}