package br.com.fiap.EcoEnergy.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "TBL_RECOMPENSAS")
public class Recompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecompensas;
    @Size(min = 4, max = 100)
    private String descricao;
    @NotNull
    private double pontosNecessarios;

    public Recompensa() {
    }

    public Recompensa(Long idRecompensas, String descricao, double pontosNecessarios) {
        this.idRecompensas = idRecompensas;
        this.descricao = descricao;
        this.pontosNecessarios = pontosNecessarios;
    }


}
