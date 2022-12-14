package modelo.controlador;


import java.util.*;

import modelo.modelo.*;

/**
 * 
 */
public class DescuentoController {
	
	
	private static DescuentoController instancia;

	private List<Combo> Combos;
	
	private List<CondicionesDescuento> Descuento;
	
    public DescuentoController() {
		Descuento = new ArrayList<CondicionesDescuento>();
		CondicionesDescuento CondicionesDescuento = new CondicionesDescuento(new Date(), new Date(), 5, 50, TipoTarjeta.PAMI, new ArrayList<TarjetaDescuento>());
		Descuento.add(CondicionesDescuento);
		Combos = new ArrayList<>();
		Combo combo = new Combo(01, "Primer combo", 145.0F,null);
		Combos.add(combo);
    }

	public static synchronized DescuentoController getInstancia(){
		if (instancia == null){
			instancia = new DescuentoController();
		}
		return instancia;
	}

	public ArrayList<Combo> getCombos(){
		ArrayList<Combo> a = new ArrayList<>();
		for(Combo c: Combos){
			a.add(c);
		}
		return a;
	}



    /**
     * 
     */
    public void ABM() {
	}



}