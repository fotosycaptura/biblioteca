/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author carlo
 */
public class Libro {

    private int isbn;
    private String titulo;
    private int cantidadDisponibleBiblioteca;
    private int cantidadDisponiblePrestamo;
    private String imagen; 
    
    
    /**
     * @return the isbn
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
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
