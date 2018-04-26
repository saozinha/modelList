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

	public Object getElemento(int posicao) {
		return null;
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

	public void removeDoComeco(Object elemento) {

		if (contem(elemento)) {
			this.primeira = this.primeira.getProxima();
			this.totalDeElementos--;

			if (this.totalDeElementos == 0) {
				this.ultima = null;
			}
			System.out.println(" Elemento Removido ! ");
		} else {
			throw new IllegalArgumentException("Elemento não existe");
		}

	}

	public void removeDoFim(Object elemento) {
		if (contem(elemento)) {
			if (this.totalDeElementos == 1) {
				this.removeDoComeco(elemento);
			} else {
				this.ultima = primeira;
				this.totalDeElementos--;
			}
		} else {
			throw new IllegalArgumentException("Elemento não existe");
		}
	}

	public String mostraLista() {

		if (this.tamanho() > 0) {
			
			StringBuilder builder = new StringBuilder("[");
			Celula atual = primeira;

			while (atual != null) {
				builder.append(atual.getElemento());
				builder.append(", ");
				atual = atual.getProxima();
			}

			// último elemento
			builder.append(atual.getElemento());
			builder.append("]");
			
			System.out.println(builder.toString());

			return builder.toString();
		} else {
			throw new IllegalArgumentException("A lista esta vazia ");
		}
	}
}
