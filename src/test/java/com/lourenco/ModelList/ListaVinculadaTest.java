package com.lourenco.ModelList;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.lourenco.other.ListaVinculada;

/**
 * @author conceicao.lourenco
 * 
 *         Class to test {@link ListaVinculada}
 */
public class ListaVinculadaTest {

	ListaVinculada myList = new ListaVinculada();

	@Rule
	public ErrorCollector error = new ErrorCollector();

 

	@Test
	@Before
	public void addElementInList() {
		myList.adicionaNoComeco(13);
		myList.adicionaNoComeco(12);
		myList.adicionaNoComeco(33);
		myList.adicionaNoComeco(11);
		 Assert.assertThat(myList.tamanho() != 0, CoreMatchers.is(true));
	}
	
	@Test 
	@After  
	public void removeElementStartList() {
		// Deve retornar false, pois elemento 10 não existe 
		 Assert.assertThat(myList.removeDoComeco(10), CoreMatchers.is(false));
	}
	
	@Test
	@After  
	public void removeElementEndList() {
		 // Deve retornar true , pois o elemento 33 existe e pode ser removido
		 Assert.assertThat(myList.removeDoFim(33), CoreMatchers.is(true));
	}
	
 
}
