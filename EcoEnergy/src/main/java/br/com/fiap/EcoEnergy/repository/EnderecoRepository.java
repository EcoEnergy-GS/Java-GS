package br.com.fiap.EcoEnergy.repository;

import br.com.fiap.EcoEnergy.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
