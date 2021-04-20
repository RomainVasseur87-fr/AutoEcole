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
import com.example.demo.models.SeanceCode;
import com.example.demo.services.SeanceCodeService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/seanceCode")
public class SeanceCodeController {

	@Autowired
	private SeanceCodeService seanceCodeService;
	
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<SeanceCode> findAll() {
		return this.seanceCodeService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public SeanceCode find(@PathVariable Long id) {
		return this.seanceCodeService.findById(id);

	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public SeanceCode create(@RequestBody SeanceCode seanceCode) {
		return this.seanceCodeService.create(seanceCode);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public SeanceCode update(@RequestBody SeanceCode seanceCode, @PathVariable Long id) {
		if (!id.equals(seanceCode.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Imposssible de trouver la seance de code recherche");
		}
		return this.seanceCodeService.uptade(seanceCode);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		if (seanceCodeService.findById(id).equals(null)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver la Seance de code a mettre a supprimer");
		}
		seanceCodeService.delete(id);
	}

}

