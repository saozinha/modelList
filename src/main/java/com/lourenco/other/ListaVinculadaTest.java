package com.lourenco.other;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

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
		 Assert.assertThat(myList.tamanho(), CoreMatchers.is(1));
	}
	
	@Test
	@After  
	public void removeElementList() {
		myList.removeDoComeco(12);
		 Assert.assertThat(myList.tamanho(), CoreMatchers.is(1));
	}
	
 
}
