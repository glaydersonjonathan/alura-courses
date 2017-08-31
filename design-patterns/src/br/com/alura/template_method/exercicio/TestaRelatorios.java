package br.com.alura.template_method.exercicio;

import java.util.ArrayList;
import java.util.List;

public class TestaRelatorios {

	public static void main(String[] args) {
		Conta conta1 = new Conta("João da Silva", "1234", "5678", 1500.0);
		Conta conta2 = new Conta("Maria dos Santos", "0123-X", "123-4", 2700.0);
		
		List<Conta> contas = new ArrayList<Conta>();
		contas.add(conta1);
		contas.add(conta2);
		
		System.out.println("-- Imprimindo um relatório simples --");
		new RelatorioSimples().imprime(contas);
		
		System.out.println("\n-- Imprimindo um relatório complexo --");
		new RelatorioComplexo().imprime(contas);
	}
}
