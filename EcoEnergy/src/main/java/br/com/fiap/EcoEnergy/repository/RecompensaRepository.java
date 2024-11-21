package br.com.fiap.EcoEnergy.repository;

import br.com.fiap.EcoEnergy.model.Recompensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecompensaRepository extends JpaRepository<Recompensa, Long> {
}
