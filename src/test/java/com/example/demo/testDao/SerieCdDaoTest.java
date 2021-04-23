package com.example.demo.testDao;


import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.dao.ICdRomDao;
import com.example.demo.dao.IQuestionDao;
import com.example.demo.dao.ISerieCdDao;
import com.example.demo.models.CdRom;
import com.example.demo.models.Question;
import com.example.demo.models.SerieCd;

@SpringBootTest
class SerieCdDaoTest {
	
	@Autowired
	private ISerieCdDao serieCdDao;
	@Autowired
	private ICdRomDao cdRomDao;
	@Autowired
	private IQuestionDao questionDao;

	@Test
	public void SerieCdFindByCdRom() {
		CdRom cdRom1 = new CdRom("Rapido",null);
		cdRom1 = cdRomDao.save(cdRom1);
		int startSize = serieCdDao.findByCdRom(cdRom1.getId()).size();
		SerieCd serieA = new SerieCd(List.of(cdRom1),null);
		serieA = serieCdDao.save(serieA);
		int endSize = serieCdDao.findByCdRom(cdRom1.getId()).size();
		Assertions.assertEquals(1, endSize-startSize);
	}
	@Test
	public void SerieCdFindByQuestion() {
		Question question1 = new Question("Quel est le muscle?", "d la reponse d",null,null);
		question1 = questionDao.save(question1);
		int startSize = serieCdDao.findByQuestion(question1.getId()).size();
		SerieCd serieA = new SerieCd(null, List.of(question1));
		serieA = serieCdDao.save(serieA);
		int endSize = serieCdDao.findByQuestion(question1.getId()).size();
		Assertions.assertEquals(1, endSize-startSize);
	}

}
