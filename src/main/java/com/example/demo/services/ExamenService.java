package com.example.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.dao.IExamenDao;
import com.example.demo.models.ExamenCode;

@Service
public class ExamenService {
	
	@Autowired
	private IExamenDao examenDao;
	
	public List<ExamenCode> findAll() {
		return this.examenDao.findAll();
	}
	
	public ExamenCode findById (Long id) {
		Optional<ExamenCode> optExamen = this.examenDao.findById(id);
		if (optExamen.isPresent()) {
			return optExamen.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	public List<ExamenCode> findByDate(Date date) {
		return this.examenDao.findByDate(date);
	}
	public List<ExamenCode> findByHeure(Date heure) {
		return this.examenDao.findByHeure(heure);
	}
	public List<ExamenCode> findByClient(Long id) {
		return this.examenDao.findByClient(id);
	}
	public ExamenCode findBySerieCd(Long id) {
		if (!examenDao.findBySerieCd(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver l'examen qui presente cette serieCd");
		}
		return this.examenDao.findBySerieCd(id).get();
	}
	
	public ExamenCode create(ExamenCode examen) {
		return this.examenDao.save(examen);
	}
	
	public ExamenCode uptade(ExamenCode examen) {
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