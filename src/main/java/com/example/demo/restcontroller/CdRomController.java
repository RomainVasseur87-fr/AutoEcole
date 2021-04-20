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

import com.example.demo.models.CdRom;
import com.example.demo.services.CdRomService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/CdRom")
public class CdRomController {
	
	@Autowired
	private CdRomService cdRomService;
	
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<CdRom> findAll() {
		return this.cdRomService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public CdRom find(@PathVariable Long id) {
		return this.cdRomService.findById(id);

	}
	
	@GetMapping("/editeur/{editeur}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<CdRom> findByEditeur(@PathVariable String editeur){
		return this.cdRomService.findByEditeur(editeur);
		
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CdRom create(@RequestBody CdRom cdRom) {
		return this.cdRomService.create(cdRom);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public CdRom update(@RequestBody CdRom cdRom, @PathVariable Long id) {
		if (!id.equals(cdRom.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Imposssible de trouver le CdRom recherche");
		}
		return this.cdRomService.uptade(cdRom);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		if (cdRomService.findById(id).equals(null)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le cd a mettre a supprimer");
		}
		cdRomService.delete(id);

	}

}
