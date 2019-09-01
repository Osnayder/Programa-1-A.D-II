package edu.cecar.controlador;

public class ExcepcionLimiteArgumentos extends Exception{
    public ExcepcionLimiteArgumentos(){ this(""); }
    
    public ExcepcionLimiteArgumentos(String arg){
        super("!Ah Sobrepasado El Numero de Argumento Requerido o No Ingreso Ningun Argumento¡");
    }
}
