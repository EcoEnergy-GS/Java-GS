package br.com.fiap.EcoEnergy.repository;

import br.com.fiap.EcoEnergy.model.TipoEletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEletrodomesticoRepository extends JpaRepository<TipoEletrodomestico, Long> {
}
