package modelo.controlador;


import java.util.*;

import modelo.modelo.TipoTarjeta;
import modelo.modelo.Venta;

/**
 * 
 */
public class VentasController {

    /**
     * Default constructor
     */
    private List<Venta> ventas;

    private static VentasController instancia;
	
    public VentasController(){
        ventas = new ArrayList<Venta>();
        Venta venta = new Venta(1,new Date(), null, null);
        ventas.add(venta);
    }

    public static synchronized VentasController getInstances(){
        if (instancia == null)
            instancia = new VentasController();
        return instancia;
    }

    /**
     * @param funcionID 
     * @return
     */
    public float recaudacionPorFuncion(int funcionID) {
        // TODO implement here
        return 0.0f;
    }

    /**
     * 
     */
    public float recaudacionPorPelicula(int peliculaID) {
		return 0.0f;
        // TODO implement here
    }

    /**
     * @param tipoTarjeta 
     * @return
     */
    public float recaudacionPorTarjetaDescuento(TipoTarjeta tipoTarjeta) {
        // TODO implement here
        return 0.0f;
    }

    /**
     * 
     */
    public void comboMasVendido() {
        // TODO implement here
    }

}