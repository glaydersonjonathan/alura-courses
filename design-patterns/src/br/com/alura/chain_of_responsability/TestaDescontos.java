package br.com.alura.chain_of_responsability;

public class TestaDescontos {

	public static void main(String[] args) {
		
		CalculadoraDeDescontos calculador = new CalculadoraDeDescontos();
		
		Orcamento orcamento = new Orcamento(500.0);
		orcamento.adicionaItem(new Item("CANETA", 250.0));
		orcamento.adicionaItem(new Item("LAPIS", 250.0));
		
		double desconto = calculador.calcula(orcamento);
		
		System.out.println(desconto);	
	}
}
