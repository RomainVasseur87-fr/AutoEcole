package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	public SeanceCode create(@RequestBody SeanceCode seanceCode) {
		return this.seanceCodeDao.save(seanceCode);
	}
	
	public SeanceCode uptade(@RequestBody SeanceCode seanceCode) {
		if (!seanceCodeDao.existsById(seanceCode.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a jour");
		}
		return this.seanceCodeDao.save(seanceCode);
	}
	
	public void delete(@PathVariable Long id) {
		if (!seanceCodeDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a supprimer");
		}
		this.seanceCodeDao.deleteById(id);
		
		if (seanceCodeDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "la suppression du cd a echouer");
		}
	}

}

