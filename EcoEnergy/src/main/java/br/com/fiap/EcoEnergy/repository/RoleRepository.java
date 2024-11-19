package br.com.fiap.EcoEnergy.repository;

import br.com.fiap.EcoEnergy.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
