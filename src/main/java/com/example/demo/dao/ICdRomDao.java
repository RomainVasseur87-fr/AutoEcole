package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.CdRom;

public interface ICdRomDao extends JpaRepository<CdRom, Long> {
	
	@Query("select c from CdRom c where c.editeur =:editeur")
	List<CdRom> findByEditeur (@Param("editeur")String editeur);
	
	
	@Query("select c from CdRom c left join fetch c.seriesCd s where s.id =:id")
	List<CdRom> findBySerieCd (@Param("id")Long id);
	

}
