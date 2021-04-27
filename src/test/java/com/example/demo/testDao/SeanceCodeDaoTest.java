package com.example.demo.testDao;


import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.dao.IClientDao;
import com.example.demo.dao.ISeanceCodeDao;
import com.example.demo.dao.ISerieCdDao;
import com.example.demo.models.Client;
import com.example.demo.models.Examen;
import com.example.demo.models.Personne;
import com.example.demo.models.SeanceCode;
import com.example.demo.models.SerieCd;

@SpringBootTest
class SeanceCodeDaoTest {
	@Autowired
	private ISeanceCodeDao seanceCodeDao;
	@Autowired
	private IClientDao clientDao;
	@Autowired
	private ISerieCdDao serieCdDao;

	@Test
	public void SeanceCodeFindByDate() {
		Date date = new Date();
		int startSize = seanceCodeDao.findByDate(date).size();
		Examen seance1 = new SeanceCode();
		seance1.setDate(date);
		seance1 = seanceCodeDao.save((SeanceCode)seance1);
		int endSize = seanceCodeDao.findByDate(date).size();
		Assertions.assertEquals(1, endSize-startSize);
	}
	@Test
	public void SeanceCodeFindByHeure() {
		Date date = new Date();
		Date heure = new Date();
		int startSize = seanceCodeDao.findByHeure(heure).size();
		Examen seance2 = new SeanceCode();
		seance2.setDate(date);
		seance2.setHeure(heure);
		seance2 = seanceCodeDao.save((SeanceCode)seance2);
		int endSize = seanceCodeDao.findByHeure(heure).size();
		Assertions.assertEquals(1, endSize-startSize);
	}

	@Test
	public void SeanceCodeFindClient() {
		Date date = new Date();
		Date heure = new Date();
		Date dateNaissance = new Date();
		Personne randomGuy1 = new Client(null);
		randomGuy1.setNom("Bidulle");
		randomGuy1.setPrenom("bob");
		randomGuy1.setDateDeNaissance(dateNaissance);
		randomGuy1.setAdresse("12 rue nullpart");
		randomGuy1 = clientDao.save((Client)randomGuy1);
		int startSize = seanceCodeDao.findByClient(randomGuy1.getId()).size();
		Examen seance3 = new SeanceCode();
		seance3.setDate(date);
		seance3.setHeure(heure);
		seance3.setClients(List.of((Client)randomGuy1));
		seance3 = seanceCodeDao.save((SeanceCode)seance3);
		int endSize = seanceCodeDao.findByClient(randomGuy1.getId()).size();
		Assertions.assertEquals(1, endSize-startSize);
	}
	@Test
	public void SeanceCodeFindSerieCd() {
		Date date = new Date();
		Date heure = new Date();
		SerieCd serieA = new SerieCd();
		serieA = serieCdDao.save(serieA);
		Examen seance4 = new SeanceCode();
		seance4.setDate(date);
		seance4.setHeure(heure);
		seance4.setSerieCd(serieA);
		seance4 = seanceCodeDao.save((SeanceCode)seance4);
		SeanceCode seanceFind = seanceCodeDao.findBySerieCd(serieA.getId()).get();
		
		Assertions.assertEquals(serieA, seanceFind.getSerieCd());
	}
}
