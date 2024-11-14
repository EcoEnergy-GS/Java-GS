package br.com.fiap.EcoEnergy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "TBL_TROCAS_RECOMPENSAS")
@Data
public class TrocasRecompensas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrocas;
    private Date dataTroca;
    private double pontosUtilizados;

    //Relacionamentos
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_recompensas")
    private Recompensas recompensas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuarios")
    private Usuarios usuarios;

    public TrocasRecompensas() {
    }

    public TrocasRecompensas(int idTrocas, Date dataTroca, double pontosUtilizados) {
        this.idTrocas = idTrocas;
        this.dataTroca = dataTroca;
        this.pontosUtilizados = pontosUtilizados;
    }

    public TrocasRecompensas(int idTrocas, Date dataTroca, double pontosUtilizados, Recompensas recompensas, Usuarios usuarios) {
        this.idTrocas = idTrocas;
        this.dataTroca = dataTroca;
        this.pontosUtilizados = pontosUtilizados;
        this.recompensas = recompensas;
        this.usuarios = usuarios;
    }
}
