package modelo;

/**
 * 
 */
public class FacturaImpuesto {

    /**
     * Default constructor
     */
    public FacturaImpuesto(TipoImpuesto tipoImpuesto, double porcentaje, double importe) {
        this.tipoImpuesto = tipoImpuesto;
        this.porcentaje = porcentaje;
        this.importe = importe;
    }

    /**
     * 
     */
    private double porcentaje;

    /**
     * 
     */
    private double importe;

    /**
     * 
     */
    private TipoImpuesto tipoImpuesto;

}