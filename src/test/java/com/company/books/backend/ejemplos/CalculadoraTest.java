package com.company.books.backend.ejemplos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	
	Calculadora calc;
	
	/**
	 * Esta anotacion se va ajecutar por unica al principoi de la prueba unitaria
	 */
	@BeforeAll
	public static void primero() {
		System.out.println("primero");
	}
	
	/*
	 * Esta anotacion se va ejecutar por unica vez pero al final de las pruebas unitarias
	 */
	@AfterAll
	public static void ultimo() {
		System.out.println("ultimo");
	}
	
	/**
	 * Con esta anotacion se va ejecutar antes de cada pruebae unitaria 
	 * se ejecutará este metodo
	 */
	@BeforeEach
	public void instanciaObjeto() {
		 calc = new Calculadora();
		 System.out.println("@BeforeEach");
	}
	
	/*
	 * Con esta anotacion se va a ejcutar cada vez que se termine
	 * una prueba unitaria
	 */
	@AfterEach
	public void despuesTest() {
		System.out.println("@AfterBeach");
	}
	
	@Test
	public void calculadoraAssertEqualTest() {
		assertEquals(2, calc.sumar(1, 1));
		assertEquals(3, calc.restar(4, 1));
		assertEquals(25, calc.multiplicar(5, 5));
		assertEquals(100, calc.dividir(1000, 10));
		
		System.out.println("AssertEqual");
	}
	
	@Test
	@DisplayName("prueba unitaria que ocupa assertEqual")//Nos ayuda a dar uns descripcion
	@Disabled("Esta prueba no se ejecutara")//Es para que no se ejecute el test
	public void calculadoraTrueFalse() {
		assertTrue(calc.sumar(1, 1) == 2);
		assertTrue(calc.restar(20, 5) == 15);
		assertFalse(calc.multiplicar(4, 5) == 19);
		assertFalse(calc.dividir(4, 2) == 1);
		
		System.out.println("AssertTrue");
	}
}
