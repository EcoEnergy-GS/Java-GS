package br.com.fiap.EcoEnergy.repository;

import br.com.fiap.EcoEnergy.model.HistoricoPontos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoPontosRepository extends JpaRepository<HistoricoPontos, Long> {
}
