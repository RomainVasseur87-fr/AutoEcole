package com.example.demo.testDao;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.dao.IClientDao;
import com.example.demo.dao.IScoreDao;
import com.example.demo.models.Client;
import com.example.demo.models.Personne;
import com.example.demo.models.Score;

@SpringBootTest
class ClientDaoTest {
	
	@Autowired
	private IClientDao clientDao;
	@Autowired
	private IScoreDao scoreDao;

	@Test
	public void ClientFindByNom() {
		int startSize = clientDao.findByNom("Bidulle").size();
		Date date = new Date();
		Personne randomGuy1 = new Client(null);
		randomGuy1.setNom("Bidulle");
		randomGuy1.setPrenom("bob");
		randomGuy1.setDateDeNaissance(date);
		randomGuy1.setAdresse("12 rue nullpart");
		randomGuy1 = clientDao.save((Client)randomGuy1);
		int endSize = clientDao.findByNom("Bidulle").size();
		assertEquals(1, endSize-startSize);
	}
	@Test
	public void ClientFindByPrenom() {
		int startSize = clientDao.findByPrenom("bob").size();
		Date date = new Date();
		Personne randomGuy1 = new Client(null);
		randomGuy1.setNom("Bidulle");
		randomGuy1.setPrenom("bob");
		randomGuy1.setDateDeNaissance(date);
		randomGuy1.setAdresse("12 rue nullpart");
		randomGuy1 = clientDao.save((Client)randomGuy1);
		int endSize = clientDao.findByPrenom("bob").size();
		assertEquals(1, endSize-startSize);
	}
	@Test
	public void ClientFindByAdresse() {
		int startSize = clientDao.findByAdresse("12 rue nullpart").size();
		Date date = new Date();
		Personne randomGuy1 = new Client(null);
		randomGuy1.setNom("Bidulle");
		randomGuy1.setPrenom("bob");
		randomGuy1.setDateDeNaissance(date);
		randomGuy1.setAdresse("12 rue nullpart");
		randomGuy1 = clientDao.save((Client)randomGuy1);
		int endSize = clientDao.findByAdresse("12 rue nullpart").size();
		assertEquals(1, endSize-startSize);
	}
	@Test
	public void ClientFindByScore() {
		int startSize = clientDao.findByScore(33).size();
		Date date = new Date();
		Score result1 = new Score(22);
		result1 = scoreDao.save(result1);
		Score result2 = new Score(33);
		result2 = scoreDao.save(result2);
		Score result3 = new Score(42);
		result3 = scoreDao.save(result3);
		List<Score> scores = List.of(result1,result2,result3);
		Personne randomGuy1 = new Client(scores);
		randomGuy1.setNom("Bidulle");
		randomGuy1.setPrenom("bob");
		randomGuy1.setDateDeNaissance(date);
		randomGuy1.setAdresse("12 rue nullpart");
		randomGuy1 = clientDao.save((Client)randomGuy1);
		int endSize = clientDao.findByScore(33).size();
		assertEquals(1, endSize-startSize);
	}
	@Test
	public void ClientFindByScoreInf() {
		int startSize = clientDao.findByScoreInf(33).size();
		Date date = new Date();
		Score result1 = new Score(22);
		result1 = scoreDao.save(result1);
		Score result2 = new Score(33);
		result2 = scoreDao.save(result2);
		Score result3 = new Score(42);
		result3 = scoreDao.save(result3);
		List<Score> scores = List.of(result1,result2,result3);
		Personne randomGuy1 = new Client(scores);
		randomGuy1.setNom("Bidulle");
		randomGuy1.setPrenom("bob");
		randomGuy1.setDateDeNaissance(date);
		randomGuy1.setAdresse("12 rue nullpart");
		randomGuy1 = clientDao.save((Client)randomGuy1);
		List<Score> scoresInf = List.of(result3, result3);
		Personne randomGuy2 = new Client(scoresInf);
		randomGuy1.setNom("Bidulle");
		randomGuy1.setPrenom("bob");
		randomGuy1.setDateDeNaissance(date);
		randomGuy1.setAdresse("12 rue nullpart");
		randomGuy1 = clientDao.save((Client)randomGuy2);;
		int endSize = clientDao.findByScoreInf(33).size();
		assertEquals(1, endSize-startSize);
	}
	@Test
	public void ClientFindByScoreSup() {
		int startSize = clientDao.findByScore(33).size();
		Date date = new Date();
		Score result1 = new Score(22);
		result1 = scoreDao.save(result1);
		Score result2 = new Score(33);
		result2 = scoreDao.save(result2);
		Score result3 = new Score(42);
		result3 = scoreDao.save(result3);
		List<Score> scores = List.of(result1,result2,result3);
		Personne randomGuy1 = new Client(scores);
		randomGuy1.setNom("Bidulle");
		randomGuy1.setPrenom("bob");
		randomGuy1.setDateDeNaissance(date);
		randomGuy1.setAdresse("12 rue nullpart");
		randomGuy1 = clientDao.save((Client)randomGuy1);
		List<Score> scoresSup = List.of(result1, result1);
		Personne randomGuy2 = new Client(scoresSup);
		randomGuy1.setNom("Bidulle");
		randomGuy1.setPrenom("bob");
		randomGuy1.setDateDeNaissance(date);
		randomGuy1.setAdresse("12 rue nullpart");
		randomGuy1 = clientDao.save((Client)randomGuy2);
		int endSize = clientDao.findByScoreSup(33).size();
		assertEquals(1, endSize-startSize);
	}

}
