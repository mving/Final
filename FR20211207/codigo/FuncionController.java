package controlador;

import dto.FuncionDTO;
import modelo.Entrada;
import modelo.Funcion;
import modelo.Pelicula;
import modelo.Sala;
import modelo.TipoGenero;
import modelo.TipoProyeccion;

import java.util.*;

/**
 * 
 */
public class FuncionController {
	
	private List<Funcion> funcion;

	public static FuncionController instancia;
	
		FuncionController() {
    	funcion= new ArrayList<Funcion>();
    	funcion.add(new Funcion(new Date(), 1, "11:00", new ArrayList<Entrada>(), new Sala(0, null, 0)));

    }

    /**
     * Default constructor
     */





    /**
     * 
     */
    public void ABM() {
        // TODO implement here
    }

    /**
     * @param funcionID 
     * @return
     */
    public int obtenerAsientosDisponiblePorFuncion(int funcionID) {
    	int asientos = -1;
		return asientos;
    }

    /**
     * @param fchFuncion 
     * @return
     */
    public List<FuncionDTO> getListaFunciones(Date fchFuncion) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int peliculaMasVista() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int diaDeLaSemanaConMenorVentas() {
        // TODO implement here
        return 0;
    }

}