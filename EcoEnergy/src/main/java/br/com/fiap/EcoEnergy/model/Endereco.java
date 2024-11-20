package br.com.fiap.EcoEnergy.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TBL_ENDERECOS")
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;
    private String cep;
    private String rua;
    private String numero;
    private String complemento;

    public Endereco() {
    }

    public Endereco(Long idEndereco, String cep, String rua, String numero, String complemento) {
        this.idEndereco = idEndereco;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }
}
