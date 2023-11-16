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
        
        //Se editan los datos de un docente que ya existe.
        System.out.println("Se edita primer usuario ingresado.");
        Docente docAModifi = new Docente("77777777-7", "Jeanette Rosas", 'F', "Docente", "Magíster", usuarios);
        
        if (Usuario.editarUsuario("11111111-1", docAModifi, usuarios)){
            System.out.println("Usuario editado correctamente.");
        }else{
            System.out.println("Usuario no encontrado. No se pudo editar el usuario.");
        }
        
        //Se muestran los datos del usuario editado
        System.out.println("Datos del usuario editado: " + Usuario.verUsuario(docAModifi.getRUN(), usuarios));
        
        System.out.println("Se editan nuevamente los datos del primer usuario ingresado para restaurarlos.");
        
        //Se editan/restauran los datos básicos originales
        docAModifi = new Docente("11111111-1", "José Jirafales", 'M', "Matemático", "Magíster", usuarios);
        
        if (Usuario.editarUsuario("77777777-7", docAModifi, usuarios)){
            System.out.println("Usuario editado correctamente.");
        }else{
            System.out.println("Usuario no encontrado. No se pudo editar el usuario.");
        }
        
        //Se vuelve a desplegar para corroborar los datos editados
        System.out.println("Datos del usuario nuevamente editado: " + Usuario.verUsuario(docAModifi.getRUN(), usuarios));
        System.out.println("");
        System.out.println("Se intenta eliminar un usuario...");
        //Sección de eliminar usuario, si es que existe        
        if (Usuario.eliminar("88888888-8", usuarios)){
            System.out.println("Se eliminó el usuario.");
        }else{
            System.out.println("No pudo ser eliminado. Usuario no encontrado.");
        }

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
