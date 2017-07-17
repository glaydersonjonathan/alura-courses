package br.com.alura.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class TesteFila {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> fila = new ArrayBlockingQueue<>(3);
		
		fila.offer("c1", 5, TimeUnit.SECONDS);
		fila.offer("c2", 5, TimeUnit.SECONDS);
		fila.offer("c3", 5, TimeUnit.SECONDS);
		
		System.out.println(fila.poll(5, TimeUnit.SECONDS));
		System.out.println(fila.poll(5, TimeUnit.SECONDS));
		System.out.println(fila.poll(5, TimeUnit.SECONDS));
		System.out.println(fila.poll(5, TimeUnit.SECONDS));
		
		System.out.println(fila.size());
	}
}
