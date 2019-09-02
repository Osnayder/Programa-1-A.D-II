/** Clase: TextoPlano 
 * @version: 0.1
 *  
 * @sincelejo: 21/08/2019
 * 
 * Fecha de Modificación: 
 * 
 * @author: Osnayder Conde Rodriguez
 * 
 * Copyrigth: CECAR
 */

package edu.cecar.modelo;


public class TextoPlano {
    private String texto;
    private String ruta;

    public TextoPlano() {
    }

    public TextoPlano(String texto, String ruta) {
        this.texto = texto;
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
