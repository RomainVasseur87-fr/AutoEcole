package com.example.demo.testDao;

import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.dao.IClientDao;
import com.example.demo.dao.IExamenDao;
import com.example.demo.dao.ISerieCdDao;
import com.example.demo.models.Client;
import com.example.demo.models.Examen;
import com.example.demo.models.SerieCd;

@SpringBootTest
class ExamenDaoTest {
	
	@Autowired
	private IExamenDao examenDao;
	@Autowired
	private IClientDao clientDao;
	@Autowired
	private ISerieCdDao serieCdDao;

	@Test
	public void ExamenFindByDate() {
		Date date = new Date();
		int startSize = examenDao.findByDate(date).size();
		Examen exam1 = new Examen(date, null,null,null);
		exam1 = examenDao.save(exam1);
		int endSize = examenDao.findByDate(date).size();
		Assertions.assertEquals(1, endSize-startSize);
	}
	@Test
	public void ExamenFindByHeure() {
		Date date = new Date();
		Date heure = new Date();
		int startSize = examenDao.findByHeure(heure).size();
		Examen exam1 = new Examen(date, heure,null,null);
		exam1 = examenDao.save(exam1);
		int endSize = examenDao.findByHeure(heure).size();
		Assertions.assertEquals(1, endSize-startSize);
	}

	@Test
	public void ExamenFindClient() {
		Date date = new Date();
		Date heure = new Date();
		Date dateNaissance = new Date();
		Client randomGuy1 = new Client("Bidulle", "bob", "12 rue nullpart", dateNaissance,null);
		randomGuy1 = clientDao.save(randomGuy1);
		int startSize = examenDao.findByClient(randomGuy1.getId()).size();
		Examen exam1 = new Examen(date, heure,List.of(randomGuy1),null);
		exam1 = examenDao.save(exam1);
		int endSize = examenDao.findByClient(randomGuy1.getId()).size();
		Assertions.assertEquals(1, endSize-startSize);
	}
	@Test
	public void ExamenFindSerieCd() {
		Date date = new Date();
		Date heure = new Date();
		SerieCd serieA = new SerieCd();
		serieA = serieCdDao.save(serieA);
		Examen exam1 = new Examen(date, heure,null,serieA);
		exam1 = examenDao.save(exam1);
		Examen examFind = examenDao.findBySerieCd(serieA.getId()).get();
		
		Assertions.assertEquals(serieA, examFind.getSerieCd());
	}

}
