package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.dao.ISerieCdDao;
import com.example.demo.models.SerieCd;

@Service
public class SerieCdService {
	
	@Autowired
	private ISerieCdDao serieCdDao;
	
	public List<SerieCd> findAll() {
		return this.serieCdDao.findAll();
	}
	
	public SerieCd findById (Long id) {
		Optional<SerieCd> optSerieCd = this.serieCdDao.findById(id);
		if (optSerieCd.isPresent()) {
			return optSerieCd.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public SerieCd create(@RequestBody SerieCd serieCd) {
		return this.serieCdDao.save(serieCd);
	}
	
	public SerieCd uptade(@RequestBody SerieCd serieCd) {
		if (!serieCdDao.existsById(serieCd.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a jour");
		}
		return this.serieCdDao.save(serieCd);
	}
	
	public void delete(@PathVariable Long id) {
		if (!serieCdDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a supprimer");
		}
		this.serieCdDao.deleteById(id);
		
		if (serieCdDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "la suppression du cd a echouer");
		}
	}

}
