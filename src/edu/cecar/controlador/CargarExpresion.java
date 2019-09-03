/** Clase: CargarExpresion
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

import edu.cecar.modelo.Expresion;

public class CargarExpresion {
     private  int estadoCarga = 0;
     private  boolean banderaP=false, banderaS = false;
     private  Expresion expresion = new Expresion();
     
    public CargarExpresion(String[] args) throws ExcepcionCargarArgumentos{
        if(args.length>7 || args.length<=0){ 
            throw new ExcepcionCargarArgumentos("!Ah Sobrepasado El Numero de Argumento Requerido o No Ingreso Ningun Argumento¡"); 
        }else if(args[args.length-1].indexOf(".txt")==-1 ){
           throw new ExcepcionCargarArgumentos("!No Especificó Ruta de Archivo¡"); 
        }
            if( (args.length==1) && ((args[args.length-1].indexOf(".txt")) != -1)){
                        System.out.println("\n\t!Expresion Con Direccion de Archivo Pero sin Argumentos¡\n");
                        expresion.setDirrecionArchivo(args[args.length-1]);
                        expresion.setArgumen3(1);
                        estadoCarga = 1;
            }else if(((args[args.length-1].indexOf(".txt")) != -1)&&(args.length>1)){
                        System.out.println("!Expresion Con Direccion de Archivo y Argumentos¡\n");        
                        expresion.setDirrecionArchivo(args[(args.length-1)]); 
                        estadoCarga = 1;
                        
                        for(int i=0; i<args.length; i++){
                           
                            switch(args[i]){
                                case "-c": 
                                    if(!(args[i+1].equals("-l")) && !(args[i+1].equals("-s")) && !(args[i+1].equals("-d")) && !args[i+1].equals(args[args.length-1])){
                                        expresion.setComando1(args[i]);
                                        expresion.setArgumen1(args[i+1]);
                                        banderaP = true;
                                    }
                                    break;
                                case "-d":
                                    expresion.setComando2(args[i]);
                                    if(this.esNumero(args[i+1])){
                                        expresion.setArgumen2(Integer.parseInt(args[i+1])); 
                                        banderaP = true;
                                    }else{
                                        if(args[i+1].equals("-l") || args[i+1].equals("-s") || args[i+1].equals("-d") || args[i+1].equals("-c") || (args[i+1].indexOf(".txt")!=-1)){
                                            expresion.setArgumen2(1);
                                            banderaP = true;
                                        }else{
                                            banderaS = true;
                                        }
                                    }
                                    break;
                                case "-l":
                                    expresion.setComando3(args[i]);
                                    if(this.esNumero(args[i+1])){
                                        expresion.setArgumen3(Integer.parseInt(args[i+1]));
                                        banderaP = true;
                                    }else{
                                        if(args[i+1].equals("-l") || args[i+1].equals("-s") || args[i+1].equals("-d") || args[i+1].equals("-c") || (args[i+1].indexOf(".txt")!=-1)){
                                            expresion.setArgumen3(1);
                                            banderaP = true;
                                        }else{
                                            banderaS = true;
                                        }
                                    }
                                    break;
                                case "-s":
                                    expresion.setComando3(args[i]);
                                    if(this.esNumero(args[i+1])){
                                        expresion.setArgumen3(Integer.parseInt(args[i+1])); 
                                        banderaP = true;
                                    }else{
                                        if(args[i+1].equals("-l") || args[i+1].equals("-s") || args[i+1].equals("-d") || args[i+1].equals("-c") || (args[i+1].indexOf(".txt")!=-1)){
                                            expresion.setArgumen3(1);
                                            banderaP = true;
                                        }else{
                                            banderaS = true;
                                        }
                                    }
                                  break;
                                default:
                                    if(!this.esNumero(args[i]) && !args[i-1].equals("-c") && i<(args.length-2)){
                                       throw new ExcepcionCargarArgumentos("!Upss¡ Introdujo Argumentos Invalidos"); 
                                    }
                            }
                        } 
                if((banderaP!=true) || banderaS){
                    throw new ExcepcionCargarArgumentos("!Upss¡ Introdujo Argumentos Invalidos");
                }                    
            }else if(((args[args.length-1].indexOf(".txt")) == -1)&&(args.length>1)){
                 estadoCarga = -1;
            }
    }
    
    public  Expresion getExpresion() {
        return expresion;
    }

    public int isEstadoDeLectura() {
        return estadoCarga;
    }
    
    public void getArgumentosCargados(){
        if(estadoCarga==1){
            System.out.println("!Expresión Cargada de Manera Exitosa¡"+"\n"+
            "Comando 1: "+expresion.getComando1()+", Argumento 1: "+expresion.getArgumen1()+"\n"+
            "Comando 2: "+expresion.getComando2()+", Argumento 2: "+expresion.getArgumen2()+"\n"+
            "Comando 3: "+expresion.getComando3()+", Argumento 3: "+expresion.getArgumen3()+"\n"+
            "-------------------------------------------\n"+"Ruta del Archivo: "+expresion.getDirrecionArchivo()+"\n"+
            "-------------------------------------------\n");
        }else if(estadoCarga==-1){
            System.out.println("Error: !Se Intento Cargar La Expresion Pero Ubieron Argumentos Incorrectos");
        }
    }
    
    public boolean getEstadoLectura3Comando(){
       if(this.expresion.getEstadoComando1() && this.expresion.getEstadoComando2() && this.expresion.getEstadoComando3()){
           return true;
       }
        return false;
    }
    public boolean esNumero(String cadena){
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
}
