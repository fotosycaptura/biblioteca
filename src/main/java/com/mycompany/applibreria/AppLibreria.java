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
        // GENERAMOS DATOS DE USUARIOS BASE
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(new Docente("11111111-1", usuarios));
        usuarios.add(new Docente("22222222-2", usuarios));
        usuarios.add(new Docente("33333333-3", usuarios));
        usuarios.add(new Estudiante("44444444-4", usuarios));
        usuarios.add(new Estudiante("55555555-5", usuarios));
        usuarios.add(new Estudiante("66666666-6", usuarios));
        
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
