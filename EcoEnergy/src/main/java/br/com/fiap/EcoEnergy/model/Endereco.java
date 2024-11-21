package br.com.fiap.EcoEnergy.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "TBL_ENDERECOS")
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;
    @Size(max = 9, message = "Digite os 9 digitos do CEP sem traços")
    private String cep;
    @Size(max = 100)
    private String rua;
    @Size(max = 10)
    private String numero;
    @Size(max = 50)
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
