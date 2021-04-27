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
import com.example.demo.models.ExamenCode;
import com.example.demo.models.Personne;
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
		Examen exam1 = new ExamenCode();
		exam1.setDate(date);
		exam1 = examenDao.save((ExamenCode)exam1);
		int endSize = examenDao.findByDate(date).size();
		Assertions.assertEquals(1, endSize-startSize);
	}
	@Test
	public void ExamenFindByHeure() {
		Date date = new Date();
		Date heure = new Date();
		int startSize = examenDao.findByHeure(heure).size();
		Examen exam1 = new ExamenCode();
		exam1.setDate(date);
		exam1.setHeure(heure);
		exam1 = examenDao.save((ExamenCode)exam1);
		int endSize = examenDao.findByHeure(heure).size();
		Assertions.assertEquals(1, endSize-startSize);
	}

	@Test
	public void ExamenFindClient() {
		Date date = new Date();
		Date heure = new Date();
		Date dateNaissance = new Date();
		Personne randomGuy1 = new Client(null);
		randomGuy1.setNom("Bidulle");
		randomGuy1.setPrenom("bob");
		randomGuy1.setDateDeNaissance(dateNaissance);
		randomGuy1.setAdresse("12 rue nullpart");
		randomGuy1 = clientDao.save((Client)randomGuy1);
		int startSize = examenDao.findByClient(randomGuy1.getId()).size();
		Examen exam1 = new ExamenCode();
		exam1.setClients(List.of((Client)randomGuy1));
		exam1.setDate(date);
		exam1.setHeure(heure);
		exam1 = examenDao.save((ExamenCode)exam1);
		int endSize = examenDao.findByClient(randomGuy1.getId()).size();
		Assertions.assertEquals(1, endSize-startSize);
	}
	@Test
	public void ExamenFindSerieCd() {
		Date date = new Date();
		Date heure = new Date();
		SerieCd serieA = new SerieCd();
		serieA = serieCdDao.save(serieA);
		Examen exam1 = new ExamenCode();
		exam1.setSerieCd(serieA);
		exam1.setDate(date);
		exam1.setHeure(heure);
		exam1 = examenDao.save((ExamenCode)exam1);
		ExamenCode examFind = examenDao.findBySerieCd(serieA.getId()).get();
		
		Assertions.assertEquals(serieA, examFind.getSerieCd());
	}

}
