package br.com.plantinha;

import javax.persistence.*;

@Entity
public class Planta {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "ID")
    Long id;

    @Column(name = "TIPO")
    String tipo;

    @Column(name = "GENERO")
    String genero;

    @Column(name = "ESPECIE")
    String especie;

    @Column(name = "DETALHES")
    String detalhes;

    @Column(name = "IMAGEM")
    String imagem;

    public Planta(String tipo, String genero, String especie, String detalhes, String imagem) {
        this.tipo = tipo;
        this.genero = genero;
        this.especie = especie;
        this.detalhes = detalhes;
        this.imagem = imagem;
    }

    public Planta(){};

    public String getTipo() {
        return tipo;
    }

    public String getGenero() {
        return genero;
    }

    public String getEspecie() {
        return especie;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public String getImagem() {
        return imagem;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
