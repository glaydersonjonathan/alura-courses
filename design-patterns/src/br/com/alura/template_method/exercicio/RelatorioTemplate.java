package br.com.alura.template_method.exercicio;

import java.util.List;

public abstract class RelatorioTemplate {
	
	protected abstract void cabecalho();
	protected abstract void rodape();
	protected abstract void corpo(List<Conta> contas);
	
	public void imprime(List<Conta> contas) {
		cabecalho();
		corpo(contas);
		rodape();
	}

}
