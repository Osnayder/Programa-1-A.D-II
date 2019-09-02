package edu.cecar.controlador;


public class ProcesarDatos {
    
    private static int contador = 0, contador2 = 0, cadMasLarga = 0, 
                       contDeCharEnLinea = 0, numLineaMasLarga  = 0,
                       contDeLinea =0, posicionPunterCadLarga  =  0, 
                       cantidadLineasArchivo = 0;
    private static String[] argumentos = new String[4];
    private static String archivoLeido = null;
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
                            int listaDeLineasMayores[] = new int[expresionCargada.getExpresion().getArgumen3()];                            
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
                            int listaDeLineasMenores[] = new int[expresionCargada.getExpresion().getArgumen3()];
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