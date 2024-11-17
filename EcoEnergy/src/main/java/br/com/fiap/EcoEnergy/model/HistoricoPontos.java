package br.com.fiap.EcoEnergy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "TBL_HISTORICO_PONTOS")
@Data
public class HistoricoPontos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorico;
    private Date data;
    private double quantidade;

    //Relacionamento
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuarios")
    private Usuario usuarios;

    public HistoricoPontos() {
    }

    public HistoricoPontos(Long idHistorico, Date data, double quantidade, Usuario usuarios) {
        this.idHistorico = idHistorico;
        this.data = data;
        this.quantidade = quantidade;
        this.usuarios = usuarios;
    }
}
