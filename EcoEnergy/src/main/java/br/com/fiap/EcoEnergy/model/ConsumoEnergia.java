package br.com.fiap.EcoEnergy.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "TBL_CONSUMO_ENERGIA")
@Data
public class ConsumoEnergia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsumo;
    private Date data;
    private double consumo;

    //Relacionamento
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_residencia")
    private Residencia residencia;

    public ConsumoEnergia() {
    }

    public ConsumoEnergia(int idConsumo, Date data, double consumo) {
        this.idConsumo = idConsumo;
        this.data = data;
        this.consumo = consumo;
    }

    public ConsumoEnergia(int idConsumo, Date data, double consumo, Residencia residencia) {
        this.idConsumo = idConsumo;
        this.data = data;
        this.consumo = consumo;
        this.residencia = residencia;
    }
}
