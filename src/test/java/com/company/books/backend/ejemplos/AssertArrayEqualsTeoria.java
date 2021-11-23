package com.company.books.backend.ejemplos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class AssertArrayEqualsTeoria {

	@Test
	public void pruebaArreglo() {
		String[] arre1 = { "a", "b" };
		String[] arre2 = { "a", "b" };
		
		assertArrayEquals(arre1, arre2);
		
//		assertArrayEquals(arre1, arre3);
//		
//		assertArrayEquals(arre2, arre3);
	}
}
