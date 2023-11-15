/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.applibreria;

/**
 *
 * @author Tom
 */
public class Libro {
    private int ISBN;
    private String titulo;
    private int cantidadDisponibleBiblioteca;
    private int cantidadDisponiblePrestamo;
    private String imagen;
    
    // DEBE COMPLETAR ESTE CONSTRUCTOR
    public Libro(int ISBN) {
        setISBN(ISBN);
    }
    
    /**
     * @return the ISBN
     */
    public int getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
    
    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the cantidadDisponibleBiblioteca
     */
    public int getCantidadDisponibleBiblioteca() {
        return cantidadDisponibleBiblioteca;
    }

    /**
     * @param cantidadDisponibleBiblioteca the cantidadDisponibleBiblioteca to set
     */
    public void setCantidadDisponibleBiblioteca(int cantidadDisponibleBiblioteca) {
        this.cantidadDisponibleBiblioteca = cantidadDisponibleBiblioteca;
    }

    /**
     * @return the cantidadDisponiblePrestamo
     */
    public int getCantidadDisponiblePrestamo() {
        return cantidadDisponiblePrestamo;
    }

    /**
     * @param cantidadDisponiblePrestamo the cantidadDisponiblePrestamo to set
     */
    public void setCantidadDisponiblePrestamo(int cantidadDisponiblePrestamo) {
        this.cantidadDisponiblePrestamo = cantidadDisponiblePrestamo;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
