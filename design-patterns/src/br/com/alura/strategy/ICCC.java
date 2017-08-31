package br.com.alura.strategy;

public class ICCC implements Imposto {

	@Override
	public double calcula(Orcamento orcamento) {
		double valorOrcamento = orcamento.getValor();

		if (valorOrcamento < 1000.0)
			return valorOrcamento * 0.05;
		else if (valorOrcamento <= 3000.0)
			return valorOrcamento * 0.07;
		else
			return valorOrcamento * 0.08 + 30.0;
	}

}
