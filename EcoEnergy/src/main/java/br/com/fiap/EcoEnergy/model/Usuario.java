package br.com.fiap.EcoEnergy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBL_USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarios;
    private String nome;
    private String senha;
    private String telefone;
    private int pontos;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_roles_associacao", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(Long idUsuarios, String nome, String senha, String telefone, int pontos) {
        this.idUsuarios = idUsuarios;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.pontos = pontos;
    }

    public Long getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Long idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
