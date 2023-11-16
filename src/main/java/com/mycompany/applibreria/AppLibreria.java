/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.applibreria;

import java.util.ArrayList;
import java.util.Arrays;

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
public class AppLibreria {

    
    public static void main(String[] args) {
        //Se genera una lista de usuarios
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        //Se crean y agregan los usuarios nuevos al ArrayList
        usuarios.add(new Docente("11111111-1", "José Jirafales", 'M', "Matemático", "Magíster", usuarios));
        usuarios.add(new Docente("22222222-2", "Juan Pradenas", 'M', "Físico", "Doctor", usuarios));
        usuarios.add(new Docente("33333333-3", "Jhon Smith", 'M', "Ingeniero Metalúrgico", "Enlatado", usuarios));
        usuarios.add(new Estudiante("44444444-4", "Francisco Quijarros", 'M', "Ingeniería en Minas", usuarios));
        usuarios.add(new Estudiante("55555555-5", "Andrea Tesa", 'F', "Matricería", usuarios));
        usuarios.add(new Estudiante("66666666-6", "Jessie Janes", 'F', "Administración de Empresa", usuarios));
        
        //Se editan los atributos básicos del usuario que se piden que se validen
        System.out.println("Se edita primer usuario ingresado.");
        usuarios.get(0).editarUsuario("77777777-7", "Jeanette Rosas", 'F');
        
        //Se muestran los datos del usuario editado
        System.out.println("Datos del usuario editado: " + usuarios.get(0));
        
        System.out.println("Se editan nuevamente los datos del primer usuario ingresado para restaurarlos.");
        //Se editan/restauran los datos básicos originales
        usuarios.get(0).editarUsuario("11111111-1", "José Jirafales", 'M');
        
        //Se vuelve a desplegar para corroborar los datos editados
        System.out.println("Datos del usuario: " + usuarios.get(0));
        System.out.println("");
        
        // GENERAMOS DATOS DE LIBROS BASE
        ArrayList<Libro> libros = new ArrayList<Libro>(
                Arrays.asList(
                        new Libro(1),
                        new Libro(2),
                        new Libro(3),
                        new Libro(4),
                        new Libro(5)
                )
        );
        // UN ARREGLO DE DEVOLUCIONES
        ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
        // GENERAMOS UN PRÉSTAMO
        Prestamo prestamo = Prestamo.ingresarPrestamo(1, "11111111-1", libros, usuarios);
        // AGREGAMOS EL PRÉTAMO AL ARREGLO DE PRÉSTAMOS
        prestamos.add(prestamo);
        // IMPRIMIMOS EL ESTADO ACTUAL DEL PRÉSTAMO
        System.out.println(prestamo.toString());
        // GENERAMOS UNA DEVOLUCION
        Prestamo.ingresarDevolucion(1, "11111111-1", prestamos);
        System.out.println("-----------------------------------------------------------");
        // IMPRIMIMOS EL ESTADO ACTUAL DEL PRÉSTAMO
        System.out.println(prestamo.toString());
    }
}
