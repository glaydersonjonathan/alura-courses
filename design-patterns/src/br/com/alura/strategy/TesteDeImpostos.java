package br.com.alura.strategy;

public class TesteDeImpostos {

	public static void main(String[] args) {
		Imposto icms = new ICMS();
		Imposto iss = new ISS();
		Imposto iccc = new ICCC();
		
		Orcamento orcamento = new Orcamento(500.0);
		
		CalculadorDeImpostos calculador = new CalculadorDeImpostos();
		
		// Calculando o ICMS
		calculador.realizaCalculo(orcamento, icms);
		// Calculando o ISS
		calculador.realizaCalculo(orcamento, iss);
		
		// Calculando o ICCC para os tres casos
		calculador.realizaCalculo(new Orcamento(900.0), iccc);
		calculador.realizaCalculo(new Orcamento(1000.0), iccc);
		calculador.realizaCalculo(new Orcamento(4000.0), iccc);
	}
}
