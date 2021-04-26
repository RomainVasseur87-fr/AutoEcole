package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.dao.IQuestionDao;
import com.example.demo.models.Difficulte;
import com.example.demo.models.Question;
import com.example.demo.models.Theme;

@Service
public class QuestionService {
	
	@Autowired
	private IQuestionDao questionDao;
	
	public List<Question> findAll() {
		return this.questionDao.findAll();
	}
	
	public Question findById (Long id) {
		Optional<Question> optQuestion = this.questionDao.findById(id);
		if (optQuestion.isPresent()) {
			return optQuestion.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	public List<Question> findByIntitule(String intitule) {
		return this.questionDao.findByIntitule(intitule);
	}
	public List<Question> findByReponse(String reponse) {
		return this.questionDao.findByReponse(reponse);
	}
	public List<Question> findByDifficulte(String difficulte) {
		//besoin gestion erreur
		Difficulte enumDifficulte = Difficulte.valueOf(difficulte);
		return this.questionDao.findByDifficulte(enumDifficulte);
	}
	public List<Question> findByTheme(String theme) {
		//besoin gestion erreur
		Theme enumTheme = Theme.valueOf(theme);
		return this.questionDao.findByTheme(enumTheme);
	}
	
	public Question create(Question question) {
		return this.questionDao.save(question);
	}
	
	public Question uptade(Question question) {
		if (!questionDao.existsById(question.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a jour");
		}
		return this.questionDao.save(question);
	}
	
	public void delete(Long id) {
		if (!questionDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a supprimer");
		}
		this.questionDao.deleteById(id);
		
		if (questionDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "la suppression du cd a echouer");
		}
	}
}
