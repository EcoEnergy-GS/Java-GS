package br.com.fiap.EcoEnergy.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TBL_RESIDENCIA")
@Data
public class Residencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResidencia;
    private String dispositivoMonitoramento;
    private int quantidadePessoas;
    private double mediaConsumo;

    //Relacionamentos
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuarios")
    private Usuario usuarios;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_eletrodomestico")
    private TipoEletrodomestico tipoEletrodomestico;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Enderecos enderecos;

    public Residencia() {
    }

    public Residencia(Long idResidencia, String dispositivoMonitoramento, int quantidadePessoas, double mediaConsumo) {
        this.idResidencia = idResidencia;
        this.dispositivoMonitoramento = dispositivoMonitoramento;
        this.quantidadePessoas = quantidadePessoas;
        this.mediaConsumo = mediaConsumo;
    }

    public Residencia(Long idResidencia, String dispositivoMonitoramento, int quantidadePessoas, double mediaConsumo, Usuario usuarios, TipoEletrodomestico tipoEletrodomestico, Enderecos enderecos) {
        this.idResidencia = idResidencia;
        this.dispositivoMonitoramento = dispositivoMonitoramento;
        this.quantidadePessoas = quantidadePessoas;
        this.mediaConsumo = mediaConsumo;
        this.usuarios = usuarios;
        this.tipoEletrodomestico = tipoEletrodomestico;
        this.enderecos = enderecos;
    }
}
