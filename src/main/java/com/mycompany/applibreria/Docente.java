/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.applibreria;

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
public class Docente extends Usuario {
    private String gradoAcademico;
    private String profesion;
    
    public Docente(String RUN) {
        super(RUN);
    }
    
    /**
     * @return the gradoAcademico
     */
    public String getGradoAcademico() {
        return gradoAcademico;
    }

    /**
     * @param gradoAcademico the gradoAcademico to set
     */
    public void setGradoAcademico(String gradoAcademico) {
        if (gradoAcademico != null && gradoAcademico.length() > 0){
            this.gradoAcademico = gradoAcademico;
        }else{
            throw new IllegalArgumentException("ERROR: Debe de ingresar un grado académico."); 
        }
        
    }

    /**
     * @return the profesion
     */
    public String getProfesion() {
        return profesion;
    }

    /**
     * @param profesion the profesion to set
     */
    public void setProfesion(String profesion) {
        if (profesion != null && profesion.length() > 0){
            this.profesion = profesion;
        }
        else{
            throw new IllegalArgumentException("ERROR: Debe de ingresar una profesión."); 
        }
        
    }
    
    /**
     * Sobreescribe el método toString para desplegar valores personalizados.
     */
    @Override
    public String toString() {
        return "Run: " + getRUN() + "\t" +
                "Nombre: " + getNombre() + "\t" +
                "Profesión: " + getProfesion() + "\t" +
                "Grado Académico: " + getGradoAcademico() + "\t";
    }
}
