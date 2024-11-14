package br.com.fiap.EcoEnergy.repository;

import br.com.fiap.EcoEnergy.model.Residencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenciaRepository extends JpaRepository<Residencia, Long> {
}
