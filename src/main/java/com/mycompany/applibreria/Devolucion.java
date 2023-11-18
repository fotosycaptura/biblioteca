/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.applibreria;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
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
public class Devolucion {
    private int ISBN;
    private String RUN;
    
    private Usuario usuario;
    private Libro libro;
    
    /**
     * Método constructor
     */
    public Devolucion(){
        
        GregorianCalendar fechaDevolucion = new GregorianCalendar();
        fechaDevolucion.add(fechaDevolucion.DAY_OF_MONTH, a1.getDias());
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        fmt.setCalendar(fechaDevolucion);
        String fechaFormateada = fmt.format(fechaDevolucion.getTime());
    }
}
