package com.example.demo;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demo.dao.ICdRomDao;
import com.example.demo.models.CdRom;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
public class CdRomTestController {
	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ICdRomDao cdRomDao;
	@Test
	public void cdRomGet() throws Exception {
		mockMvc.perform(get("/api/cdRom")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void cdRomGetFindById() throws Exception {
		CdRom cdRom1 = new CdRom("Rapido");
		cdRom1 = cdRomDao.save(cdRom1);

		mockMvc.perform(get("/api/cdRom/" + cdRom1.getId()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.editeur").value("Rapido"));
	}

	@Test
	public void cdRomPost() throws Exception {
		CdRom cdRom1 = new CdRom("Rapido");

		ObjectMapper mapper = new ObjectMapper();
		String jsonCdRom = mapper.writeValueAsString(cdRom1);

		mockMvc.perform(post("/api/cdRom").contentType(MediaType.APPLICATION_JSON).content(jsonCdRom))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.editeur").value("Rapido"));

	}

	@Test
	public void cdRomGetFindByEditeur() throws Exception {
		int sizeStart = cdRomDao.findByEditeur("Rapido").size();

		CdRom cdRom1 = new CdRom("Rapido");
		cdRom1 = cdRomDao.save(cdRom1);

		CdRom cdRom2 = new CdRom("Tutute");
		cdRom2 = cdRomDao.save(cdRom2);

		CdRom cdRom3 = new CdRom("Rapido");
		cdRom3 = cdRomDao.save(cdRom3);

		mockMvc.perform(get("/api/cdRom/editeur/Rapido")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.length()").value(sizeStart + 2));
	}

	
	@Test
	public void cdRomPut() throws Exception {
		CdRom cdRom1 = new CdRom(1L, "Rapido");
		cdRom1 = cdRomDao.save(cdRom1);

		ObjectMapper mapper = new ObjectMapper();
		String jsonCdRom = mapper.writeValueAsString(cdRom1);

		mockMvc.perform(
				put("/api/cdRom/" + cdRom1.getId()).contentType(MediaType.APPLICATION_JSON).content(jsonCdRom))
				.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(notNullValue())))
				.andExpect(jsonPath("$.edition").value("Rapido"));

	}
	@Test
	public void cdRomDelete() throws Exception {
		CdRom cdRom1 = new CdRom(1L, "Rapido");
		cdRom1 = cdRomDao.save(cdRom1);

		int startSize = cdRomDao.findAll().size();

		mockMvc.perform(delete("/api/cdRom/" + cdRom1.getId())).andExpect(status().isOk());

		int endSize = cdRomDao.findAll().size();
		Assertions.assertEquals(-1, endSize - startSize);
	}

}