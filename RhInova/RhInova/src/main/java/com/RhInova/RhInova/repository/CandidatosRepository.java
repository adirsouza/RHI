package com.RhInova.RhInova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;

import com.RhInova.RhInova.models.Candidatos;
import com.RhInova.RhInova.models.Funcionario;
import com.RhInova.RhInova.models.Vaga;


public interface CandidatosRepository extends JpaRepository<Candidatos, Long>{
//	//consulta pode nome 
//	@Query("SELECT c FROM Candidato c WHERE c.nome LIKE %:nome%")
//	List<Candidatos> buscarPorNome(@Param("nome")String nome);
	
	//consulta por email
	@Query("SELECT c FROM Candidatos c WHERE c.email = :email")
	Candidatos buscarPorEmil(@Param("email")String email);
	
//	//consulta por cargo
//	@Query("SELECT c FROM Candidatos c WHERE c.cargo = :cargo")
//	List<Candidatos>buscarPorCargo(@Param("cargo")String cargo);
}
