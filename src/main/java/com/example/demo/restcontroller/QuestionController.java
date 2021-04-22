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
import com.example.demo.models.Question;
import com.example.demo.services.QuestionService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Question> findAll() {
		return this.questionService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Question find(@PathVariable Long id) {
		return this.questionService.findById(id);

	}
	@GetMapping("/intitule/{intitule}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Question> findByIntitule(@PathVariable String intitule) {
		return this.questionService.findByIntitule(intitule);
	}
	@GetMapping("/reponse/{reponse}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Question> findByReponse(@PathVariable String reponse) {
		return this.questionService.findByIntitule(reponse);
	}
	@GetMapping("/difficulte/{difficulte}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Question> findByDifficulte(@PathVariable String difficulte) {
		return this.questionService.findByDifficulte(difficulte);
	}
	@GetMapping("/theme/{theme}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Question> findByTheme(@PathVariable String theme) {
		return this.questionService.findByTheme(theme);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Question create(@RequestBody Question question) {
		return this.questionService.create(question);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Question update(@RequestBody Question question, @PathVariable Long id) {
		if (!id.equals(question.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Imposssible de trouver la question recherche");
		}
		return this.questionService.uptade(question);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		if (questionService.findById(id).equals(null)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "impossible de trouver la question a mettre a supprimer");
		}
		questionService.delete(id);
	}

}
