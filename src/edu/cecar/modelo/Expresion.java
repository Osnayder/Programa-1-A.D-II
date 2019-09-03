/* Clase: Expresion
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
package edu.cecar.modelo;


public class Expresion {
    
    private String comando1;
    private String argumen1;
    private String comando2;
    private int argumen2 = -1;
    private String comando3;
    private int argumen3 = -1;
    private String dirrecionArchivo;
    
    public Expresion(){}
    
    public String getComando1() {
        return comando1;
    }

    public void setComando1(String comando1) {
        this.comando1 = comando1;
    }

    public String getArgumen1() {
        return argumen1;
    }

    public void setArgumen1(String argumen1) {
        this.argumen1 = argumen1;
    }

    public String getComando2() {
        return comando2;
    }

    public void setComando2(String comando2) {
        this.comando2 = comando2;
    }

    public int getArgumen2() {
        return argumen2;
    }

    public void setArgumen2(int argumen2) {
        this.argumen2 = argumen2;
    }

    public String getComando3() {
        return comando3;
    }

    public void setComando3(String comando3) {
        this.comando3 = comando3;
    }

    public int getArgumen3() {
        return argumen3;
    }

    public void setArgumen3(int argumen3) {
        this.argumen3 = argumen3;
    }

    public String getDirrecionArchivo() {
        return dirrecionArchivo;
    }

    public void setDirrecionArchivo(String dirrecionArchivo) {
        this.dirrecionArchivo = dirrecionArchivo;
    }

    public boolean getEstadoComando1() {
        if(this.comando1==null){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean getEstadoComando2() {
        if(this.comando2==null){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean getEstadoComando3() {
        if(this.comando3==null){
            return false;
        }else{
            return true;
        }
    }
    
    
    
}
