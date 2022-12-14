package modelo.modelo;

import modelo.DTO.FuncionDTO;

import java.util.*;

/**
 * 
 */
public class Funcion {

    /**
     * Default constructor
     */
    public Funcion(Date fecha, int funcionID, String horario, List<Entrada> entradas, Sala sala, Pelicula pelicula) {
    	
    	this.entradas = entradas;
    	this.fecha = fecha;
    	this.funcionID = funcionID;
    	this.horario = horario;    	
    	this.sala = sala;
    	this.pelicula = pelicula;
    }



    /**
     * 
     */
    private int funcionID;

    /**
     * 
     */
    private String horario;

    /**
     * 
     */
    private Date fecha;

    /**
     * 
     */
    private List<Entrada> entradas;

    private Sala sala;

    private Pelicula pelicula;

    public Pelicula getPelicula() {
        return pelicula;
    }

    /**
     * @return
     */
    public int getSalaID() {
        // TODO implement here
        return sala.getSalaID();
    }

    /**
     * @return
     */
    public int getSucursalID() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public String getPeliculaID() {
        // TODO implement here
        return pelicula.getId();
    }

    public String getHorario() {
        return horario;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public Sala getSala() {
        return sala;
    }

    /**
     * 
     */
    public int getCantidadAsientosDisponibles() {
    	
		return 0;
        // TODO implement here
    }

    /**
     * @return
     */
    public int getFuncionID() {

        return this.funcionID;
    }

    /**
     * 	
     */
    public Date getFecha() {
		return fecha;
        // TODO implement here
    }

    public FuncionDTO toDTO(){
        FuncionDTO dto = new FuncionDTO(this.getFecha(),this.getFuncionID(),this.getHorario(),
                this.getEntradas(),this.getSala().toDTO(), this.getPelicula().toDTO());
        return dto;
    }
}