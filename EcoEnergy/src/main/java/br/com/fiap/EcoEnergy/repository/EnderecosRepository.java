package br.com.fiap.EcoEnergy.repository;

import br.com.fiap.EcoEnergy.model.Enderecos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecosRepository extends JpaRepository<Enderecos, Long> {
}
