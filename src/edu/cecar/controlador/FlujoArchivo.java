package edu.cecar.controlador;

import edu.cecar.modelo.TextoPlano;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osnayder
 */
public class FlujoArchivo {
    
    public static void flujoSalida(TextoPlano textoplano){
       try {
            PrintWriter writer = new PrintWriter(textoplano.getRuta()+"RES", "UTF-8");
            writer.print(textoplano.getTexto());
            writer.close();
            System.out.println("Se guardo de manera exitosa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String flujoEntrada(String ruta){
        String texto = "";
        String linea = "";
        try {
            FileReader archivo =  new FileReader(ruta);
            BufferedReader contenido = new BufferedReader(archivo);
  
            try {
                while((linea=contenido.readLine())!=null ){
                     texto = texto + linea + "\n";
                }
                return texto;
                
            } catch (IOException ex) {
                Logger.getLogger(FlujoArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());

        }
        return null;
    }
}