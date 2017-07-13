package br.com.alura.metadados;

import java.util.Set;

public class MetadadosPrincipal {

	public static void main(String[] args) {
		Set<Thread> todasAsThreads = Thread.getAllStackTraces().keySet();

		for (Thread thread : todasAsThreads) {
			System.out.println("Thread name: " + thread.getName());
		}

		Runtime runtime = Runtime.getRuntime();
		int qtdProcessadores = runtime.availableProcessors();
		System.out.println("Qtd de processadores: " + qtdProcessadores);

	}

}
