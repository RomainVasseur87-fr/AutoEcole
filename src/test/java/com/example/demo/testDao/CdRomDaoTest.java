package com.example.demo.testDao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
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
	public void cdRomFindByEditeur() {
		int startSize = cdRomDao.findByEditeur("Rapido").size();
		CdRom cdRom1 = new CdRom("Rapido",null);
		cdRom1 = cdRomDao.save(cdRom1);
		int endSize = cdRomDao.findByEditeur("Rapido").size();
		assertEquals(1, endSize-startSize);
	}
	@Test
	public void cdRomFindBySerieCd() {
		SerieCd serie1 = new SerieCd ();
		serie1 = serieCdDao.save(serie1);
		int startSize = cdRomDao.findBySerieCd(serie1.getId()).size();
		CdRom cdRom1 = new CdRom("Rapido",List.of(serie1));
		cdRom1 = cdRomDao.save(cdRom1);
		int endSize = cdRomDao.findBySerieCd(serie1.getId()).size();
		assertEquals(1, endSize-startSize);
	}
	

}
