package br.com.alura.banheiro;

public class Banheiro {

	// private Lock lock = new ReentrantLock();
	private boolean estaSujo = true;

	public void fazNumero1() {

		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			// lock.lock();
			System.out.println(nome + " entrando no banheiro");

			while (this.estaSujo) {
				esperaLaFora(nome);
			}

			System.out.println(nome + " fazendo coisa rapida");

			dormeUmPouco(5000);
			this.estaSujo = true;

			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando mao");
			System.out.println(nome + " saindo do banheiro");
			// lock.unlock();
		}
	}

	public void fazNumero2() {

		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			// lock.lock();
			System.out.println(nome + " entrando no banheiro");

			while (this.estaSujo) {
				esperaLaFora(nome);
			}

			System.out.println(nome + " fazendo coisa demorada");

			dormeUmPouco(10000);
			this.estaSujo = true;

			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando mao");
			System.out.println(nome + " saindo do banheiro");
			// lock.unlock();
		}
	}

	public void limpa() {

		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta");

		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");

			if (!estaSujo) {
				System.out.println(nome + ", não está sujo, vou sair");
				return;
			}

			System.out.println(nome + " limpando o banheiro");
			this.estaSujo = false;

			try {
				Thread.sleep(13000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.notifyAll();

			System.out.println(nome + " saindo do banheiro");
		}

	}

	private void dormeUmPouco(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void esperaLaFora(String nome) {
		System.out.println(nome + ", eca, banheiro está sujo!");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
