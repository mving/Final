package modelo.controlador;


import java.util.*;

import modelo.DTO.FuncionDTO;
import modelo.DTO.PeliculaDTO;
import modelo.modelo.Pelicula;
import modelo.modelo.TipoGenero;
import modelo.modelo.TipoProyeccion;

import static java.lang.Integer.valueOf;

/**
 * 
 */
    	
public class PeliculasController {

    /**
     * Default constructor
     */
	
	private static List<Pelicula> peliculas;

    private static PeliculasController instancia;
	
    public PeliculasController() {
    	peliculas= new ArrayList<Pelicula>();
    	peliculas.add(new Pelicula(TipoGenero.Suspenso, "Director X", 180 , "Pelicula1", TipoProyeccion.DosD, Arrays.asList("Actriz Principal", "Actor Secundario"),"001"));

    }


    public static synchronized PeliculasController getInstances(){
        if(instancia == null)
            instancia = new PeliculasController();
        return instancia;
    }

    public ArrayList<PeliculaDTO> getPeliculasCondiciones(TipoGenero genero, TipoProyeccion tipo, int duracion){
        ArrayList<PeliculaDTO> array = new ArrayList<>();
        for(Pelicula p: peliculas){
            if(p.getGeneroID().equals(genero) && p.getTipo().equals(tipo) && p.getDuracionEnMinutos() > (duracion * 60))
                array.add(p.toDTO());
        }
        return array;
    }

    public PeliculaDTO getByPeliculaID_Pelicula(String id){
        for(Pelicula p: peliculas){
            if (p.getId().equals(id))
                return p.toDTO();
        }
        return null;
    }

    public ArrayList<String> getActores(){
        ArrayList<String> actores = new ArrayList<>();
        for(Pelicula p: peliculas){
            for(String a: p.getActores())
                actores.add(a);
        }
        return actores;
    }




    public ArrayList<String> getDirectores(){
        ArrayList<String> directores = new ArrayList<>();
        for(Pelicula p: peliculas){
            directores.add(p.getDirector());
        }
        return directores;
    }


    /**
     * 
     */
    public void ABM() {
        // TODO implement here
    }

}