package productorConsumidor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ColaDeTareas {
	
	private int[] cola;
	
	private int apuntadorCons = 0; //punteros a la posicion siguiente y anterior de la cola
	private int apuntadorProd = 0; //punteros a la posicion siguiente y anterior de la cola
		
	private Semaphore hayDatos = new Semaphore(0, true);
	private Semaphore hayEspacio;
	private Semaphore mutex = new Semaphore(1, true); //garantiza la exclusi�n mutua, un proceso a la vez en el buffer
	
	
	public ColaDeTareas(int tama�oCola) {
		this.cola = new int[tama�oCola]; //indicar el tama�o de la pila cuando se invoque al constructor
		hayEspacio = new Semaphore(tama�oCola, true);
	}
	
	
	public void introducir(int dato) throws InterruptedException { 
		hayEspacio.acquire();
		mutex.acquire();
		cola[apuntadorCons] = dato;
		
		apuntadorCons = (apuntadorCons+1)%cola.length;
		mutex.release();
		hayDatos.release();		
		
		List<Integer> intList = new ArrayList<Integer>(cola.length);
	}
	
	
	public int extraer() throws InterruptedException {
		hayDatos.acquire();
		mutex.acquire();
		int actual = apuntadorProd; //posicion actual de la cual extraigo
		
		apuntadorProd = (apuntadorProd+1)%cola.length;
		mutex.release();
		hayEspacio.release(); 
		
		return cola[actual];
	}
	
}
