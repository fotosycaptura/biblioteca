/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.applibreria;
import java.util.*;

/**
 *
 * @author Tom
 */
public abstract class Usuario {
    private String RUN;
    private String nombre;
    private char genero;
    private int libroPrestamo;
    private Boolean vigente;
    
    public Usuario(String RUN) {
        setRUN(RUN);
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the genero
     */
    public char getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(char genero) {
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
     */
    public void setLibroPrestamo(int libroPrestamo) {
        this.libroPrestamo = libroPrestamo;
    }

    /**
     * @return the vigente
     */
    public Boolean getVigente() {
        return vigente;
    }

    /**
     * @param vigente the vigente to set
     */
    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }
    
}
