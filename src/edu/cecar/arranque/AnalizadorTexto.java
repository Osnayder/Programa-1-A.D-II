/* Clase: AnlizadorTexto
 * 
 * @version: 0.1
 *  
 * @sincelejo: 21/08/2019
 * 
 * Fecha de Modificación: 
 * 
 * @author: Osnayder Conde Rodriguez - Jader José Arcia Baldovino
 * 
 * Copyrigth: CECAR
 */
package edu.cecar.arranque;

import edu.cecar.controlador.FlujoArchivo;
import edu.cecar.controlador.CargarExpresion;
import edu.cecar.controlador.ExcepcionCargarArgumentos;
import edu.cecar.controlador.ProcesarExpresion;
import edu.cecar.modelo.Expresion;
import edu.cecar.modelo.TextoPlano;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AnalizadorTexto {
 
    public static void main(String[] args) {
        System.out.println("\t#======================================================================#"); 
        System.out.println("\t#                        Analizador de Texto NEIRA                     #");
        System.out.println("\t#======================================================================#\n"); 

        
        try {
            CargarExpresion expresion = new CargarExpresion(args);
                if(expresion.isEstadoDeLectura()==1){
                    ProcesarExpresion.iniciarProceso(expresion);
                }
        } catch (ExcepcionCargarArgumentos ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}