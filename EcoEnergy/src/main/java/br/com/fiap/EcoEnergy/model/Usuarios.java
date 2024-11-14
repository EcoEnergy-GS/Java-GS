package br.com.fiap.EcoEnergy.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_USUARIOS")
@Data
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuarios;
    private String nome;
    private String senha;
    private String telefone;
    private int pontos;

    public Usuarios() {
    }

    public Usuarios(int idUsuarios, String nome, String senha, String telefone, int pontos) {
        this.idUsuarios = idUsuarios;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.pontos = pontos;
    }
}
