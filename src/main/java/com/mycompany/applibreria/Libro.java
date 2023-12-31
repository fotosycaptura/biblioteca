/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.applibreria;

import java.util.ArrayList;

/**
 *
 * @author Tom
 * Clase entregada para trabajar en ella por el profesor
 * Modificado por integrantes del grupo 2:
 * Xavier Fuentes
 * Carlos Anch
 * Felipe González
 * Sebastian Lantadilla
 * Ivan Rojas
 */
public class Libro {
    private int ISBN;
    private String titulo;
    private String autor;
    private int cantidadDisponibleBiblioteca;
    private int cantidadDisponiblePrestamo;
    private String imagen;
    
    /**
     * Constructor. Que hará las veces también de "Crear Libro"
     */
    public Libro(int ISBN, String titulo, String autor, int copiasDisponibles, int copiasParaPrestamo, String portada, ArrayList<Libro> libros) {
        if (!encontrarLibro(ISBN, libros)){
            setISBN(ISBN);
            setTitulo(titulo);
            setAutor(autor);
            setCantidadDisponibleBiblioteca(copiasDisponibles);
            setCantidadDisponiblePrestamo(copiasParaPrestamo);
            setImagen(portada);
        }else{
            throw new IllegalArgumentException("Este ISBN del libro ya existe! Abortando...");
        }
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
    
    public static Boolean encontrarLibro(int ISBN, ArrayList<Libro> libros){
        for (Libro libro: libros){
            if (libro.getISBN() == ISBN){
                return true;
            }
        }
        return false;
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
        if (cantidadDisponibleBiblioteca <= 0){
            throw new IllegalArgumentException("Debe ingresar un valor mayor que cero.");
        }
        
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
        
        if (cantidadDisponiblePrestamo <= 0){
            throw new IllegalArgumentException("Debe ingresar un valor mayor que cero.");
        }
        
        if (cantidadDisponiblePrestamo > getCantidadDisponibleBiblioteca()){
            throw new IllegalArgumentException("Debe ingresar una cantidad razonable con respecto a la disponible en biblioteca.");
        }
        
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
    
    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        if (autor != null && autor.length() > 0){
            this.autor = autor;
        }else{
            throw new IllegalArgumentException("El autor no puede estar nulo. Debe ingresar un autor!");
        }
        
    }
    /**
     * Método encargado de eliminar un libro del ArrayList de libros
     * Dado un ISBN. Si la operación se lleva a cabo exitosamente, retorna true
     * En caso contrario, false
     * @param ISBN
     * @param libros
     * @return Boolean
     */
    public static Boolean eliminar(int ISBN, ArrayList<Libro> libros){
        int indice = -1;
        for (int i=0; i < libros.size(); i++){
            if (libros.get(i).getISBN() == ISBN){
                indice = i;
                break;
            }
        }
        
        if (indice >= 0){
            libros.remove(indice);
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Encargado de buscar y obtener un obj de tipo libro mediante un ISBN dado
     * @param ISBN
     * @param libros
     * @return 
     */
    public static Libro verLibro(int ISBN, ArrayList<Libro> libros){
        for (Libro libro: libros){
            if (libro.getISBN() == ISBN){
                return libro;
            }
        }
        return null;
    }
    
    /**
     * Sobreescribe el método toString para desplegar valores personalizados.
     */
    @Override
    public String toString() {
        return "ISBN: " + getISBN() + "\t" +
                "Título: " + getTitulo() + "\t" +
                "Autor: " + getAutor() + "\t" +
                "En inventario: " + getCantidadDisponibleBiblioteca() + "\t" +
                "Disponibles para préstamos: " + getCantidadDisponiblePrestamo();
    }

    
}
