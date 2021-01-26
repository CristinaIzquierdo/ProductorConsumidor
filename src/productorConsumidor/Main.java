package productorConsumidor;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static final int NUM_CONSUMERS = 50;
	static final int NUM_PRODUCERS = 2;

	public static void main(String[] args) {
		/*
		ColaDeTareas cola = new ColaDeTareas(5);
		
		Productor p1 = new Productor(cola, 10);
		Consumidor c1 =  new Consumidor(cola, 10);
		
		p1.start();
		c1.start();
				*/
		
		ColaDeTareas cola = new ColaDeTareas(5);
		List<Consumidor> consumers = new ArrayList<>();
		List<Productor> producers = new ArrayList<>();
		
		
		for (int i = 0; i <NUM_CONSUMERS; i ++) {
			consumers.add(new Consumidor(cola, 10, i));
		}

		for (int i = 0; i <NUM_PRODUCERS; i ++) {
			producers.add(new Productor(cola, 10, i));
		}

		for(Consumidor c : consumers) {
			c.start();
		}

		for(Productor p : producers) {
			p.start();
		}
		
		for (Consumidor c : consumers) {
			try { c.join(); }
			catch(Exception e) {}
		}

		for (Productor p : producers) {
			try { p.join(); }
			catch(Exception e) {}
		}

		
		//System.out.println("Elementos en la cola: " + cola.l);
		System.out.println("HE TERMINADO :D");
	}
	}


