package com.example.demo.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.models.SeanceCode;

public interface ISeanceCodeDao extends JpaRepository<SeanceCode, Long> {
	
	@Query("select s from SeanceCode s where s.date =:date")
	List<SeanceCode> findByDate (@Param("date")Date date);
	
	@Query("select s from SeanceCode s where s.heure =:heure")
	List<SeanceCode> findByHeure (@Param("heure")Date heure);
	
	@Query("select s from SeanceCode s left join fetch s.clients scs where scs.id =:id")
	List<SeanceCode> findByClient (@Param("id")Long id);
	
	@Query("select s from SeanceCode s left join fetch s.serieCd ss where ss.id =:id")
	Optional<SeanceCode> findBySerieCd (@Param("id")Long id);

}
