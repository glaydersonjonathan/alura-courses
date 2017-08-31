package br.com.alura.chain_of_responsability.exercicio;

public class RespostaEmXML implements Resposta {

	private Resposta outraResposta;

	public RespostaEmXML(Resposta proxResposta) {

		this.outraResposta = proxResposta;
	}

	@Override
	public void responde(Requisicao requisicao, Conta conta) {
		if (requisicao.getFormato() == Formato.XML)
			System.out.println("<conta><titular>" + conta.getTitular() + "</titular><saldo>" + conta.getSaldo()
					+ "</saldo></conta>");
		else
			outraResposta.responde(requisicao, conta);

	}

}
