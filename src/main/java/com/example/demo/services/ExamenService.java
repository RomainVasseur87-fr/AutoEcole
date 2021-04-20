package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.dao.IExamenDao;
import com.example.demo.models.Examen;

@Service
public class ExamenService {
	
	@Autowired
	private IExamenDao examenDao;
	
	public List<Examen> findAll() {
		return this.examenDao.findAll();
	}
	
	public Examen findById (Long id) {
		Optional<Examen> optExamen = this.examenDao.findById(id);
		if (optExamen.isPresent()) {
			return optExamen.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public Examen create(@RequestBody Examen examen) {
		return this.examenDao.save(examen);
	}
	
	public Examen uptade(@RequestBody Examen examen) {
		if (!examenDao.existsById(examen.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a jour");
		}
		return this.examenDao.save(examen);
	}
	
	public void delete(@PathVariable Long id) {
		if (!examenDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a supprimer");
		}
		this.examenDao.deleteById(id);
		
		if (examenDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "la suppression du cd a echouer");
		}
	}

}