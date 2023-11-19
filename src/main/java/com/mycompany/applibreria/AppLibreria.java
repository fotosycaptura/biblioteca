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
        ArrayList<Libro> libros = new ArrayList<Libro>();
        libros.add(new Libro(1, "El señor de los anillos", "Tolkien", 10, 5, "portada01.jpg", libros));
        libros.add(new Libro(2, "Las dos torres", "Tolkien", 10, 5, "portada02.jpg", libros));
        libros.add(new Libro(3, "El retorno del rey", "Tolkien", 10, 5, "portada03.jpg", libros));
        libros.add(new Libro(4, "El Hobbit", "Tolkien", 10, 5, "portada04.jpg", libros));
        libros.add(new Libro(5, "Sir Marilión", "Tolkien", 10, 5, "portada05.jpg", libros));
        
        System.out.println("Libros existentes en la biblioteca en total: " + libros.size());
        //Se elimina un libro
        if (Libro.eliminar(5, libros)){
            System.out.println("Libro eliminado exitosamente");
        }else{
            System.out.println("Libro no pudo ser eliminado");
        }
        
        System.out.println("Libros existentes en la biblioteca en total: " + libros.size());
        
        // UN ARREGLO DE Préstamos
        ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
        
        System.out.println("Visualizando libro a prestar: " + Libro.verLibro(1, libros));
        
        // GENERAMOS UN PRÉSTAMO
        Prestamo prestamo = Prestamo.ingresarPrestamo(1, "11111111-1", 27, libros, usuarios);
        
        //Se generan otros préstamos
        Prestamo prestamo2 = Prestamo.ingresarPrestamo(2, "44444444-4", 5, libros, usuarios);
        Prestamo prestamo3 = Prestamo.ingresarPrestamo(4, "55555555-5", 7, libros, usuarios);
        
        //Se visualiza si se llevó a cabo el descuento de disponibles para préstamo por haberlo prestado.
        System.out.println("Visualizando libro a ver si se prestó o no: " + Libro.verLibro(1, libros));
        
        // AGREGAMOS EL PRÉTAMO AL ARREGLO DE PRÉSTAMOS
        prestamos.add(prestamo);
        prestamos.add(prestamo2);
        prestamos.add(prestamo3);
        
        
        // IMPRIMIMOS EL ESTADO ACTUAL DEL PRÉSTAMO
        prestamo.imprimirTarjetaPrestamo();
        
        System.out.println("Se realiza una devolución");
        // GENERAMOS UNA DEVOLUCION
        Prestamo.ingresarDevolucion(1, "11111111-1", prestamos, libros, usuarios);
        System.out.println("-----------------------------------------------------------");
        
        //se imprime nuevamente la tarjeta para ver diferencias ya una vez devuelto el libro
        prestamo.imprimirTarjetaPrestamo();
    }
}
