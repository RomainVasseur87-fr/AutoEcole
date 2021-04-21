package com.example.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Difficulte;
import com.example.demo.models.Question;
import com.example.demo.models.Theme;

public interface IQuestionDao extends JpaRepository<Question, Long> {
	
	@Query("select q from Question q where q.intitule like :motIntitule")
	List<Question> findByIntitule (@Param("motIntitule")String motIntitule);
	
	@Query("select q from Question q where q.reponse like :motReponse")
	List<Question> findByReponse (@Param("motReponse")String motReponse);
	
	@Query("select q from Question q where q.difficulte =:diffulte")
	List<Question> findByDifficulte (@Param("diffulte")Difficulte difficulte);
	
	@Query("select q from Question q where q.theme =:theme")
	List<Question> findByTheme (@Param("theme")Theme theme);

}
