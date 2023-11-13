/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unab.biblioteca;

/**
 *
 * @author xavie
 */
public class Usuario {
    private int run;
    private String nombre;
    private char genero;
    private int libroPrestamo;
    private Boolean vigente;

    public Usuario(int run, String nombre, char genero) {
        this.run = run;
        this.nombre = nombre;
        this.genero = genero;
    }

    
    
    /**
     * @return the run
     */
    public int getRun() {
        return run;
    }

    /**
     * @param run the run to set
     */
    public void setRun(int run) {
        this.run = run;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the genero
     */
    public char getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }

    

    /**
     * @return the libroPrestamo
     */
    public int getLibroPrestamo() {
        return libroPrestamo;
    }

    /**
     * @param libroPrestamo the libroPrestamo to set
     */
    public void setLibroPrestamo(int libroPrestamo) {
        this.libroPrestamo = libroPrestamo;
    }

    /**
     * @return the vigente
     */
    public Boolean getVigente() {
        return vigente;
    }

    /**
     * @param vigente the vigente to set
     */
    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }
    
    

}
