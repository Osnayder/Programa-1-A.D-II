/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.controlador;

/**
 *
 * @author osnayder
 */
public class ErrorDeArgumentos extends Exception{
    
    public ErrorDeArgumentos(){
        this("Numero de argumentos sobre pasados");
    }
    
    public ErrorDeArgumentos(String arg){
        
    }
    
}
