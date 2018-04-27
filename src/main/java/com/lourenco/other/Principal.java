package com.lourenco.other;

public class Principal {

	public static void main(String[] args) {
		 
		ListaVinculada myList = new ListaVinculada();
		
		myList.adicionaNoComeco(19);
		myList.adicionaNoComeco(12); 
		myList.adicionaNoComeco(17);
		myList.adicionaNoComeco(11);
		 
		myList.mostraLista();
				
		myList.removeDoComeco(11); 

		myList.removeDoFim(19);    

		myList.mostraLista();
		 
	}

}
