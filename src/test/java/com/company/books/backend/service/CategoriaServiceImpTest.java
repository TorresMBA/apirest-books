package com.company.books.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.company.books.backend.model.Categoria;
import com.company.books.backend.model.dao.ICategoriaDao;
import com.company.books.backend.response.CategoriaResponseRest;

public class CategoriaServiceImpTest {
	
	//Al tener esta anotacion @InjectMocks quiere decir que va a inyectar
	//todas las clases y dependecias que tengan la anotacion @Mock
	@InjectMocks
	CategoriaServiceImpl service;
	
	//La anotacion @Mock indica a mockito que emule la dependencia que tiene esta clase
	@Mock
	ICategoriaDao categoriaDao;
	
	List<Categoria> lista = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		this.cargarCategorias();
	}
	
	@Test
	public void buscarCategoriaTest() {
		/**
		 * Con el metodo de mockito when evaluamos si categoriaDao que es nuestra dependencia
		 * de categoriaServiceImpl 
		 */
		when(categoriaDao.findAll()).thenReturn(lista);
		
		ResponseEntity<CategoriaResponseRest> response = service.buscarCategorias();
		
		//4 hace referencia a los 4 datos en duro que tenemos
		assertEquals(4, response.getBody().getCategoriaResponse().getCategoria().size());
		
		/**
		 * Verificamos que en categoriaDao se a llamado al findall por una vez
		 */
		verify(categoriaDao, times(1)).findAll();
	}
	
	public void cargarCategorias() {
		Categoria cat1 = new Categoria(Long.valueOf(1), "Abarrotes", "Distintos abarrotes");
		Categoria cat2 = new Categoria(Long.valueOf(1), "Lacteos", "Distintos Lacteos");
		Categoria cat3 = new Categoria(Long.valueOf(1), "Bebidas", "Distintos bebidas");
		Categoria cat4 = new Categoria(Long.valueOf(1), "Carnes", "Distintos carnes");
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		lista.add(cat4);
	}
}
