package com.company.books.backend.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.company.books.backend.controllers.CategoriaRestController;
import com.company.books.backend.model.Categoria;
import com.company.books.backend.response.CategoriaResponseRest;
import com.company.books.backend.service.ICategoriaService;

public class CategoriaRestControllerTest {
	
	@InjectMocks
	CategoriaRestController categoriaController;
	
	@Mock
	private ICategoriaService service;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void crearTest() {
		//En ambas lineas se genera el contexto para poder hacer una llmada http
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		Categoria categoria = new Categoria(Long.valueOf(1), "Clasico", "Libros clásicos de literatura moderna");
		
		//cuando encuentre este metodo crear mejor dicho cuando llame al metodo crear 
		//y este metodo recibe una clase de tipo categoria le pasara una clase categoria
		//y entonces devuelve(then return) una reponseentity de categoriaresponseRest con un ok 200 http
		when(service.crear(any(Categoria.class))).thenReturn(new ResponseEntity<CategoriaResponseRest>(HttpStatus.OK));
		
		//Aca al usar el objetoCategoriaController y ejecute y entre en la linea donde llame a service 
		//esta no se usará y será usada por lo que declaramos en la línea 47 de esta hoja
		ResponseEntity<CategoriaResponseRest> respuesta = categoriaController.crear(categoria);
		
		assertThat(respuesta.getStatusCode().value()).isEqualTo(200);
	}
}
