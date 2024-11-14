package br.com.fiap.EcoEnergy.repository;

import br.com.fiap.EcoEnergy.model.Recompensas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecompensasRepository extends JpaRepository<Recompensas, Long> {
}
