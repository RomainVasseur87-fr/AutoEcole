package com.example.demo.restcontroller;

import java.util.Date;
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
import com.example.demo.models.ExamenCode;
import com.example.demo.services.ExamenService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/examen")
public class ExamenController {
	
	@Autowired
	private ExamenService examenService;
	
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<ExamenCode> findAll() {
		return this.examenService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ExamenCode find(@PathVariable Long id) {
		return this.examenService.findById(id);

	}
	
	@GetMapping("/date/{date}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<ExamenCode> findDate(@PathVariable Date date) {
		return this.examenService.findByDate(date);
	}
	@GetMapping("/heure/{heure}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<ExamenCode> findHeure(@PathVariable Date heure) {
		return this.examenService.findByHeure(heure);
	}
	@GetMapping("/client/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<ExamenCode> findClient(@PathVariable Long id) {
		return this.examenService.findByClient(id);
	}
	@GetMapping("/serieCd/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ExamenCode findBySerieCd(@PathVariable Long id) {
		return this.examenService.findBySerieCd(id);

	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ExamenCode create(@RequestBody ExamenCode examen) {
		return this.examenService.create(examen);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ExamenCode update(@RequestBody ExamenCode examen, @PathVariable Long id) {
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
