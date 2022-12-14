package modelo.DTO;

import modelo.modelo.Pelicula;
import modelo.modelo.TipoGenero;
import modelo.modelo.TipoProyeccion;

import java.util.List;

public class PeliculaDTO {
    private TipoGenero generoID;
    private String nombrePelicula;
    private int duracionEnMinutos;
    private String director;
    private List<String> actores;
    private TipoProyeccion tipo;
    private String id;

    public String getId() {
        return id;
    }

    public TipoGenero getGeneroID() {
        return generoID;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public String getDirector() {
        return director;
    }

    public List<String> getActores() {
        return actores;
    }

    public TipoProyeccion getTipo() {
        return tipo;
    }

    public PeliculaDTO(TipoGenero generoID, String director, int duracionEnMinutos, String nombrePelicula, TipoProyeccion tipo, List<String> actores) {

        this.actores = actores;
        this.director = director;
        this.duracionEnMinutos = duracionEnMinutos;
        this.generoID = generoID;
        this.nombrePelicula = nombrePelicula;
        this.tipo = tipo;



    }

    public Pelicula toModel(){
        return new Pelicula(this.getGeneroID(), this.getDirector(), this.getDuracionEnMinutos(), this.getNombrePelicula(),
                this.getTipo(), this.getActores(), this.getId());
    }

}
