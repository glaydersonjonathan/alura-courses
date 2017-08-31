package br.com.alura.chain_of_responsability;

public class SemDesconto implements Desconto {

	@Override
	public double desconta(Orcamento orcamento) {

		return 0;
	}

	@Override
	public void setProximo(Desconto proximo) {
		// O método não é chamado
	}

}
