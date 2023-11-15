/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.applibreria;

/**
 *
 * @author Tom
 */
public class Estudiante extends Usuario {
    private String carrera;
    // GENERAMOS DATOS DE USUARIOS BASE
    public Estudiante(String RUN) {
        super(RUN);
    }
    
    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    /**
     * Sobreescribe el método toString para desplegar valores personalizados.
     */
    @Override
    public String toString() {
        return "Run: " + getRUN() + "\t" +
                "Nombre: " + getNombre() + "\t" +
                "Carrera: " + getCarrera() + "\t" +
                "Estado: " + getVigente();
    }
}
