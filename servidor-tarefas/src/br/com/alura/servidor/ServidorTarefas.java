package br.com.alura.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefas {

	private ExecutorService threadPool;
	private ServerSocket servidor;
	private AtomicBoolean estaRodando;
	private BlockingQueue<String> filaComandos;

	public ServidorTarefas() throws IOException {
		System.out.println("---- Iniciando servidor ----");
		this.servidor = new ServerSocket(12345);
		ThreadFactory defaultFactory = Executors.defaultThreadFactory();
		this.threadPool = Executors.newCachedThreadPool(new FabricaDeThreads(defaultFactory)); // newCachedThreadPool();
		this.estaRodando = new AtomicBoolean(true);
		this.filaComandos = new ArrayBlockingQueue<>(2);
		iniciarConsumidores();
	}

	private void iniciarConsumidores() {

		int qntConsumidores = 2;
		for (int i = 0; i < qntConsumidores; i++) {
			TarefaConsumir tarefa = new TarefaConsumir(filaComandos);
			this.threadPool.execute(tarefa);
		}

	}

	public static void main(String[] args) throws Exception {

		ServidorTarefas servidor = new ServidorTarefas();
		servidor.rodar();
		// servidor.parar();

	}

	public void rodar() throws IOException {
		while (this.estaRodando.get()) {

			try {
				Socket socket = this.servidor.accept();
				System.out.println("Aceitando conexão na porta " + socket.getPort());

				DistribuirTarefas distribuirTarefas = new DistribuirTarefas(threadPool, filaComandos, socket, this);
				threadPool.execute(distribuirTarefas);
			} catch (SocketException e) {
				System.out.println("SocketException, está rodando? " + this.estaRodando);
			}
		}
	}

	public void parar() throws IOException {
		System.out.println("Parando o servidor");
		this.estaRodando.set(false);
		this.threadPool.shutdown();
		this.servidor.close();
		// System.exit(0);
	}

}
