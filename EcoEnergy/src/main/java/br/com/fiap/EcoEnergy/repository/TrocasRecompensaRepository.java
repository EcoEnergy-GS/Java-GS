package br.com.fiap.EcoEnergy.repository;

import br.com.fiap.EcoEnergy.model.TrocasRecompensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrocasRecompensaRepository extends JpaRepository<TrocasRecompensa, Long> {
}
