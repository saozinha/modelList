package com.lourenco.other;

/**
 * @author conceicao.lourenco
 * 
 */
public class ListaVinculada {

	private Celula primeira;

	private Celula ultima;

	private int totalDeElementos;

	public void adiciona(Object elemento) {

		if (this.totalDeElementos == 0) {
			this.adicionaNoComeco(elemento);
		} else {
			Celula nova = new Celula(elemento);
			this.ultima.setProxima(nova);
			this.ultima = nova;
			this.totalDeElementos++;
		}
	}

	public int tamanho() {
		return totalDeElementos;
	}

	public boolean contem(Object elemento) {

		Celula atual = null;
		boolean result = false;

		if (this.primeira != null)
			atual = this.primeira;
		else
			atual = this.ultima;

		while (atual != null) {
			if (atual.getElemento().equals(elemento)) {
				result = atual.getElemento().equals(elemento);
				break;
			}
			atual = atual.getProxima();
		}
		return result;
	}

	public void adicionaNoComeco(Object elemento) {

		Celula nova = new Celula(this.primeira, elemento);
		this.primeira = nova;

		if (this.totalDeElementos == 0) {
			// caso especial da lista vazia
			this.ultima = this.primeira;
		}
		this.totalDeElementos++;
	}

	public boolean removeDoComeco(Object elemento) {

		if (this.totalDeElementos > 0 && contem(elemento)) {
			this.primeira = this.primeira.getProxima();
			this.totalDeElementos--;

			if (this.totalDeElementos == 0) { 
				this.ultima = null;
			}
			System.out.println("\n Elemento - "+elemento +" Removido do começo ! ");
			return true;
		} else {
			// throw new IllegalArgumentException("Elemento não existe");
			return false;
		}

	}

	public boolean removeDoFim(Object elemento) {
		if (this.totalDeElementos > 0 && contem(elemento)) {
			if (this.totalDeElementos == 1) {
				this.removeDoComeco(elemento);
			} else {
				this.ultima = primeira;
				this.totalDeElementos--;
			}
			System.out.println("\n Elemento - "+elemento +" Removido do fim ! ");
			return true;
		} else {
			// throw new IllegalArgumentException("Elemento não existe");
			return false;
		}
	}

	public String mostraLista() {

		if (this.tamanho() > 0) {

			StringBuilder builder = new StringBuilder("[");
			Celula atual = primeira;

			while (atual != null) { 
				
				if(atual  != null) { 
					// último elemento
					builder.append(atual.getElemento());
				}
				atual = atual.getProxima(); 
				builder.append(" , ");

			}
			builder.append("]");

			System.out.println("\n " + builder.toString());

			return builder.toString();
		} else {
			throw new IllegalArgumentException("A lista esta vazia ");
		}
	}
}
