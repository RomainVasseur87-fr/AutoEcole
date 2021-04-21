package com.example.demo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.dao.ICdRomDao;
import com.example.demo.dao.ISerieCdDao;
import com.example.demo.models.CdRom;
import com.example.demo.models.SerieCd;


@SpringBootTest
class CdRomDaoTest {

	@Autowired
	private ICdRomDao cdRomDao;
	@Autowired
	private ISerieCdDao serieCdDao;
	
	@Test
	private void cdRomFindByEditeur() {
		int startSize = cdRomDao.findByEditeur("rapido").size();
		CdRom cdRom1 = new CdRom("Rapido");
		cdRom1 = cdRomDao.save(cdRom1);
		int endSize = cdRomDao.findByEditeur("rapido").size();
		Assertions.assertEquals(1, endSize-startSize);
	}
	@Test
	private void cdRomFindBySerieCd() {
		SerieCd serie1 = new SerieCd ();
		serie1 = serieCdDao.save(serie1);
		int startSize = cdRomDao.findBySerieCd(serie1.getId()).size();
		CdRom cdRom1 = new CdRom("Rapido");
		cdRom1.getSeriesCd().add(serie1);
		cdRom1 = cdRomDao.save(cdRom1);
		int endSize = cdRomDao.findBySerieCd(serie1.getId()).size();
		Assertions.assertEquals(1, endSize-startSize);
	}
	

}
