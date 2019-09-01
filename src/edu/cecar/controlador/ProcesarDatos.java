package edu.cecar.controlador;

import edu.cecar.modelo.Expresion;
import edu.cecar.modelo.TextoPlano;

/**
 *
 * @author osnayder
 */
public class ProcesarDatos {
    
    public  static void iniciarProceso(CargarExpresion expresionCargada){
        
        int contador=0,contador2=0;
        int cadMasLarga = 0;
        int contDeCharEnLinea =0;
        int numLineaMasLarga=0;
        int contDeLinea=0;
        int posicionPunterCadLarga=0;
        int cantidadLineasArchivo=0;
        int cantEnLinea[];
        int listaTamañoLineas[];
        int listaDeLineasMayores[] = new int[expresionCargada.getExpresion().getArgumen3()];
        int listaDeLineasMenores[] = new int[expresionCargada.getExpresion().getArgumen3()];
        
        String[] argumentos = new String[4];
        argumentos[0] = expresionCargada.getExpresion().getComando1();
        argumentos[1] = expresionCargada.getExpresion().getComando2();
        argumentos[2] = expresionCargada.getExpresion().getComando3();
        argumentos[3] = expresionCargada.getExpresion().getComando3();
   
        String archivoLeido = FlujoArchivo.flujoEntrada(expresionCargada.getExpresion().getDirrecionArchivo());
        
        for(int i=0; i<archivoLeido.length(); i++){
            if(archivoLeido.charAt(i)=='\n'){
                cantidadLineasArchivo++;
            }
        }
        
        cantEnLinea= new int[cantidadLineasArchivo];
        listaTamañoLineas = new int[cantidadLineasArchivo];
        
        contDeCharEnLinea = 0;
        for(int i=0, j=0; i<archivoLeido.length(); i++){
            contDeCharEnLinea++;
            if(archivoLeido.charAt(i)=='\n'){
                listaTamañoLineas[j] = contDeCharEnLinea-1;
                contDeCharEnLinea=0;
                j++;
            }
        }
        
        
        
        if(!expresionCargada.getExpresion().getEstadoComando1() && 
           !expresionCargada.getExpresion().getEstadoComando2() && 
           !expresionCargada.getExpresion().getEstadoComando3()){
                System.out.println("\n------------------------------------------------------------");
                System.out.println("El Archivo Cargado: \n"+archivoLeido+"\n");
                contDeCharEnLinea = 0;
                for(int i=0; i<archivoLeido.length(); i++){
                     contDeCharEnLinea++; 
                     if(archivoLeido.charAt(i)=='\n'){ 
                         contDeLinea++;
                         if(cadMasLarga<(contDeCharEnLinea-1)){
                             posicionPunterCadLarga = i;
                             cadMasLarga= (contDeCharEnLinea-1);
                             numLineaMasLarga = contDeLinea;
                         }
                         contDeCharEnLinea=0;
                     }
                }
                
                System.out.println("\n---------------------------------------\n Resultado:\n");
                System.out.print("\nLa Linea mas Larga es la Numero: "+numLineaMasLarga+"\nContiene: "+cadMasLarga+" caracteres.\nLinea de Texto: ");
                for(int i=(posicionPunterCadLarga-cadMasLarga); i<posicionPunterCadLarga; i++){
                    System.out.print(archivoLeido.charAt(i));
                }
                System.out.println("\n");

        }else{           
            
             System.out.println("Comando 1: "+expresionCargada.getExpresion().getComando1()+" Argumento 1: "+expresionCargada.getExpresion().getArgumen1()+"\n"+
                                "Comando 2: "+expresionCargada.getExpresion().getComando2()+" Argumento 2: "+expresionCargada.getExpresion().getArgumen2()+"\n"+
                                "Comando 3: "+expresionCargada.getExpresion().getComando3()+" Argumento 3: "+expresionCargada.getExpresion().getArgumen3()+"\n\n"+
                                "---------------------------------\nNombre de archivo:"+expresionCargada.getExpresion().getDirrecionArchivo()+"\n"+
                                "---------------------------------\n\n");
             System.out.println("\n________________________________________________________________________________________\n");
             System.out.print("#\tContenido del Arhivo: \n"+
                                "_________________________________________________________________________________________\n"
                                +archivoLeido);
             System.out.println("________________________________________________________________________________________");
            
             
             boolean controladorEntrada = true;
             
            for(int i=0; i<4; i++){
              if(argumentos[i]!=null){  
                switch(argumentos[i]){
                    case "-c": 
                        if(expresionCargada.getExpresion().getArgumen1()!=null){
                            for(int j=0; j<archivoLeido.length(); j++){
                                if(archivoLeido.charAt(j)=='\n'){
                                    contador2++;
                                }
                                if((expresionCargada.getExpresion().getArgumen1().charAt(contador)==archivoLeido.charAt(j))){
                                        if(contador==(expresionCargada.getExpresion().getArgumen1().length()-1)){
                                           cantEnLinea[contador2]++;
                                           contador=0;
                                        }else{
                                           contador++;   
                                        }
                                }else{
                                    contador=0;
                                }
                            }
                            
                            
                            for(int k=0; k<cantidadLineasArchivo; k++){
                                System.out.println(" "+cantEnLinea[k]);
                            } 
                        }
                        break;
                    case "-d": 
                        if(expresionCargada.getExpresion().getArgumen2()>0){
                            System.out.print("mx ");
                        }
                        break;
                    case "-l":
                        
                        if(expresionCargada.getExpresion().getArgumen3()>0 && controladorEntrada){
                            contador = 0;
                            contador2 = 0;
                            listaDeLineasMayores[contador]=0;
                            
                            for(int f=0; f<cantidadLineasArchivo; f++){
                                System.out.print(" "+listaTamañoLineas[f]);
                            }
                            System.out.print("\n");
                            for(int f=0; f<expresionCargada.getExpresion().getArgumen3(); f++){
                                for(int l=0; l<cantidadLineasArchivo; l++){
                                    if(listaDeLineasMayores[contador]<listaTamañoLineas[l]){
                                        listaDeLineasMayores[contador] = listaTamañoLineas[l];
                                        contador2 = l;
                                    }
                                }
                                listaTamañoLineas[contador2]=0;
                                contador++;
                            }
                            
                            for(int f=0; f<expresionCargada.getExpresion().getArgumen3(); f++){
                                System.out.println("->"+listaDeLineasMayores[f]);
                            }
                            
                            contDeCharEnLinea = 0;
                            contador = 0;
                            for(int d=0; d<expresionCargada.getExpresion().getArgumen3(); d++){
                                for(int f=0; f<archivoLeido.length(); f++){
                                    contDeCharEnLinea++;
                                    if((archivoLeido.charAt(f)=='\n')){
                                        if(((contDeCharEnLinea-1)==listaDeLineasMayores[contador])){
                                            for(int g=(f-(contDeCharEnLinea-1)); g<(f+1); g++){
                                                System.out.print(archivoLeido.charAt(g));
                                            }
                                            System.out.print("\n");
                                        }
                                        contDeCharEnLinea=0;
                                    }
                               }
                                contador++;    
                            }
                            controladorEntrada=false;
                        }
                          
                        break;
                    case "-s": 
                        if(expresionCargada.getExpresion().getArgumen3()>0 && controladorEntrada){
                            contador = 0;
                            contador2 = 0;
                            listaDeLineasMenores[contador]=500*500;
                            
                            for(int f=0; f<cantidadLineasArchivo; f++){
                                System.out.print(" "+listaTamañoLineas[f]);
                            }
                            
                            System.out.print("\n");
                            for(int f=0; f<expresionCargada.getExpresion().getArgumen3(); f++){
                                for(int l=0; l<cantidadLineasArchivo; l++){
                                    if(listaDeLineasMenores[contador]>listaTamañoLineas[l]){
                                        listaDeLineasMenores[contador] = listaTamañoLineas[l];
                                        contador2 = l;
                                    }
                                }
                                listaTamañoLineas[contador2]=500;
                                contador++;
                            }
                            
                            for(int f=0; f<expresionCargada.getExpresion().getArgumen3(); f++){
                                System.out.println("->"+listaDeLineasMenores[f]);
                            }
                            
                            controladorEntrada=false;
                        }
                        break;
                }
              }
            }
            
            
        }
    }
}