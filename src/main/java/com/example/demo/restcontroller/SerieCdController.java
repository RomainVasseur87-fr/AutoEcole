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
import com.example.demo.models.SerieCd;
import com.example.demo.services.SerieCdService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/serieCd")
public class SerieCdController {
	@Autowired
	private SerieCdService serieCdService;
	
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<SerieCd> findAll() {
		return this.serieCdService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public SerieCd find(@PathVariable Long id) {
		return this.serieCdService.findById(id);

	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public SerieCd create(@RequestBody SerieCd serieCd) {
		return this.serieCdService.create(serieCd);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public SerieCd update(@RequestBody SerieCd serieCd, @PathVariable Long id) {
		if (!id.equals(serieCd.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Imposssible de trouver la SerieCd recherche");
		}
		return this.serieCdService.uptade(serieCd);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		if (serieCdService.findById(id).equals(null)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver la SerieCd a mettre a supprimer");
		}
		serieCdService.delete(id);
	}

}

