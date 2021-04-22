package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dao.IClientDao;
import com.example.demo.models.Client;
import com.example.demo.models.Score;

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
	public List<Client> findByNom(String nom) {
		return this.clientDao.findByNom(nom);
	}
	public List<Client> findByPrenom(String prenom) {
		return this.clientDao.findByPrenom(prenom);
	}
	public List<Client> findByAdresse(String adresse) {
		return this.clientDao.findByAdresse(adresse);
	}
	public List<Client> findByScore(Integer score) {
		return this.clientDao.findByScore(score);
	}
	public List<Client> findByScoreInf(Integer scoreInf) {
		return this.clientDao.findByScoreInf(scoreInf);
	}
	public List<Client> findByScoreSup(Integer scoreSup) {
		return this.clientDao.findByScoreSup(scoreSup);
	}
	public Integer findMoyenne (Long id) {
		List<Score> scores = findById(id).getScores();
		int somme = 0;
		for (Score score: scores) {
			somme = somme + score.getScore();
		}
		Integer moyenne = somme / scores.size();
		return moyenne;
		
	}
	
	public Client create(Client client) {
		return this.clientDao.save(client);
	}
	
	public Client uptade(Client client) {
		if (!clientDao.existsById(client.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a jour");
		}
		return this.clientDao.save(client);
	}
	
	public void delete(Long id) {
		if (!clientDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a supprimer");
		}
		this.clientDao.deleteById(id);
		
		if (clientDao.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "la suppression du cd a echouer");
		}
	}

}