/* Interface: UsuarioControlador
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
package edu.cecar.arranque;

import edu.cecar.controlador.FlujoArchivo;
import edu.cecar.controlador.CargarExpresion;
import edu.cecar.controlador.ProcesarDatos;
import edu.cecar.modelo.Expresion;
import edu.cecar.modelo.TextoPlano;


public class AnalizadorTexto {
 
    public static void main(String[] args) {
        System.out.println("\t#======================================================================#"); 
        System.out.println("\t#                        Analizador de Texto NEIRA                     #");
        System.out.println("\t#======================================================================#\n"); 

        CargarExpresion expresion = new CargarExpresion(args);
        if(expresion.isEstadoDeLectura()==1){
           ProcesarDatos.iniciarProceso(expresion);
        }
    }
    
}