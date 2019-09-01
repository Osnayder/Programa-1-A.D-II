package edu.cecar.modelo;

/**
 *
 * @author osnayder
 */
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
