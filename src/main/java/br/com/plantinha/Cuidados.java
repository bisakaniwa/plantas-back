package br.com.plantinha;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cuidados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "PLANTA_ID")
    Long plantaId;

    @Column(name = "SUBSTRATO")
    String substrato;

    @Column(name = "REGA")
    String rega;

    @Column(name = "ILUMINACAO")
    String iluminacao;

    @Column(name = "TEMPERATURA")
    String temperatura;

    @Column(name = "UMIDADE")
    String umidade;

    @Column(name = "VENTOS")
    String ventos;
}
