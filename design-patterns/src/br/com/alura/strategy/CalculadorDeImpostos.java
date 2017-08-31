package br.com.alura.strategy;

public class CalculadorDeImpostos {

	
	public void realizaCalculo(Orcamento orcamento, Imposto estrategiaDeImposto) {
		double valor = estrategiaDeImposto.calcula(orcamento);
		
		System.out.println(valor);
	}
}
