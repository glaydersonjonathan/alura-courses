package br.com.alura.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorTarefas {

	private ExecutorService threadPool;
	private ServerSocket servidor;
	private boolean estaRodando;

	public ServidorTarefas() throws IOException {
		System.out.println("---- Iniciando servidor ----");
		this.servidor = new ServerSocket(12345);
		this.threadPool = Executors.newCachedThreadPool();
		this.estaRodando = true;
	}

	public static void main(String[] args) throws Exception {

		ServidorTarefas servidor = new ServidorTarefas();
		servidor.rodar();
		servidor.parar();

	}

	public void rodar() throws IOException {
		while (this.estaRodando) {

			try {
				Socket socket = servidor.accept();
				System.out.println("Aceitando conexão na porta " + socket.getPort());

				DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket, this);
				threadPool.execute(distribuirTarefas);
			} catch (SocketException e) {
				System.out.println("SocketException, está rodando? " + this.estaRodando);
			}
		}
	}

	public void parar() throws IOException {
		estaRodando = false;
		servidor.close();
		threadPool.shutdown();
		//System.exit(0);
	}

}
