package Controller;

import DTO.InfoFacturaDTO;
import DTO.InfoPagoDTO;
import DTO.ReciboEmitidoDTO;
import modelo.*;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class PagosController {
    private List<Recibo> recibos = new ArrayList<Recibo>();
    private List<Pago> pagos = new ArrayList<Pago>();
    private static PagosController instancia;
    /**
     * Default constructor
     */
    public PagosController() {
    }

    public static synchronized PagosController getInstances(){
        if (instancia == null)
            instancia = new PagosController();
        return instancia;
    }

    public void agregarPagos(LocalDate fecha, double importe, String banco, String cuenta){
        pagos.add(new Pago(fecha, importe, banco, cuenta));
    }

    public void datosPruebaPagos(){
        agregarPagos(LocalDate.parse("2007-12-03"), 145.0, "Banco1", "Cuenta1");
        agregarPagos(LocalDate.parse("2007-12-03"), 175.0, "Banco2", "Cuenta2");
        agregarPagos(LocalDate.parse("2007-12-03"), 135.0, "Banco3", "Cuenta3");
        agregarPagos(LocalDate.parse("2007-12-03"), 140.0, "Banco4", "Cuenta4");
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