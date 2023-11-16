/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.applibreria;
import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public abstract class Usuario {
    //Permitirá almacenar el Run del usuario
    private String RUN;
    //Permitirá almacenar el nombre del usuario
    private String nombre;
    //Permitirá establecer el género. (M o F)
    private char genero;
    //Sevirá de estado "vigente" en el sentido de si
    //Tiene un número mayor a 0, no se le podrá prestar libros
    private int libroPrestamo;
    
    /**
     * Constructor. Que hará las veces también de "Crear Usuario"
     * @param RUN
     * @param nombre
     * @param genero
     * @param usuarios 
     */
    public Usuario(String RUN, String nombre, char genero, ArrayList<Usuario> usuarios) {
        //Se busca ese rut en el ArrayList de usuarios
        if (encontrarUsuario(RUN, usuarios)){
            throw new IllegalArgumentException("El usuario que intenga ingresar ya existe");
        }
        
        setRUN(RUN);
        setNombre(nombre);
        setGenero(genero);
    }
    
   /**
    * Método encargado de editar el usuario
    * @param RUN
    * @param usuario
    * @param usuarios
    * @return 
    */
    public static Boolean editarUsuario(String RUN, Usuario usuario, ArrayList<Usuario> usuarios){
        int indice = -1;
        for (int i=0; i < usuarios.size(); i++){
            if (usuarios.get(i).getRUN().equals(RUN)){
                indice = i;
                break;
            }
        }
        
        if (indice >= 0){
            //Se extrae el elemento del ArrayList
            Usuario usuarioAModificar = (Usuario)usuarios.get(indice);
            
            //Se establecen los valores los valores
            usuarioAModificar.setRUN(usuario.getRUN());
            usuarioAModificar.setNombre(usuario.getNombre());
            usuarioAModificar.setGenero(usuario.getGenero());
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * @return the RUN
     */
    public String getRUN() {
        return RUN;
    }

    /**
     * @param RUN the RUN to set
     */
    public void setRUN(String RUN) {
        //Se pide validación de cedula. largo máximo 10
        //Estilo xxxxxxxx-d
        //Donde xxxxxxxx es una parte entera y d es un número de 0 a 9 o k
        
        if (RUN != null && RUN.length() == 10){
            //Se debe de dividir en dos partes y realizar validación
            StringTokenizer stk = new StringTokenizer(RUN, "-");
            if (stk.countTokens() == 2){
                String conversor = new String(stk.nextToken());
                int rutNumerico = Integer.parseInt(conversor);
                char chrDigito = stk.nextToken().charAt(0);
                //Se valida si el digito verificaro es correcto
                if (ValidarDigitoVerificador(rutNumerico).equals(String.valueOf(chrDigito).toUpperCase())){
                    this.RUN = RUN;
                }else{
                    throw new IllegalArgumentException("Cédula de cliente inválida. Posiblemente dígito verificador no válido.");       
                }
            }else{
                throw new IllegalArgumentException("Cédula de cliente inválida. Posiblemente no se incluyó el guión");   
            }
        }else{
             throw new IllegalArgumentException("Cédula de cliente inválida. No posee el largo de 10 caracteres");
        }
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        if (nombre != null && nombre.length() > 0){
            this.nombre = nombre;
        }else{
            throw new IllegalArgumentException("Nombre inválido. Por favor ingrese un nombre!");
        }
    }

    /**
     * @return the genero
     */
    public char getGenero() {
        return genero;
    }

    /**
     * @param genero Establece el género del usuario, en M o F, de Masculino
     * o Femenino respectivamente
     */
    public void setGenero(char genero) {
        if (genero != 'M' && genero != 'F') {
            throw new IllegalArgumentException("El género es incorreto. Solo indique: M para masculino, F para femenino.");
        }
        
        this.genero = genero;
    }

    /**
     * @return the libroPrestamo
     */
    public int getLibroPrestamo() {
        return libroPrestamo;
    }
    
    /**
     * @param libroPrestamo the libroPrestamo to set
     * Se setea un libro si es que libroPrestamo está en 0
     */
    public void setLibroPrestamo(int libroPrestamo) {
        if (getLibroPrestamo() != 0){
            throw new IllegalArgumentException("Este usuario ya tiene un libro en préstamo");
        }
        
        this.libroPrestamo = libroPrestamo;
    }
    
    /**
     * Método encargado de validar la existencia de un RUN en un ArrayList de usuarios.
     * Si el RUN es encontrado, retornará true
     * @param RUN
     * @param usuarios
     * @return 
     */
    public static Boolean encontrarUsuario(String RUN, ArrayList<Usuario> usuarios){
        for (Usuario usuario: usuarios){
            if (usuario.getRUN().equals(RUN)){
                return true;
            }
        }
        return false;
    }

    /**
     * Se encarga de obtener el dígito verificador de un rut.
     * Se utiliza para obtenerlo - generarlo - o para la comparación en un if
     * @param rut
     * @return 
     */
    private String ValidarDigitoVerificador(int rut)
    {
        int Digito;
        int Contador;
        int Multiplo;
        int Acumulador;
        String RutDigito;

        Contador = 2;
        Acumulador = 0;

        while (rut != 0)
        {
            Multiplo = (rut % 10) * Contador;
            Acumulador = Acumulador + Multiplo;
            rut = rut / 10;
            Contador = Contador + 1;
            if (Contador == 8)
            {
                Contador = 2;
            }
        }

        Digito = 11 - (Acumulador % 11);
        RutDigito = Integer.toString(Digito);
        if (Digito == 10)
        {
            RutDigito = "K";
        }
        if (Digito == 11)
        {
            RutDigito = "0";
        }
        return (RutDigito);
    }
    
    /**
     * Método que elimina un usuario de un ArrayList. 
     * Busca por intermedio del RUN para verificar que exista, y en caso de
     * ser encontrado, se elimina del ArrayList, retornando true
     * En caso de no ser encontrado, retorna false
     * @param RUN
     * @param usuarios
     * @return 
     */
    public static Boolean eliminar(String RUN, ArrayList<Usuario> usuarios){
        int indice = -1;
        for (int i=0; i < usuarios.size(); i++){
            if (usuarios.get(i).getRUN().equals(RUN)){
                indice = i;
                break;
            }
        }
        
        if (indice >= 0){
            usuarios.remove(indice);
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Método que obtiene un usuario dado el RUN especificado
     * @param RUN
     * @param usuarios
     * @return 
     */
    public static Usuario verUsuario(String RUN, ArrayList<Usuario> usuarios){
        for (Usuario usuario: usuarios){
            if (usuario.getRUN().equals(RUN)){
                return usuario;
            }
        }
        return null;
    }
    
}
