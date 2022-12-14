package modelo;


import java.util.*;

/**
 * 
 */
public class Entrada {

    /**
     * Default constructor
     */
    public Entrada(int nroAsiento, Funcion funcion) {
    	this.funcion = funcion;
    	this.nroAsiento = nroAsiento;
    }
    
    public Entrada() {

    }

    /**
     * 
     */
    private int nroAsiento;

    /**
     * 
     */
    public Funcion funcion;


    public int getFuncionID() {
        // TODO implement here
        return 0;
    }

    /**
     * 
     */
    public void getPeliculaID() {
        // TODO implement here
    }

}