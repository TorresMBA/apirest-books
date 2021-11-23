package com.company.books.backend.ejemplos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AssertTrueFalseTeoria {
	
	@Test
	public void test1() {
		assertTrue(true);
		assertFalse(false);
	}
	
	@Test
	public void test2() {
		boolean expresion = true;
		assertTrue(expresion);
	}
}
