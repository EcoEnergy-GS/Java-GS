package br.com.fiap.EcoEnergy.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Data;

@Entity
@Table(name = "TBL_ENDERECOS")
@Data
public class Enderecos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;
    private String cep;
    private String rua;
    private String numero;
    private String complemento;

    public Enderecos() {
    }

    public Enderecos(Long idEndereco, String cep, String rua, String numero, String complemento) {
        this.idEndereco = idEndereco;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }
}
