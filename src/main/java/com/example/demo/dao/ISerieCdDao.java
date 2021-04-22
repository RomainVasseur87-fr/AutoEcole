package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.SerieCd;

public interface ISerieCdDao extends JpaRepository<SerieCd, Long> {
	
	@Query("select s from SerieCd s left join fetch s.cdRoms scs where scs.id =:id")
	List<SerieCd> findByCdRom(@Param("id")Long id);
	
	@Query("select s from SerieCd s left join fetch s.questions sqs where sqs.id =:id")
	List<SerieCd> findByQuestion(@Param("id")Long id);

}
