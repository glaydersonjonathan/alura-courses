package br.com.alura.threads;

public class Principal {

	private static int count = 1;

	public static void main(String[] args) {

		while (count < 1000) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println(
							"Contador: " + count++ + " - " + "Id da thread: " + Thread.currentThread().getId());
				}
			}).start();
		}
	}
}
