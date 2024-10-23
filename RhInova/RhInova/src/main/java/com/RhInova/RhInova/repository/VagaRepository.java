package com.RhInova.RhInova.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.RhInova.RhInova.models.Vaga;

public interface VagaRepository extends CrudRepository<Vaga, Long> {
	Vaga findByCodigo(long codigo);

	List<Vaga> findByNome(String nome);

	// Query para a busca
	@Query(value = "select u from Vaga u where u.nome like %?1%")
	List<Vaga> findByNomesVaga(String nome);
}
