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
import com.example.demo.models.Examen;
import com.example.demo.services.ExamenService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/examen")
public class ExamenController {
	
	@Autowired
	private ExamenService examenService;
	
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Examen> findAll() {
		return this.examenService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Examen find(@PathVariable Long id) {
		return this.examenService.findById(id);

	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Examen create(@RequestBody Examen examen) {
		return this.examenService.create(examen);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Examen update(@RequestBody Examen examen, @PathVariable Long id) {
		if (!id.equals(examen.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Imposssible de trouver l examen recherche");
		}
		return this.examenService.uptade(examen);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		if (examenService.findById(id).equals(null)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver l examen a mettre a supprimer");
		}
		examenService.delete(id);
	}

}
