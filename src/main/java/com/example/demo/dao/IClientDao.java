package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.models.Client;

public interface IClientDao extends JpaRepository<Client, Long> {
	
	@Query("select c from Client c where c.nom =:nom")
	List<Client> findByNom (@Param("nom")String nom);
	
	@Query("select c from Client c where c.prenom =:prenom")
	List<Client> findByPrenom (@Param("prenom")String prenom);
	
	@Query("select c from Client c where c.adresse =:adresse")
	List<Client> findByAdresse (@Param("adresse")String adresse);
	
	@Query("select c from Client c left join fetch c.scores s where s.score =:score")
	List<Client> findByScore (@Param("score")Integer score);
	
	@Query("select c from Client c left join fetch c.scores s where s.score <= :scoreInf")
	List<Client> findByPrixInf (@Param("scoreInf") Integer scoreInf);
	
	@Query("select c from Client c left join fetch c.scores s where s.score >= :scoreSup")
	List<Client> findByPrixSup (@Param("scoreSup") Integer scoreSup);

}
