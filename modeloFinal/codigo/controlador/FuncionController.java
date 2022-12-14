package modelo.controlador;

import modelo.DTO.FuncionDTO;
import modelo.DTO.PeliculaDTO;
import modelo.modelo.*;

import java.util.*;

/**
 * 
 */
public class FuncionController {
	
	private List<Funcion> funcion;

	public static FuncionController instancia;

    private PeliculasController pelis = PeliculasController.getInstances();
	
    public FuncionController() {
    	funcion= new ArrayList<Funcion>();
    	funcion.add(new Funcion(new Date(), 1, "11:00", new ArrayList<Entrada>(), new Sala(0, null,
                20), pelis.getByPeliculaID_Pelicula("001").toModel()));

    }

    public static synchronized FuncionController getInstances(){
        if (instancia == null)
            instancia = new FuncionController();
        return instancia;
    }

    public void actualizarAsientoSala(int idfuncion){
        FuncionDTO fu = getByID_Funcion(idfuncion);
        fu.getSala().actualizarAsiento();
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
        FuncionDTO dto = null;
        for (Funcion f : funcion) {
            if (f.getFuncionID() == funcionID)
                dto = f.toDTO();
        }
        int asientos = 0;
        if (dto != null) {
            asientos = dto.getCantidadAsientosDisponibles();
            return asientos - dto.getEntradas().size();
        }
        return asientos;
    }

    public void comprarEntrada(String tituloPelicula){

    }


    public FuncionDTO getByID_Funcion(int id){
        for(Funcion f: funcion){
            if (f.getFuncionID() == id)
                return f.toDTO();
        }
        return null;
    }


    public ArrayList<FuncionDTO> getFuncionesCondiciones(TipoGenero genero, TipoProyeccion tipo, int duracion){
        ArrayList<PeliculaDTO> listaPelis = pelis.getPeliculasCondiciones(genero, tipo, duracion);
        ArrayList<FuncionDTO> funcionesAsociadas = new ArrayList<>();
        for (int j = 0; j < funcion.size(); j++){
            for (int i = 0; i < listaPelis.size(); i++){
                if (funcion.get(j).getPelicula().getId() == listaPelis.get(i).getId())
                    funcionesAsociadas.add(funcion.get(j).toDTO());
            }
        }
        return funcionesAsociadas;
    }



    /**
     * @param fchFuncion 
     * @return
     */
    public List<FuncionDTO> getListaFunciones(Date fchFuncion) {
        // TODO implement here
        return listarTodoxFecha(fchFuncion);
    }

    public ArrayList<FuncionDTO> listarTodo(){
        ArrayList<FuncionDTO> listado = new ArrayList<FuncionDTO>();
        for(Funcion f: funcion){
            listado.add(f.toDTO());
        }
        return listado;
    }

    public ArrayList<FuncionDTO> listarTodoxFecha(Date fchFuncion){
        ArrayList<FuncionDTO> listado = new ArrayList<FuncionDTO>();
        for(Funcion f: funcion){
            if (f.getFecha().equals(fchFuncion))
                listado.add(f.toDTO());
        }
        return listado;
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