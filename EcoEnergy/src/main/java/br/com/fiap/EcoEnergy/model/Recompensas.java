package br.com.fiap.EcoEnergy.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
@Table(name = "TBL_RECOMPENSAS")
public class Recompensas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecompensas;
    private String desricao;
    private double pontosNecessarios;

    public Recompensas() {
    }

    public Recompensas(int idRecompensas, String desricao, double pontosNecessarios) {
        this.idRecompensas = idRecompensas;
        this.desricao = desricao;
        this.pontosNecessarios = pontosNecessarios;
    }


}
