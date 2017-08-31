package br.com.alura.template_method;

import br.com.alura.chain_of_responsability.Orcamento;

public abstract class TemplateDeImpostoCondicional implements Imposto {

	@Override
	public double calcula(Orcamento orcamento) {
		
		if (deveUsarMaximaTaxacao(orcamento))
			return maximaTaxacao(orcamento);
		else
			return minimaTaxacao(orcamento);
	}

	protected abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento);

	protected abstract double maximaTaxacao(Orcamento orcamento);

	protected abstract double minimaTaxacao(Orcamento orcamento);

}
