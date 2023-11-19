/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.applibreria;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

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
public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private GregorianCalendar fecha;
    private int dias;
    private Devolucion devolucion;
    
    // DEBE COMPLETAR ESTE CONSTRUCTOR
    public Prestamo(Usuario usuario, Libro libro) {
        setUsuario(usuario);
        setLibro(libro);
    }
    
    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the libro
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * @param libro the libro to set
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * @return the fecha
     */
    public GregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the devolucion
     */
    public Devolucion getDevolucion() {
        return devolucion;
    }

    /**
     * @param devolucion the devolucion to set
     */
    public void setDevolucion(Devolucion devolucion) {
        this.devolucion = devolucion;
    }
    
    public String obtenerTipoDeUsuario() {
        if (getUsuario() instanceof Docente) {
            return "Docente";
        }
       
        return "Estudiante";
    }
    
    // SOLICITO LOS PARÁMETROS DE ENTRADA DE LA DEVOLUCIÓN
    public void asignarDevolucion(GregorianCalendar fechaDevolucion, Prestamo prestamo, ArrayList<Usuario> usuarios, ArrayList<Libro> libros) {
        
        Devolucion devolucion = new Devolucion(fechaDevolucion, prestamo);
        // Se asigna la devolución respetando la relación de composición
        // Debido a que devolución se instancia dentro del objeto y no por fuera
        setDevolucion(devolucion);
        
        // TENGO QUE HABILITAR AL USUARIO
        Usuario usuarioALiberar = Usuario.verUsuario(prestamo.getUsuario().getRUN(), usuarios);
        usuarioALiberar.setLibroPrestamo(0);
        
        // TENGO QUE AUMENTAR EL STOCK DISPONBILE Y DISMINUIR EL STOCK ASIGNADO
        Libro libroAReponer = Libro.verLibro(prestamo.getLibro().getISBN(), libros);
        libroAReponer.setCantidadDisponiblePrestamo(libroAReponer.getCantidadDisponiblePrestamo() + 1);
        
        // TENGO QUE COBRAR MULTA SI ES QUE CORRESPONDE
        //Lo muestro en la impresión de la ficha
//        if (devolucion.getMulta() > 0){
//            System.out.println("El " + obtenerTipoDeUsuario() + " debe de pagar multa por haber transcurrido " + devolucion.getDiasTranscurridos() + " días. $1000 pesos por cada día extra transcurrido.");
//            System.out.println("La multa es de: $" + devolucion.getMulta() + " pesos.");
//        }
        
        
    }
    
    public static Prestamo ingresarPrestamo(int ISBN, String RUN, int dias, ArrayList<Libro> libros, ArrayList<Usuario> usuarios) {
        // ASIGNO UNA VARIABLE CON VALOR A LO QUE RETORNE EL MÉTODO BUSCARLIBRO
        //Ejem, se busca el libro en el ArrayList y se obtiene si existe.
        Libro libro = buscarLibro(ISBN, libros);
        
        // Se valida si realmente se encontró
        if (libro == null) {
            throw new IllegalArgumentException("El libro a buscar no existe.");
        }
        
        // ASIGNO UNA VARIABLE CON VALOR A LO QUE RETORNE EL MÉTODO BUSCARUSUARIO
        //Se busca si existe el alumno o docente en el ArrayList
        Usuario usuario = buscarUsuario(RUN, usuarios);
        
        // SI EL USUARIO ES NULO, ES PORQUE NO LO HE ENCONTRADO
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario a buscar no existe.");
        }
        
        // EN ESTE PUNTO, YA SABEMOS QUE EL USUARIO Y EL LIBRO YA EXISTEN
        // AHORA DEBEMOS REALIZAR LAS VALIDACIONES
        
        // AQUÍ VALIDAMOS QUE EL LIBRO TENGA COMO MÍNIMO UN EJEMPLAR //
        if (libro.getCantidadDisponiblePrestamo() == 0){
            throw new IllegalArgumentException("No hay suficientes copias para préstamo de este libro.");
        }
        
        // AQUÍ VALIDAMOS QUE EL USUARIO DEBA ESTAR HABILTIADO PARA EL PRÉSTAMO //
        if (usuario.getLibroPrestamo() > 0){
            throw new IllegalArgumentException("Este usuario ya tiene un libro en calidad de préstamo asignado.");
        }
        
        // UNAS VEZ GENERADA TODAS LAS VALIDACIONES
        
        // GENERAMOS UNA INSTANCIA DE PRÉSTAMO
        Prestamo prestamo = new Prestamo(usuario, libro);
        // ---------------- LO QUE SE DEBE HACER A CONTINUACIÓN SE PUEDE REALIZAR DENTRO DE ÉSTE MÉTODO Ó ----------------
        // ----------------------------- DENTRO DE LA INSTANCIACIÓN DEL OBJETO -------------------------------------------
        // REDUCIMOS LA CANTIDAD DISPONIBLE DEL LIBRE Y AUMENTAMOS LA CANTIDAD EN USO
        // DEJAMOS AL USUARIO NO DISPONIBLE PARA EL NUEVO PRÉSTAMO
        
        //Se toma el libro y se le pasa al estudiante/docente, osea, se resta 1 a la existencia disponible de prestamos
        prestamo.getLibro().setCantidadDisponiblePrestamo(prestamo.getLibro().getCantidadDisponiblePrestamo() -1);
        
        //Se establece el préstamo en sí 
        prestamo.getUsuario().setLibroPrestamo(prestamo.getLibro().getISBN());
        
        GregorianCalendar fechaActual = new GregorianCalendar();
        
        prestamo.setFecha(fechaActual);
        
        prestamo.setDias(dias);
        
        // RETORNAMOS EL PRÉSTAMO VALIDADOs
        return prestamo;
    }
    
    public static void ingresarDevolucion(int ISBN, String RUN, ArrayList<Prestamo> prestamos, ArrayList<Libro> libros, ArrayList<Usuario> usuarios) {
        // EN BASE A LA GUÍA, DEBEMOS VALIDAR QUE EXISTA EL LIBRO Y EL USUARIO
        
        //Se realiza la búsqueda del libro en el array de libros
        Libro libro = buscarLibro(ISBN, libros);
        if (libro == null){
            throw new IllegalArgumentException("El libro a buscar no existe.");
        }
        
        //Se realiza la búsqueda del usuario en el Array de usuarios
        Usuario usuario = buscarUsuario(RUN, usuarios);
        if (usuario == null){
            throw new IllegalArgumentException("El usuario a buscar no existe.");
        }
        
        //Ambos existen, ahora se busca en préstamo
        Prestamo prestamo = buscarPrestamo(ISBN, RUN, prestamos);
        // SI EL PRÉTAMO ES NULO, ES PORQUE NO LO HE ENCONTRADO
        if (prestamo == null) {
            throw new IllegalArgumentException("El prestamo a buscar no existe.");
        }
        
        /* Se genera la fecha de devolución. En un caso normal, esta fecha se debería de capturar del sistema o permitir el ingreso
        del usuario y en base a eso, se debería de calcular la cantidad de días transcurridos y ahí realizar el cálculo después para 
        el total a pagar en multas si es que hubiera tal caso.
        Como en esta tarea se agregó el número de días al momento de generar el arriendo, creo que lo lógico sería sumar esa cantidad de días 
        a la fecha actual para simular la fecha de devolución.
        */
        
        GregorianCalendar fechaDevolucion = new GregorianCalendar();
        fechaDevolucion.add(fechaDevolucion.DAY_OF_MONTH, prestamo.getDias());
        
        // UNA VEZ GENERADAS TODAS LAS VALIDACIONES, EJECUTAMOS EL MÉTODO ASIGNAR DEVOLUCIÓN
        prestamo.asignarDevolucion(fechaDevolucion, prestamo, usuarios, libros);
    }
    
    public static Libro buscarLibro(int ISBN, ArrayList<Libro> libros) {
        // BUSCO EL LIBRO EN EL ARREGLO DE LIBROS
        for (int i = 0; i < libros.size(); i++) {
            // VOY OBTENIENDO CADA LIBRO EN EL ARREGLO DE LIBROS
            Libro libro = libros.get(i);
            
            // PREGUNTO SI EL ISBN DEL LIBRO ES IGUAL AL LIBRO QUE BUSCO
            if (libro.getISBN() == ISBN) {
                // SI LO ENCUENTRO, LO RETORNO
                return libro;
            }
        }
        
        // SI NO LO ENCUENTRO, RETORNO UN NULL
        return null;
    }
    
    public static Usuario buscarUsuario(String RUN, ArrayList<Usuario> usuarios) {
        // BUSCO EL LIBRO EN EL ARREGLO DE USUARIOS
        for (int i = 0; i < usuarios.size(); i++) {
            // VOY OBTENIENDO CADA USUARIO EN EL ARREGLO DE USUARIOS
            Usuario usuario = usuarios.get(i);
            
            // PREGUNTO SI EL RUT DEL USUARIO ES IGUAL AL RUN QUE BUSCO
            if (usuario.getRUN().equals(RUN)) {
                // SI LO ENCUENTRO, LO RETORNO
                return usuario;
            }
        }
        
        // SI NO LO ENCUENTRO, RETORNO UN NULL
        return null;
    }
    
    /**
     * Se busca el préstamo mediante el ISBN y el RUN
     * Se valida que el usuario haya solicitado ese libro
     * @param ISBN
     * @param RUN
     * @param prestamos
     * @return 
     */
    public static Prestamo buscarPrestamo(int ISBN, String RUN, ArrayList<Prestamo> prestamos) {
        // BUSCO EL PRESTAMO EN EL ARREGLO DE PRESTAMOS
        for (int i = 0; i < prestamos.size(); i++) {
            // VOY OBTENIENDO CADA PRESTAMO EN EL ARREGLO DE PRESTAMO
            Prestamo prestamo = prestamos.get(i);
            
            //Se verifica si el ISBN y el usuario existen en el préstamo
            if (prestamo.getUsuario().getRUN().equals(RUN) && prestamo.getLibro().getISBN() == ISBN) {
                //Se encontró usuario en array, pero falta ver si libro y usuario
                //coinciden en el préstamo...
                if (prestamo.getUsuario().getLibroPrestamo() != ISBN){
                    throw new IllegalArgumentException("Este usuario no solicitó este préstamo.");
                }
                //Al encontrarse, se retorna el obj préstamo
                return prestamo;
            }
        }
        
        // SI NO LO ENCUENTRO, RETORNO UN NULL
        return null;
    }
    
    /**
     * @return the dias
     */
    public int getDias() {
        return dias;
    }

    /**
     * @param dias the dias to set
     */
    public void setDias(int dias) {
        if (dias <= 0){
            throw new IllegalArgumentException("Debe de ingresar un número de días de préstamo mayor que 0.");
        }
        
        this.dias = dias;
    }
    
    @Override
    public String toString() {
        // GENERAMOS UN ESTADO BASE
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        fmt.setCalendar(getFecha());
        String fechaFormateada = fmt.format(getFecha().getTime());
        
        String estadoBase = "Prestamo: \n" + 
                "ISBN: " + getLibro().getISBN() + "\t" +
                "RUN: " + getUsuario().getRUN() + "\t" +
                "Arrendado por: " + obtenerTipoDeUsuario() + "\t" + 
                "Fecha: " + fechaFormateada + "\t" +
                "Días en préstamo: " + getDias() + "\t" +
                "Estado: ";
        
        // LO MODIFICAMOS EN BASE A LA DEVOLUCIÓN
        if (getDevolucion() == null) {
            estadoBase += "En préstamo.";
        } else {
            estadoBase += "Devuelto.";
        }
        
        return estadoBase;
    }
    
    /**
     * Se encarga de imprimir la tarjeta de préstamo
     */
    public void imprimirTarjetaPrestamo(){

        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        fmt.setCalendar(getFecha());
        String fechaFmtPrestamo = fmt.format(getFecha().getTime());
        String fechaFmtDevolucion = "";
        String estadoPrestamo = "En prestamo";
        String comentariosMulta = "";
        if (getDevolucion() != null){
             fechaFmtDevolucion = fmt.format(getDevolucion().getFechaDevolucion().getTime());
             estadoPrestamo = "Devuelto";
             comentariosMulta = getDevolucion().toString();
        }
        
        for(int i=0; i < 80; i++){
            System.out.print("=");
        }
        System.out.println("");
        System.out.println("                      Tarjeta de Préstamo");
        System.out.println("");
        System.out.println("                        ISBN           : " + getLibro().getISBN());
        System.out.println("                        Libro          : " + getLibro().getTitulo());
        System.out.println("                        Autor          : " + getLibro().getAutor());
        System.out.println("                        Estado         : " + estadoPrestamo);
        System.out.println("");
        System.out.println("Fecha Préstamo           Estudiante/Docente                        Días            Fecha Devolución");
        
        for(int i=0; i < 80; i++){
            System.out.print("-");
        }
        System.out.println("");
        System.out.println(fechaFmtPrestamo + "      " + "[" + obtenerTipoDeUsuario() + "]" + getUsuario().getRUN() + "/" + getUsuario().getNombre() + "       " + getDias() + " días" + "          " + fechaFmtDevolucion);
        System.out.println("");
        System.out.println("Comentarios: " + comentariosMulta);
        
        for(int i=0; i < 80; i++){
            System.out.print("=");
        }
        System.out.println("");
    }
}
