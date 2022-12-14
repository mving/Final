package modelo.modelo;


import modelo.DTO.SalaDTO;

import java.util.*;

/**
 * 
 */
public class Sala {

    /**
     * Default constructor
     */
    public Sala(int salaID, String denominacion, int asientos) {
    	this.asientos = asientos;
    	this.denominacion = denominacion;
    	this.salaID = salaID;
    }

    /**
     * 
     */
    private int salaID;

    /**
     * 
     */
    private String denominacion;

    /**
     * 
     */
    private int asientos;



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
    public int getSalaID() {
        // TODO implement here
        return 0;
    }

    public String getDenominacion() {
        return denominacion;
    }

    /**
     * @return
     */
    public int getAsientos() {
        return this.asientos;
    }

    public void actualizarAsiento(){
        this.asientos = this.asientos - 1;
    }


    public SalaDTO toDTO(){
        SalaDTO dto = new SalaDTO(this.getSalaID(),this.getDenominacion(),this.getAsientos());
        return dto;
    }
}