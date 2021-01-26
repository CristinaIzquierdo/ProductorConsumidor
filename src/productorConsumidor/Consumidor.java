package productorConsumidor;

public class Consumidor extends Thread{
	
	private ColaDeTareas cola;
	
	private int size;
	private int id;
	

	public Consumidor(ColaDeTareas cola, int size, int id) {
		this.cola = cola;
		this.size = size;
		this.id = id;
	}
	
	
	@Override
	public void run() {
		for (int i = 0; i<size; i++) {
			int aux;
			try {
				aux = cola.extraer();
				System.out.println("Consumer [" +id+ "] >>> consumes: " +aux);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	
	
}
