package br.com.alura.servidor;

import java.util.concurrent.ThreadFactory;

public class FabricaDeThreads implements ThreadFactory {

	//private static int numero = 1;
	private ThreadFactory defaultFactory;

	public FabricaDeThreads(ThreadFactory defaultFactory) {
		this.defaultFactory = defaultFactory;
	}

	@Override
	public Thread newThread(Runnable tarefa) {
		Thread thread = this.defaultFactory.newThread(tarefa);
		//numero++;
			
		thread.setUncaughtExceptionHandler(new TratadorDeExcecao());
		//thread.setDaemon(true);

		return thread;
	}

}
