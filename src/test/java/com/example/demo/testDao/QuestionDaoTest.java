package com.example.demo.testDao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.dao.IQuestionDao;
import com.example.demo.models.Difficulte;
import com.example.demo.models.Question;
import com.example.demo.models.Theme;

@SpringBootTest
class QuestionDaoTest {
	
	@Autowired
	private IQuestionDao questionDao;

	@Test
	public void questionFindByIntitule() {
		int startSize = questionDao.findByIntitule("Quel est le muscle?").size();
		Question question1 = new Question("Quel est le muscle?", "d la reponse d",null,null);
		question1 = questionDao.save(question1);
		int endSize = questionDao.findByIntitule("Quel est le muscle?").size();
		Assertions.assertEquals(1, endSize-startSize);
	}
	@Test
	public void questionFindByReponse() {
		int startSize = questionDao.findByReponse("d la reponse d").size();
		Question question2 = new Question("Quel est le muscle?", "d la reponse d",null,null);
		question2 = questionDao.save(question2);
		int endSize = questionDao.findByReponse("d la reponse d").size();
		Assertions.assertEquals(1, endSize-startSize);
	}
	@Test
	public void questionFindByDifficulte() {
		int startSize = questionDao.findByDifficulte(Difficulte.valueOf("Facile")).size();
		Question question3 = new Question("Quel est le muscle?", "d la reponse d",Difficulte.valueOf("Facile"),null);
		question3 = questionDao.save(question3);
		int endSize = questionDao.findByDifficulte(Difficulte.valueOf("Facile")).size();
		Assertions.assertEquals(1, endSize-startSize);
	}
	@Test
	public void questionFindByTheme() {
		int startSize = questionDao.findByTheme(Theme.valueOf("Signalisation")).size();
		Question question4 = new Question("Quel est le muscle?", "d la reponse d",Difficulte.valueOf("Facile"),Theme.valueOf("Signalisation"));
		question4 = questionDao.save(question4);
		int endSize = questionDao.findByTheme(Theme.valueOf("Signalisation")).size();
		Assertions.assertEquals(1, endSize-startSize);
	}
	

}
