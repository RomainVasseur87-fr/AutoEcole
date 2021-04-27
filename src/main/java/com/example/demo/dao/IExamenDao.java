package com.example.demo.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.models.ExamenCode;

public interface IExamenDao extends JpaRepository<ExamenCode, Long> {
	
	@Query("select e from Examen e where e.date =:date")
	List<ExamenCode> findByDate (@Param("date")Date date);
	
	@Query("select e from Examen e where e.heure =:heure")
	List<ExamenCode> findByHeure (@Param("heure")Date heure);
	
	@Query("select e from Examen e left join fetch e.clients ecs where ecs.id =:id")
	List<ExamenCode> findByClient (@Param("id")Long id);
	
	@Query("select e from Examen e left join fetch e.serieCd es where es.id =:id")
	Optional<ExamenCode> findBySerieCd (@Param("id")Long id);

}
