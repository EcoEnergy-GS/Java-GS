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
    private int idHistorico;
    private Date data;
    private double quantidade;

    //Relacionamento
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuarios")
    private Usuarios usuarios;

    public HistoricoPontos() {
    }

    public HistoricoPontos(int idHistorico, Date data, double quantidade, Usuarios usuarios) {
        this.idHistorico = idHistorico;
        this.data = data;
        this.quantidade = quantidade;
        this.usuarios = usuarios;
    }
}
