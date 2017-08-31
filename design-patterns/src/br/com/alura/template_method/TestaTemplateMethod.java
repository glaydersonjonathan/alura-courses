package br.com.alura.template_method;

import br.com.alura.chain_of_responsability.Item;
import br.com.alura.chain_of_responsability.Orcamento;

public class TestaTemplateMethod {

	public static void main(String[] args) {
		
		Orcamento orcamento = new Orcamento(500.0);
		orcamento.adicionaItem(new Item("BORRACHA", 100.0));
		orcamento.adicionaItem(new Item("APONTADOR", 250.0));
		orcamento.adicionaItem(new Item("TINTA", 75.0));
		orcamento.adicionaItem(new Item("TINTA", 75.0));
		
		Imposto icpp = new ICPP();
		Imposto ikcv = new IKCV();
		Imposto ihit = new IHIT();
		
		double impostoCobrado = icpp.calcula(orcamento);
		System.out.println("Imposto ICCP: " + impostoCobrado);
		impostoCobrado = ikcv.calcula(orcamento);
		System.out.println("Imposto IKCV: " + impostoCobrado);
		impostoCobrado = ihit.calcula(orcamento);
		System.out.println("Imposto IHIT (Caso Max): " + impostoCobrado);
	}
}
