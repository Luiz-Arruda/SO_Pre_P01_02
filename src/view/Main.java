package view;

import java.util.concurrent.Semaphore;

import controller.CalculoSJF;

public class Main {

	public static void main(String[] args) {
		int permissao = 1;
		boolean cont = false;
		Semaphore semaforo = new Semaphore(permissao);
		int [][] processo = new int [20][2];
		 
		for (int IdThread = 0; IdThread < 20; IdThread ++) {
			int tempo = (int) (Math.random() * 116 + 4);
			processo[IdThread][0] = IdThread;
			processo[IdThread][1] = tempo;
			if (IdThread == 19) {
				cont = true;
				}
			Thread IDT = new CalculoSJF(processo,cont, semaforo);
			IDT.start();
			
		} // fim for
	}  // fim main
	
} // fim classe
