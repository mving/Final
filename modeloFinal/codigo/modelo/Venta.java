package modelo.modelo;


import java.util.*;

/**
 * 
 */
public class Venta {

    /**
     * Default constructor
     */
    public Venta(int ventaID, Date fchVenta, List<Combo> combos, List<Entrada> entradas) {
    	this.combos = combos;
    	this.entradas = entradas;
    	this.fchVenta = fchVenta;
    }


	/**
     * 
     */
    private int ventaID;

    /**
     * 
     */
    private Date fchVenta;

    /**
     * 
     */
    private List<Combo> combos;

    /**
     * 
     */
    private List<Entrada> entradas;





    /**
     * @return
     */
    public int getFuncionID() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public float getTotal() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * 
     */
    public void getPeliculaID() {
        // TODO implement here
    }

    /**
     * @return
     */
    public TipoTarjeta getTipoTarjeta() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public List<Combo> getListaComboID() {
		return combos;
		
        // TODO implement here
    }

}