package modelo.modelo;


import modelo.DTO.PeliculaDTO;

import java.util.*;

/**
 * 
 */
public class Pelicula {

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

    /**
     * Default constructor
     */
    public Pelicula(TipoGenero generoID, String director, int duracionEnMinutos, String nombrePelicula,
                    TipoProyeccion tipo, List<String> actores, String id) {

    this.actores = actores;
    this.director = director;
    this.duracionEnMinutos = duracionEnMinutos;
    this.generoID = generoID;
    this.nombrePelicula = nombrePelicula;
    this.tipo = tipo;
    this.id = id;
    }

    /**
     * 
     */
    private TipoGenero generoID;

    /**
     * 
     */
    private String nombrePelicula;

    private String id;
    /**
     * 
     */
    private int duracionEnMinutos;

    /**
     * 
     */
    private String director;

    /**
     * 
     */
    private List<String> actores;

    /**
     * 
     */
    public TipoProyeccion tipo;

    /**
     * 
     */
    public String getId() {
        return id;
    }

    public PeliculaDTO toDTO(){
        return new PeliculaDTO(this.getGeneroID(), this.getDirector(), this.getDuracionEnMinutos(), this.getNombrePelicula(),
                this.getTipo(), this.getActores());
    }
}