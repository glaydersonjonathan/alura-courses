package br.com.alura.template_method.exercicio;

public class Conta {

	private String titular;
	private String agencia;
	private String numeroDaConta;
	private double saldo;

	public Conta(String tit, String age, String num, double sal) {

		this.titular = tit;
		this.agencia = age;
		this.numeroDaConta = num;
		this.saldo = sal;
	}

	public String getTitular() {
		return titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumeroDaConta() {
		return numeroDaConta;
	}

	public double getSaldo() {
		return saldo;
	}

}
