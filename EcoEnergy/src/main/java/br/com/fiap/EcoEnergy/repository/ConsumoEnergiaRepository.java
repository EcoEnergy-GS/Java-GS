package br.com.fiap.EcoEnergy.repository;

import br.com.fiap.EcoEnergy.model.ConsumoEnergia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumoEnergiaRepository extends JpaRepository<ConsumoEnergia, Long>{
}
