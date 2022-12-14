package modelo.DTO;

public class SalaDTO {

    private int salaID;
    private String denominacion;
    private int asientos;

    public int getSalaID() {
        return salaID;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public int getAsientos() {
        return asientos;
    }

    public void actualizarAsiento(){
        this.asientos = this.asientos - 1;
    }

    public SalaDTO(int salaID, String denominacion, int asientos) {
        this.asientos = asientos;
        this.denominacion = denominacion;
        this.salaID = salaID;
    }


}
