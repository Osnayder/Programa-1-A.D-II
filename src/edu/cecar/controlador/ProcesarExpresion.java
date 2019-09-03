/** Clase: ProcesarExpresion
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

public class ProcesarExpresion {
    
    private static int contador = 0, contador2 = 0, cadMasLarga = 0, 
                       contDeCharEnLinea = 0, numLineaMasLarga  = 0,
                       contDeLinea =0, posicionPunterCadLarga  =  0, 
                       cantidadLineasArchivo = 0;
    private static String[] argumentos = new String[4];
    private static String archivoLeido = null, puente = null;
    private static TextoPlano textoGuardar  = null;
    private static  int cantEnLinea[] = null, listaTamañoLineas[] = null;
    
    public  static void iniciarProceso(CargarExpresion expresionCargada){
        
        try {
            archivoLeido = FlujoArchivo.flujoEntrada(expresionCargada.getExpresion().getDirrecionArchivo());
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
        } catch (ExcepcionArchivoNoCargado ex) {
            System.out.println(ex.getMessage());
            
        }
        
        if(!expresionCargada.getExpresion().getEstadoComando1() && 
           !expresionCargada.getExpresion().getEstadoComando2() &&
           !expresionCargada.getExpresion().getEstadoComando3() &&(archivoLeido!=null))  {
                
            System.out.println("\nEl Contenido del Archivo Cargado Es El Siguiente: \n\n"+archivoLeido+"\n");
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
                
            System.out.print("Resultado:\nLa Linea mas Larga es la Numero: "+numLineaMasLarga+
                                "\nContiene: "+cadMasLarga+" caracteres.\nLinea de Texto: [");
                for(int i=(posicionPunterCadLarga-cadMasLarga); i<posicionPunterCadLarga; i++){
                    System.out.print(archivoLeido.charAt(i));
                }
                System.out.println("]\n");

        }else if(archivoLeido!=null){
            
            argumentos[0] = expresionCargada.getExpresion().getComando1();
            argumentos[1] = expresionCargada.getExpresion().getComando2();
            argumentos[2] = expresionCargada.getExpresion().getComando3();
            argumentos[3] = expresionCargada.getExpresion().getComando3();
            
            
             System.out.println("Lista de Argumentos y Parametros Cargador\n");
             System.out.println("Comando 1: "+expresionCargada.getExpresion().getComando1()+" Argumento 1: "+expresionCargada.getExpresion().getArgumen1()+"\n"+
                                "Comando 2: "+expresionCargada.getExpresion().getComando2()+" Argumento 2: "+expresionCargada.getExpresion().getArgumen2()+"\n"+
                                "Comando 3: "+expresionCargada.getExpresion().getComando3()+" Argumento 3: "+expresionCargada.getExpresion().getArgumen3()+"\n"+
                                "Nombre de archivo: "+expresionCargada.getExpresion().getDirrecionArchivo()+" \n");
             System.out.println("\n\t================================");
             System.out.println("\t     Contenido del Arhivo: \n"+
                                "\t=================================\n\n"
                                +archivoLeido);
             System.out.println("#####################################################\n");
            
             
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
                            
                            contador = 0;
                            puente = cantEnLinea[contador]+" ";
                            contador++;
                            
                            for(int f=0; f<archivoLeido.length()-1; f++){
                                puente = puente + archivoLeido.charAt(f);
                                if(archivoLeido.charAt(f)=='\n'){
                                    puente = puente + "\r\n" + cantEnLinea[contador]+" ";
                                    contador++;
                                }
                            }
                            
                            textoGuardar = new TextoPlano();
                            textoGuardar.setTexto(puente);
                            textoGuardar.setRuta("busqueda");
                        
                            try {
                                FlujoArchivo.flujoSalida(textoGuardar);
                            } catch (ExcepcionGuardarArchivo ex) {
                                System.out.println(ex.getMessage());
                            }
                            
                             System.out.println("\t!Argumento -c Procesado Exitosamente¡ ");
                             System.out.println("Nombre Archivo Resultado de Argumento <-c>: "+textoGuardar.getRuta()+"AnaTex.txt");

                        }
                        break;
                    case "-d": 
                        if(expresionCargada.getExpresion().getArgumen2()>0){
                            String palabra = "";
                            for(int f=0; f<archivoLeido.length(); f++){
                                if(archivoLeido.charAt(f)!=' ' && archivoLeido.charAt(f)!='\n'){
                                    palabra = palabra+archivoLeido.charAt(f);
                                }
                                
                                if(archivoLeido.charAt(f)==' '){
                                    System.out.println("Plabra cargada: "+palabra);
                                    palabra = "";
                                }
                                
                            }
                            
                            System.out.println("\t!Argumento -c Procesado Exitosamente¡ ");
                        }
                        break;
                    case "-l":
                        
                        if(expresionCargada.getExpresion().getArgumen3()>0 && controladorEntrada && (expresionCargada.getExpresion().getArgumen3()<=cantidadLineasArchivo)){
                            int listaDeLineasMayores[] = new int[expresionCargada.getExpresion().getArgumen3()];                            
                            contador = 0;
                            contador2 = 0;
                            listaDeLineasMayores[contador]=0;
                            
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
                            
                            contDeCharEnLinea = 0;
                            contador = 0;
                            puente  = "";
                            textoGuardar = new TextoPlano();
                            
                            for(int d=0; d<expresionCargada.getExpresion().getArgumen3(); d++){
                                for(int f=0; f<archivoLeido.length(); f++){
                                    contDeCharEnLinea++;
                                    if((archivoLeido.charAt(f)=='\n') && (contador<expresionCargada.getExpresion().getArgumen3())){
                                        if(((contDeCharEnLinea-1)==listaDeLineasMayores[contador])){
                                            for(int g=(f-(contDeCharEnLinea-1)); g<(f+1); g++){
                                                puente = puente + archivoLeido.charAt(g);
                                            }
                                            puente = puente + "\r\n";
                                            contador++;
                                        }
                                        contDeCharEnLinea=0;
                                    }
                               }   
                            }
                            textoGuardar.setTexto(puente);
                            textoGuardar.setRuta("masLarga");
                            
                            try {
                                FlujoArchivo.flujoSalida(textoGuardar);
                            } catch (ExcepcionGuardarArchivo ex) {
                                System.out.println(ex.getMessage());
                            }
                            
                            System.out.println("\t!Argumento -l Procesado Exitosamente¡ ");
                            System.out.println("Nombre Archivo Resultado de Argumento <-l>: "+textoGuardar.getRuta()+"AnaTex.txt");
                            controladorEntrada=false;
                        }else if((expresionCargada.getExpresion().getArgumen3()>cantidadLineasArchivo)){
                            System.out.println("¡Error! Usted Especifico Buscar Las "+expresionCargada.getExpresion().getArgumen3()+
                                               " Mas Largas y Solo hay "+cantidadLineasArchivo+" Lineas");
                        }
                          
                        break;
                    case "-s": 
                        if(expresionCargada.getExpresion().getArgumen3()>0 && controladorEntrada && (expresionCargada.getExpresion().getArgumen3()<=cantidadLineasArchivo)){
                            int listaDeLineasMenores[] = new int[expresionCargada.getExpresion().getArgumen3()];
                            contador = 0;
                            contador2 = 0;
            
                            for(int f=0; f<expresionCargada.getExpresion().getArgumen3(); f++){
                               listaDeLineasMenores[contador]=500*500;
                                for(int l=0; l<cantidadLineasArchivo; l++){
                                    if(listaDeLineasMenores[contador]>listaTamañoLineas[l]){
                                        listaDeLineasMenores[contador] = listaTamañoLineas[l];
                                        contador2 = l;
                                    }
                                }
                                listaTamañoLineas[contador2]=500;
                                contador++;
                            }
                            
                            contDeCharEnLinea = 0;
                            contador = 0;
                            puente  = "";
                            textoGuardar = new TextoPlano();
                            for(int d=0; d<expresionCargada.getExpresion().getArgumen3(); d++){
                                for(int f=0; f<archivoLeido.length(); f++){
                                    contDeCharEnLinea++;
                                    if((archivoLeido.charAt(f)=='\n') && (contador<expresionCargada.getExpresion().getArgumen3())){
                                        if(((contDeCharEnLinea-1)==listaDeLineasMenores[contador])){
                                            for(int g=(f-(contDeCharEnLinea-1)); g<(f+1); g++){
                                                puente = puente + archivoLeido.charAt(g);
                                            }
                                            puente = puente + "\r\n";
                                            contador++;
                                        }
                                        contDeCharEnLinea=0;
                                    }
                               }   
                            }
                            textoGuardar.setTexto(puente);
                            textoGuardar.setRuta("masCorta");
                            
                            try {
                                FlujoArchivo.flujoSalida(textoGuardar);
                            } catch (ExcepcionGuardarArchivo ex) {
                                System.out.println(ex.getMessage());
                            }
                            
                            System.out.println("\t!Argumento -s Procesado Exitosamente¡ ");
                            System.out.println("Nombre Archivo Resultado de Argumento <-s>: "+textoGuardar.getRuta()+"AnaTex.txt");
                            controladorEntrada=false;
                        }else if((expresionCargada.getExpresion().getArgumen3()>cantidadLineasArchivo)){
                            System.out.println("¡Error! Usted Especifico Buscar Las "+expresionCargada.getExpresion().getArgumen3()+
                                               " Mas Cortas y Solo hay "+cantidadLineasArchivo+" Lineas");
                        }
                    break;
                }
             }
            }
        }  
    }
}