package com.persistent.tourism;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.persistent.tourism.entities.Pack;
import com.persistent.tourism.repos.PackageRepository;
import com.persistent.tourism.services.PackageService;

@SpringBootTest(classes=com.persistent.tourism.main.Demo1Application.class)
public class PackTest {

	Pack pack;
	
	@Autowired
	PackageService pl;
	
	@MockBean
	PackageRepository packageRepository;
	
	@Before
	public void createPackage() {
		pack = new Pack();
		pack.setDestinationCity("Delhi");
		pack.setCost(10000);
		pack.setDays(13);
		pack.setSourceCity("Leh");
	}
	@Test
	public void testPack() {
		
		Mockito.when(packageRepository.save(pack)).thenReturn(pack);
		pl.savePack(pack);
		Mockito.verify(packageRepository).save(pack);
		
	}
}
