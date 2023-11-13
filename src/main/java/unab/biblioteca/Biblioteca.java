/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package unab.biblioteca;


/**
 *
 * @author xavie
 */
public class Biblioteca {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Estudiante alumno = new Estudiante(123456, "Kiko", 'M', "Vendedor de pomada");
        alumno.setVigente(true);
        
        System.out.println(alumno);
        
        Docente profe = new Docente(123456, "Kiko", 'M', "Arquitecto de SW", "Magister");
        profe.setVigente(true);
        
        System.out.println(profe.toString());
    }
}
