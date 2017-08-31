package br.com.alura.chain_of_responsability.exercicio;

public class RespostaEmPorCento implements Resposta {

	private Resposta outraResposta;

	public RespostaEmPorCento(Resposta proxResposta) {

		this.outraResposta = proxResposta;
	}
	
	@Override
	public void responde(Requisicao requisicao, Conta conta) {

		if (requisicao.getFormato() == Formato.PORCENTO)
			System.out.println(conta.getTitular() + "%" + conta.getSaldo());
		else
			outraResposta.responde(requisicao, conta);
	}

}
