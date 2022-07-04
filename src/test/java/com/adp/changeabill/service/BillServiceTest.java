package com.adp.changeabill.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.adp.changeabill.dto.ChangeResponse;

class BillServiceTest {
	
	@InjectMocks
	private BillService billService;

	@BeforeEach
	void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		ReflectionTestUtils.setField(billService, "quarter", 100);
		
		ReflectionTestUtils.setField(billService, "dime", 100);
		
		ReflectionTestUtils.setField(billService, "nickel", 100);
		
		ReflectionTestUtils.setField(billService, "penny", 100);
	}

	@Test
	void testGetChange() {
		
		ChangeResponse changeResponse = billService.getChange(34);
		
		assertEquals(100, changeResponse.getQuarters());
		
		assertEquals(90, changeResponse.getDimes());
	}
	
	@Test
	void testGetChangeWithNoReturn() {
		
		ChangeResponse changeResponse = billService.getChange(42);
		
		assertEquals(0,changeResponse.getPennies());
	}

	@Test
	void testResetChange() {
		
		ReflectionTestUtils.setField(billService, "quarter", 50);
		
		billService.resetChange();
	}

}
