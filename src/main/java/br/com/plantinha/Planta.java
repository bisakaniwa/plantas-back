package br.com.plantinha;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "ESPECIFICAÇÃO")
    String especificacao;

    @Column(name = "NOME_POPULAR")
    String nomePopular;

    @Column(name = "IMAGEM")
    String imagem;

    @Column(name = "DETALHE")
    String detalhe;
}
