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
		SeanceCode seance1 = new SeanceCode(date, null,null,null);
		seance1 = seanceCodeDao.save(seance1);
		int endSize = seanceCodeDao.findByDate(date).size();
		Assertions.assertEquals(1, endSize-startSize);
	}
	@Test
	public void SeanceCodeFindByHeure() {
		Date date = new Date();
		Date heure = new Date();
		int startSize = seanceCodeDao.findByHeure(heure).size();
		SeanceCode seance2 = new SeanceCode(date, heure,null,null);
		seance2 = seanceCodeDao.save(seance2);
		int endSize = seanceCodeDao.findByHeure(heure).size();
		Assertions.assertEquals(1, endSize-startSize);
	}

	@Test
	public void SeanceCodeFindClient() {
		Date date = new Date();
		Date heure = new Date();
		Date dateNaissance = new Date();
		Client randomGuy1 = new Client("Bidulle", "bob", "12 rue nullpart", dateNaissance,null);
		randomGuy1 = clientDao.save(randomGuy1);
		int startSize = seanceCodeDao.findByClient(randomGuy1.getId()).size();
		SeanceCode seance3 = new SeanceCode(date, heure,List.of(randomGuy1),null);
		seance3 = seanceCodeDao.save(seance3);
		int endSize = seanceCodeDao.findByClient(randomGuy1.getId()).size();
		Assertions.assertEquals(1, endSize-startSize);
	}
	@Test
	public void SeanceCodeFindSerieCd() {
		Date date = new Date();
		Date heure = new Date();
		SerieCd serieA = new SerieCd();
		serieA = serieCdDao.save(serieA);
		SeanceCode seance4 = new SeanceCode(date, heure,null,serieA);
		seance4 = seanceCodeDao.save(seance4);
		SeanceCode seanceFind = seanceCodeDao.findBySerieCd(serieA.getId()).get();
		
		Assertions.assertEquals(serieA, seanceFind.getSerieCd());
	}
}
