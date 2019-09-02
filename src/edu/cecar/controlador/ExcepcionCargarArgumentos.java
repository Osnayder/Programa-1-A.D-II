/** Clase: ExcepcionCargarArgumentos
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

package edu.cecar.controlador;

public class ExcepcionCargarArgumentos extends Exception{
    public ExcepcionCargarArgumentos(){ this(""); }
    
    public ExcepcionCargarArgumentos(String arg){
        super(arg);
    }
}
