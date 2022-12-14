package modelo.DTO;

import modelo.modelo.Entrada;
import modelo.modelo.Sala;

import java.util.Date;
import java.util.List;

public class FuncionDTO {

    private int funcionID;
    private String horario;
    private Date fecha;
    private List<Entrada> entradas;
    private SalaDTO sala;
    private PeliculaDTO pelicula;

    public int getFuncionID() {
        return funcionID;
    }

    public String getHorario() {
        return horario;
    }

    public Date getFecha() {
        return fecha;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public SalaDTO getSala() {
        return sala;
    }

    public int getCantidadAsientosDisponibles(){
        return sala.getAsientos();
    }

    public PeliculaDTO getPelicula() {
        return pelicula;
    }

    public FuncionDTO(Date fecha, int funcionID, String horario, List<Entrada> entradas, SalaDTO sala, PeliculaDTO pelicula) {

        this.entradas = entradas;
        this.fecha = fecha;
        this.funcionID = funcionID;
        this.horario = horario;
        this.sala = sala;
        this.pelicula = pelicula;

    }


}
