package br.com.fiap.EcoEnergy.repository;

import br.com.fiap.EcoEnergy.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNome(String nome);
}
