package br.com.fiap.EcoEnergy.repository;

import br.com.fiap.EcoEnergy.model.TrocasRecompensas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrocasRecompensasRepository extends JpaRepository<TrocasRecompensas, Long> {
}
