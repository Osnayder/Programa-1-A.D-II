package edu.cecar.controlador;

/** Interface: UsuarioControlador
 * 
 * @version: 0.1
 *  
 * @sincelejo: 21/08/2019
 * 
 * Fecha de Modificación: 
 * 
 * @author: Osnayder Conde Rodriguez
 * 
 * Copyrigth: CECAR
 */
public class ExcepcionArchivoNoCargado extends Exception{
    public ExcepcionArchivoNoCargado(){
        this("\n!El Analizador No Pudo Cargar El Archivo¡");
    }
    
    public ExcepcionArchivoNoCargado(String args){
        super("\n!El Analizador No Pudo Cargar El Archivo¡");
    }
}