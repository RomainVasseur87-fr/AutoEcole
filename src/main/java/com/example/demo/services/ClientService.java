package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dao.IClientDao;
import com.example.demo.models.Client;

@Service
public class ClientService {
	
	@Autowired
	private IClientDao clientDao;
	
	public List<Client> findAll() {
		return this.clientDao.findAll();
	}
	
	public Client findById (Long id) {
		Optional<Client> optClient = this.clientDao.findById(id);
		if (optClient.isPresent()) {
			return optClient.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public Client create(@RequestBody Client client) {
		return this.clientDao.save(client);
	}
	
	public Client uptade(@RequestBody Client client) {
		if (!clientDao.existsById(client.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a jour");
		}
		return this.clientDao.save(client);
	}
	
	public void delete(@PathVariable Long id) {
		if (!clientDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a supprimer");
		}
		this.clientDao.deleteById(id);
		
		if (clientDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "la suppression du cd a echouer");
		}
	}

}