package br.com.alura.chain_of_responsability.exercicio;

public class TesteDaResposta {

	public static void main(String[] args) {
		
		Requisicao req1 = new Requisicao(Formato.CSV);
		Requisicao req2 = new Requisicao(Formato.PORCENTO);
		Requisicao req3 = new Requisicao(Formato.XML);
		
		Conta conta = new Conta("João da Silva", 1000);
		
		RespostaEmCSV respostaEmCSV = new RespostaEmCSV(new SemResposta());
		RespostaEmPorCento respostaEmPorCento = new RespostaEmPorCento(respostaEmCSV);
		RespostaEmXML respostaEmXML = new RespostaEmXML(respostaEmPorCento);
		
		respostaEmXML.responde(req1, conta);
		respostaEmXML.responde(req2, conta);
		respostaEmXML.responde(req3, conta);
	}
}
