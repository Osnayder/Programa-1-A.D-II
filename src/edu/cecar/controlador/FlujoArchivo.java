/** Clase: FlujoArchivo
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

package edu.cecar.controlador;

import edu.cecar.modelo.TextoPlano;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FlujoArchivo {
    
    public static void flujoSalida(TextoPlano textoplano) throws ExcepcionGuardarArchivo{
        if(textoplano==null){
             throw new ExcepcionGuardarArchivo("!No se Definio El Archivo a Guardar¡"); 
        }
        
       try {
            PrintWriter writer = new PrintWriter(textoplano.getRuta()+"AnaTex.txt", "UTF-8");
            writer.print(textoplano.getTexto());
            writer.close();
            System.out.println("Se guardo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String flujoEntrada(String ruta) throws ExcepcionArchivoNoCargado{
        String texto = "";
        String linea = "";
        try {
            FileReader archivo =  new FileReader(ruta);
            BufferedReader contenido = new BufferedReader(archivo);
            try {
                while((linea=contenido.readLine())!=null ){
                     texto = texto + linea + "\n";
                }
            } catch (IOException ex) {
                System.out.print(ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
            texto = null;
        }
        
        if(texto==null){
            throw new ExcepcionArchivoNoCargado();
        }
        return texto;
    }
}