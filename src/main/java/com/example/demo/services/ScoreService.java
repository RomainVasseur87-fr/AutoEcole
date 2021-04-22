package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.dao.IScoreDao;
import com.example.demo.models.Score;

@Service
public class ScoreService {
	
	@Autowired
	private IScoreDao scoreDao;
	
	public List<Score> findAll() {
		return this.scoreDao.findAll();
	}
	
	public Score findById (Long id) {
		Optional<Score> optScore = this.scoreDao.findById(id);
		if (optScore.isPresent()) {
			return optScore.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public Score create(Score score) {
		if (score.getScore()>40) {
			throw new ResponseStatusException (HttpStatus.BAD_REQUEST, "Le score ne peut pas depasser 40");
		}
		return this.scoreDao.save(score);
	}
	
	public Score uptade(Score score) {
		if (!scoreDao.existsById(score.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le score a mettre a jour");
		} else if (score.getScore()>40) {
			throw new ResponseStatusException (HttpStatus.BAD_REQUEST, "Le score ne peut pas depasser 40");
		}
		return this.scoreDao.save(score);
	}
	
	public void delete(Long id) {
		if (!scoreDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le score a mettre a supprimer");
		}
		this.scoreDao.deleteById(id);
		
		if (scoreDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "la suppression du score a echouer");
		}
	}

}

