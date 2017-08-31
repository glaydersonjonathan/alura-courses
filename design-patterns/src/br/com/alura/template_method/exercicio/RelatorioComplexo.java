package br.com.alura.template_method.exercicio;

import java.util.Calendar;
import java.util.List;

public class RelatorioComplexo extends RelatorioTemplate {

	@Override
	protected void cabecalho() {

		System.out.println("Banco XYZ");
		System.out.println("Av. Desembargador Maynard");
		System.out.println("(79) 1234-5678");
	}

	@Override
	protected void rodape() {

		System.out.println("contato@bancoxyz.com.br");
		System.out.println(Calendar.getInstance().getTime());
	}

	@Override
	protected void corpo(List<Conta> contas) {

		for (Conta conta : contas)
			System.out.println(conta.getTitular() + " - " + conta.getNumeroDaConta() + " - " + conta.getAgencia()
					+ " - " + conta.getSaldo());
	}

}
