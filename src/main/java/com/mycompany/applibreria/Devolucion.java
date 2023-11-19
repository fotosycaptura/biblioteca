/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.applibreria;
import java.util.GregorianCalendar;
import java.util.Date;
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
    private GregorianCalendar fechaDevolucion;
    private int multa;
    private int diasTranscurridos;
    private Prestamo prestamo;
    
    
    /**
     * Método constructor
     */
    public Devolucion(GregorianCalendar fechaDevolucion, Prestamo prestamo){
        
        setFechaDevolucion(fechaDevolucion);
        setPrestamo(prestamo);
        setMulta(calcularMulta());
        
    }
    
    private int calcularMulta(){
        //Tope días de estudiante
        int TopeDias = 10;
        int intMulta = 0;
        
        if (getPrestamo().obtenerTipoDeUsuario().equals("Docente")){
            //Tope días docente
            TopeDias = 20;
        }
        
        //Cálculo de días entre las dos fechas, aunque tenemos la cantidad de días con getDias
        //Se entiende que en un caso real la obtención de días sería mediante las fechas obtenidas en el inicio
        //término del préstamo, entonces ahí habría que realizar el cálculo de días.
        setDiasTranscurridos(calcularDiasTranscurridos(prestamo.getFecha().getTime(), getFechaDevolucion().getTime()));

        //A contar después del tope de días se le cobrará una multa por cada día transcurrido
        //Ejemplo, si pasaron 21 días, se pasó 1 día del tope, entonces multa de 1000
        if (getDiasTranscurridos() > TopeDias){
            intMulta = (getDiasTranscurridos() - TopeDias) * 1000;
        }
         
        return intMulta;
    }

    public int getDiasRetraso(){
        //Tope días de estudiante
        int TopeDias = 10;
        int diasRetraso = 0;
        
        if (getPrestamo().obtenerTipoDeUsuario().equals("Docente")){
            //Tope días docente
            TopeDias = 20;
        }

        //A contar después del tope de días se le cobrará una multa por cada día transcurrido
        //Ejemplo, si pasaron 21 días, se pasó 1 día del tope, entonces multa de 1000
        if (getDiasTranscurridos() > TopeDias){
            diasRetraso = (getDiasTranscurridos() - TopeDias);
        }
         
        return diasRetraso;
    }
    
    public int calcularDiasTranscurridos(Date fechaInicio, Date fechaTermino){
        int miliSegundosPorDia = 86400000;
        return (int) (fechaInicio.getTime() - fechaTermino.getTime())/miliSegundosPorDia;
    }
    
    /**
     * @return the multa
     */
    public int getMulta() {
        return multa;
    }

    /**
     * @param multa the multa to set
     */
    public void setMulta(int multa) {
        this.multa = multa;
    }

    /**
     * @return the fechaDevolucion
     */
    public GregorianCalendar getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * @param fechaDevolucion the fechaDevolucion to set
     */
    public void setFechaDevolucion(GregorianCalendar fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * @return the prestamo
     */
    public Prestamo getPrestamo() {
        return prestamo;
    }

    /**
     * @param prestamo the prestamo to set
     */
    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    /**
     * @return the diasTranscurridos
     */
    public int getDiasTranscurridos() {
        return diasTranscurridos;
    }

    /**
     * @param diasTranscurridos the diasTranscurridos to set
     */
    public void setDiasTranscurridos(int diasTranscurridos) {
        this.diasTranscurridos = diasTranscurridos;
    }

    /**
     * Sobreescribe el método toString para desplegar valores personalizados.
     */
    @Override
    public String toString() {
        
        return "Días transcurridos: " + getDiasTranscurridos() + "\t" +
                "Días de retraso: " + getDiasRetraso() + "\t" + 
                "Multa: " + getMulta() + "\t";
    }
}
