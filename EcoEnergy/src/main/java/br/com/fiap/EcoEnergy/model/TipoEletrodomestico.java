package br.com.fiap.EcoEnergy.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TBL_TIPO_ELETRODOMESTICO")
@Data
public class TipoEletrodomestico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEletrodomestico;
    private String nomeEletrodomestico;
    private int quantidade;

    public TipoEletrodomestico() {
    }

    public TipoEletrodomestico(int idEletrodomestico, String nomeEletrodomestico, int quantidade) {
        this.idEletrodomestico = idEletrodomestico;
        this.nomeEletrodomestico = nomeEletrodomestico;
        this.quantidade = quantidade;
    }
}
