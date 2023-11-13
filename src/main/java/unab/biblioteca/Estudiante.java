/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unab.biblioteca;

/**
 *
 * @author xavie
 */
public class Estudiante extends Usuario {
    private String carrera;
    public Estudiante(int run, String nombre, char genero, String carrera) {
        super(run, nombre, genero);
        this.carrera = carrera;
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
        return "Run: " + getRun() + "\t" +
                "Nombre: " + getNombre() + "\t" +
                "Carrera: " + getCarrera() + "\t" +
                "Estado: " + getVigente();
    }
}
