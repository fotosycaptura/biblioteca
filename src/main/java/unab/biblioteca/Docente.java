/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unab.biblioteca;

/**
 *
 * @author xavie
 */
public class Docente extends Usuario {
    private String gradoAcademico;
    private String profesion;
    
    public Docente(int run, String nombre, char genero, String profesion, String grado) {
        super(run, nombre, genero);
        this.profesion = profesion;
        this.gradoAcademico = grado;
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
        this.gradoAcademico = gradoAcademico;
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
        this.profesion = profesion;
    }
    
    /**
     * Sobreescribe el método toString para desplegar valores personalizados.
     */
    @Override
    public String toString() {
        return "Run: " + getRun() + "\t" +
                "Nombre: " + getNombre() + "\t" +
                "Profesión: " + getProfesion() + "\t" +
                "Grado Académico: " + getGradoAcademico() + "\t" +
                "Estado: " + getVigente();
    }
}
