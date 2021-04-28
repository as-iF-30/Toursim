package com.persistent.tourism;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.persistent.tourism.controller.PackageController;
import com.persistent.tourism.controller.WebAppController;

@SpringBootTest(classes=com.persistent.tourism.main.Demo1Application.class)
public class SmokeTest {
	
	@Autowired
	private WebAppController webController;
	
	@Autowired
	private PackageController packController;
	
	@Test
	void contextLoadswc() {
		assertThat(webController).isNotNull();
	}
	@Test
	void contextLoadspc() {
		assertThat(packController).isNotNull();
	}
	
}