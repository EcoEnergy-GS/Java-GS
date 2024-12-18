package br.com.fiap.EcoEnergy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "TBL_TROCAS_RECOMPENSAS")
@Data
public class TrocasRecompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrocas;
    private Date dataTroca;
    private double pontosUtilizados;

    //Relacionamentos
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_recompensas")
    private Recompensa recompensas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuarios")
    private Usuario usuarios;

    public TrocasRecompensa() {
    }

    public TrocasRecompensa(Long idTrocas, Date dataTroca, double pontosUtilizados) {
        this.idTrocas = idTrocas;
        this.dataTroca = dataTroca;
        this.pontosUtilizados = pontosUtilizados;
    }

    public TrocasRecompensa(Long idTrocas, Date dataTroca, double pontosUtilizados, Recompensa recompensas, Usuario usuarios) {
        this.idTrocas = idTrocas;
        this.dataTroca = dataTroca;
        this.pontosUtilizados = pontosUtilizados;
        this.recompensas = recompensas;
        this.usuarios = usuarios;
    }
}
