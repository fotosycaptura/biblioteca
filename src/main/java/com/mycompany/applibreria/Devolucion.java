/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.applibreria;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
    private int multa;
    private Prestamo prestamo;
    
    public Devolucion(Prestamo prestamo){
        setPrestamo(prestamo);
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
    
    public void devolverLibro(){
        
       GregorianCalendar devolucion = new GregorianCalendar();
       GregorianCalendar prestamo = getPrestamo().getFecha();

       

      int days = 0;

       while (!prestamo.after(devolucion)){
            prestamo.add(Calendar.DAY_OF_MONTH, 1);
            days++;
       }
            System.out.println("Días de diferencia: " + days);

    }
    
}
