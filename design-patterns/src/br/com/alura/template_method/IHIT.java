package br.com.alura.template_method;

import java.util.List;

import br.com.alura.chain_of_responsability.Item;
import br.com.alura.chain_of_responsability.Orcamento;

public class IHIT extends TemplateDeImpostoCondicional {

	@Override
	protected boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		// Procura por dois itens com o mesmo nome
		List<Item> itens = orcamento.getItens();
		for (int i=0; i < itens.size(); i++) {
			for (int j=i+1; j < itens.size(); j++) {
				// Começo iterar do sucessor
				String nomeDoPrimeiroItem = itens.get(i).getNome();
				String nomeDoSegundoItem = itens.get(j).getNome();
				if (nomeDoPrimeiroItem.equals(nomeDoSegundoItem)) // Itens repetidos
					return true;
			}
		}
		
		return false;
	}

	@Override
	protected double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.13 + 100.0;
	}

	@Override
	protected double minimaTaxacao(Orcamento orcamento) {
		int numeroDeItensNoOrcamento = orcamento.getItens().size();
		return (numeroDeItensNoOrcamento * 0.01) * orcamento.getValor();
	}

}
