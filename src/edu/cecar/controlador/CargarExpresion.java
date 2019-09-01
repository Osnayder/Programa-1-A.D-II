package edu.cecar.controlador;

import edu.cecar.modelo.Expresion;
import edu.cecar.modelo.TextoPlano;


public class CargarExpresion {
     private  int estadoCarga = 0; // Define si la expresion fue cargada de manera exitosa: Estados {-1,0,1}
     private  boolean[] bandera = {false,false};
     private  boolean banderaP=false;
     private  Expresion expresion = new Expresion();
     
    public CargarExpresion(String[] args) throws ErrorDeArgumentos{
        if(args.length>=0 || args.length<=0){
            throw new ErrorDeArgumentos();
        }
        
        //if((args.length>0) && (args.length<=7)){
            if( (args.length==1) && ((args[args.length-1].indexOf(".txt")) != -1)){
                        System.out.println("!Expresion Con Direccion de Archivo Pero sin Argumentos¡");
                        expresion.setDirrecionArchivo(args[args.length-1]);
                        estadoCarga = 1;
            }else if(((args[args.length-1].indexOf(".txt")) != -1)&&(args.length>1)){   //OJO aqui         
                        System.out.println("!Expresion Con Direccion de Archivo y Argumentos¡\n");        
                        expresion.setDirrecionArchivo(args[(args.length-1)]); 
                        estadoCarga = 1;
                        
                        for(int i=0; i<args.length; i++){
                            if(!args[i].equals("-c") && !args[i].equals("-d") && !args[i].equals("-l") && !args[i].equals("-s") && (i<(args.length-2) && (!this.esNumero(args[i])))){
                             bandera[0]=true;
                            }
                            switch(args[i]){
                                case "-c":
                                    
                                    if(!(args[i+1].equals("-l")) && !(args[i+1].equals("-s")) && !(args[i+1].equals("-d")) && !args[i+1].equals(args[args.length-1])){
                                        expresion.setComando1(args[i]);
                                        expresion.setArgumen1(args[i+1]);
                                        bandera[1]=false;
                                    }
                                    break;
                                case "-d":
                                    expresion.setComando2(args[i]);
                                    if(this.esNumero(args[i+1])){
                                        expresion.setArgumen2(Integer.parseInt(args[i+1])); 
                                        
                                    }else{
                                        if(args[i+1].equals("-l") || args[i+1].equals("-s") || args[i+1].equals("-d") || args[i+1].equals("-c") || (args[i+1].indexOf(".txt")!=-1)){
                                            expresion.setArgumen2(1);
                                        }else{
                                            bandera[1]=true;
                                        }
                                    }

                                    break;
                                case "-l":
                                    expresion.setComando3(args[i]);
                                    if(this.esNumero(args[i+1])){
                                        expresion.setArgumen3(Integer.parseInt(args[i+1])); 
                                        
                                    }else{
                                        if(args[i+1].equals("-l") || args[i+1].equals("-s") || args[i+1].equals("-d") || args[i+1].equals("-c") || (args[i+1].indexOf(".txt")!=-1)){
                                            expresion.setArgumen3(1);
                                            //System.out.print("-l argumento a null");
                                        }else{
                                            bandera[1]=true;
                                        }
                                    }
                                    break;
                                case "-s":
                                    expresion.setComando3(args[i]);
                                    if(this.esNumero(args[i+1])){
                                        expresion.setArgumen3(Integer.parseInt(args[i+1])); 
                                        
                                    }else{
                                        if(args[i+1].equals("-l") || args[i+1].equals("-s") || args[i+1].equals("-d") || args[i+1].equals("-c") || (args[i+1].indexOf(".txt")!=-1)){
                                            expresion.setArgumen3(1);
                                            //System.out.print("-s argumento a null");
                                        }else{
                                            bandera[1]=true;
                                        }
                                    }

                                    break;
                                default: 
                                    
                                    
                                break;
                            }
                            banderaP=true;
                        } 
                        if(bandera[0] && bandera[1]){
                            estadoCarga = -1;
                            System.out.println("Ingreso parametros erroneosss");
                        }
                    
            }else if(((args[args.length-1].indexOf(".txt")) == -1)&&(args.length>1)){
                 estadoCarga = -1;
            }
            
       //}else if(args.length==0){ 
       //    System.out.println("Error: !No Se Sstipulo Ningun Argumentos, ni Ruta de Archivo");
       //}else if(args.length>7){
       //    System.out.println("Error: !Ah Estipulado Mucho Mas Argumentos de los que Requiere el Programa¡");
       //}
    }
    
    public  Expresion getExpresion(){
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