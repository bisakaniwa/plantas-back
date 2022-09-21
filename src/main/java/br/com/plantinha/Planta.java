package br.com.plantinha;

import lombok.Builder;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
public class Planta {

    //Dados
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

    @Column(name = "ESPECIFICAÇÃO")
    String especificacao;

    @Column(name = "NOME_POPULAR")
    String nomePopular;

    @Column(name = "IMAGEM")
    String imagem;

    @Column(name = "DETALHE")
    String detalhe;


    //Cuidados

    @Column(nome = "SUBSTRATO")
    String substrato;

    public Planta(Long id, String tipo, String genero, String especie, String especificacao, String nomePopular,
                  String imagem, String detalhe) {
        this.id = id;
        this.tipo = tipo;
        this.genero = genero;
        this.especie = especie;
        this.especificacao = especificacao;
        this.nomePopular = nomePopular;
        this.imagem = imagem;
        this.detalhe = detalhe;
    }

    public Planta(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getGenero() {
        return genero;
    }

    public String getEspecie() {
        return especie;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public String getNomePopular() {
        return nomePopular;
    }

    public String getImagem() {
        return imagem;
    }

    public String getDetalhe() {
        return detalhe;
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

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }
}
