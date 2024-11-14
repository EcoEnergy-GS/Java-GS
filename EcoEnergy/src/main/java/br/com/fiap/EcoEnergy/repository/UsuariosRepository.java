package br.com.fiap.EcoEnergy.repository;

import br.com.fiap.EcoEnergy.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
}
