package br.com.alura.chain_of_responsability.exercicio;

public class RespostaEmCSV implements Resposta {

	private Resposta outraResposta;
	
	public RespostaEmCSV(Resposta proxResposta) {

		this.outraResposta = proxResposta;
	}
	
	@Override
	public void responde(Requisicao requisicao, Conta conta) {

		if (requisicao.getFormato() == Formato.CSV)
			System.out.println(conta.getTitular() + "," + conta.getSaldo());
		else
			outraResposta.responde(requisicao, conta);
	}

}
