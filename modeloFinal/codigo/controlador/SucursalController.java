package modelo.controlador;


import java.util.*;

import modelo.DTO.PeliculaDTO;
import modelo.DTO.SalaDTO;
import modelo.modelo.Pelicula;
import modelo.modelo.Sala;
import modelo.modelo.Sucursal;

/**
 * 
 */
public class SucursalController {

    /**
     * Default constructor
     */
	private static SucursalController controlador = null;
	private List<Sucursal> sucursal;
		
    public SucursalController() {
    	sucursal = new ArrayList<Sucursal>();
    	sucursal.add(new Sucursal(1, "Barracas", "Av Montes de Oca 1100", null));
    }

    public static synchronized SucursalController getInstances(){
        if (controlador == null)
            controlador = new SucursalController();
        return controlador;
    }



    /**
     * @param id 
     * @param denom 
     * @param dir
     */
    public void agregarSucursal(int id, String denom, String dir) {
        // TODO implement here
    }

    /**
     * @param idSucursal 
     * @param salaID 
     * @param denom 
     * @param nroasientos
     */
    public void agregarSala(int idSucursal, int salaID, String denom, int nroasientos) {
        // TODO implement here
    }

}