package br.com.alura.chain_of_responsability.exercicio;

public class Conta {

	private String titular;
	private double saldo;

	public Conta(String titular, double saldo) {

		this.titular = titular;
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

}
