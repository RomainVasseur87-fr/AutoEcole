package com.example.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.dao.ISeanceCodeDao;
import com.example.demo.models.SeanceCode;

@Service
public class SeanceCodeService {
	
	@Autowired
	private ISeanceCodeDao seanceCodeDao;
	
	public List<SeanceCode> findAll() {
		return this.seanceCodeDao.findAll();
	}
	
	public SeanceCode findById (Long id) {
		Optional<SeanceCode> optSeanceCode = this.seanceCodeDao.findById(id);
		if (optSeanceCode.isPresent()) {
			return optSeanceCode.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	public List<SeanceCode> findByDate(Date date) {
		return this.seanceCodeDao.findByDate(date);
	}
	public List<SeanceCode> findByHeure(Date heure) {
		return this.seanceCodeDao.findByHeure(heure);
	}
	public List<SeanceCode> findByClient(Long id) {
		return this.seanceCodeDao.findByClient(id);
	}
	public SeanceCode findBySerieCd(Long id) {
		if (!seanceCodeDao.findBySerieCd(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver la seance de code qui presente cette serieCd");
		}
		return this.seanceCodeDao.findBySerieCd(id).get();
	}
	
	public SeanceCode create(SeanceCode seanceCode) {
		return this.seanceCodeDao.save(seanceCode);
	}
	
	public SeanceCode uptade(SeanceCode seanceCode) {
		if (!seanceCodeDao.existsById(seanceCode.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a jour");
		}
		return this.seanceCodeDao.save(seanceCode);
	}
	
	public void delete(Long id) {
		if (!seanceCodeDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a supprimer");
		}
		this.seanceCodeDao.deleteById(id);
		
		if (seanceCodeDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "la suppression du cd a echouer");
		}
	}

}

