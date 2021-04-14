package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dao.ICdRomDao;
import com.example.demo.models.CdRom;

@Service
public class CdRomService {
	
	@Autowired
	private ICdRomDao cdRomDao;
	
	public List<CdRom> getAll() {
		return this.cdRomDao.findAll();
	}
	
	public CdRom findById (Long id) {
		Optional<CdRom> optcdRom = this.cdRomDao.findById(id);
		if (optcdRom.isPresent()) {
			return optcdRom.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public CdRom create(@RequestBody CdRom cdRom) {
		return this.cdRomDao.save(cdRom);
	}
	
	public CdRom uptade(@RequestBody CdRom cdRom) {
		return this.cdRomDao.save(cdRom);
	}
	
	public void delete(@PathVariable Long id) {
		this.cdRomDao.deleteById(id);
	}

}
