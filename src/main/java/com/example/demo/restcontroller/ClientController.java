package com.example.demo.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.models.Client;
import com.example.demo.services.ClientService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/client")
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Client> findAll() {
		return this.clientService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Client find(@PathVariable Long id) {
		return this.clientService.findById(id);

	}
	@GetMapping("/nom/{nom}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Client> findByNom(@PathVariable String nom) {
		return this.clientService.findByNom(nom);
	}
	@GetMapping("/prenom/{prenom}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Client> findByPrenom(@PathVariable String prenom) {
		return this.clientService.findByPrenom(prenom);
	}
	@GetMapping("/adresse/{adresse}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Client> findByAdresse(@PathVariable String adresse) {
		return this.clientService.findByAdresse(adresse);
	}
	@GetMapping("/score/{score}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Client> findByScore(@PathVariable Integer score) {
		return this.clientService.findByScore(score);
	}
	@GetMapping("/scoreInf/{scoreInf}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Client> findByScoreInf(@PathVariable Integer scoreInf) {
		return this.clientService.findByScoreInf(scoreInf);
	}
	@GetMapping("/scoreSup/{scoreSup}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Client> findByScoreSup(@PathVariable Integer scoreSup) {
		return this.clientService.findByScoreSup(scoreSup);
	}
	@GetMapping("/moyenne/{clientId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Integer findMoyenne(@PathVariable Long id) {
		return this.clientService.findMoyenne(id);

	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Client create(@RequestBody Client client) {
		return this.clientService.create(client);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Client update(@RequestBody Client client, @PathVariable Long id) {
		if (!id.equals(client.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Imposssible de trouver le client recherche");
		}
		return this.clientService.uptade(client);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		if (clientService.findById(id).equals(null)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le client a mettre a supprimer");
		}
		clientService.delete(id);
	}

}
