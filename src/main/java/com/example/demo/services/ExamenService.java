package com.example.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
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
	public List<Examen> findByDate(Date date) {
		return this.examenDao.findByDate(date);
	}
	public List<Examen> findByHeure(Date heure) {
		return this.examenDao.findByHeure(heure);
	}
	public List<Examen> findByClient(Long id) {
		return this.examenDao.findByClient(id);
	}
	public Examen findBySerieCd(Long id) {
		if (!examenDao.findBySerieCd(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver l'examen qui presente cette serieCd");
		}
		return this.examenDao.findBySerieCd(id).get();
	}
	
	public Examen create(Examen examen) {
		return this.examenDao.save(examen);
	}
	
	public Examen uptade(Examen examen) {
		if (!examenDao.existsById(examen.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a jour");
		}
		return this.examenDao.save(examen);
	}
	
	public void delete(Long id) {
		if (!examenDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a supprimer");
		}
		this.examenDao.deleteById(id);
		
		if (examenDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "la suppression du cd a echouer");
		}
	}

}