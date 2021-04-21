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
import com.example.demo.models.Score;
import com.example.demo.services.ScoreService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/score")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Score> findAll() {
		return this.scoreService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Score find(@PathVariable Long id) {
		return this.scoreService.findById(id);

	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Score create(@RequestBody Score score) {
		return this.scoreService.create(score);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Score update(@RequestBody Score score, @PathVariable Long id) {
		if (!id.equals(score.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Imposssible de trouver le score recherche");
		}
		return this.scoreService.uptade(score);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		if (scoreService.findById(id).equals(null)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver le score a mettre a supprimer");
		}
		scoreService.delete(id);

	}

}
