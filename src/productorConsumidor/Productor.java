package productorConsumidor;

import java.util.Random;

public class Productor extends Thread{
	
	private ColaDeTareas cola;
	
	private int size; 
	private int id;
	
	private Random random = new Random();
	
	
	public Productor(ColaDeTareas cola, int size, int id) {
		this.cola = cola;
		this.size = size;
		this.id = id;
	}
	
	
	@Override
	public void run() {
		for (int i = 0; i < size; i++) {
			int aux = random.nextInt(10);
			try {
				cola.introducir(aux);
				System.out.println("Producer ["  +id+ "] >>> produces: " +aux);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	
}
