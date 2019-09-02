package edu.cecar.controlador;

public class ExcepcionCargarArgumentos extends Exception{
    public ExcepcionCargarArgumentos(){ this(""); }
    
    public ExcepcionCargarArgumentos(String arg){
        super("!Ah Sobrepasado El Numero de Argumento Requerido o No Ingreso Ningun Argumento¡");
    }
}
