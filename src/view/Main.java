package view;

import java.util.concurrent.Semaphore;

import controller.CalculoSJF;

public class Main {

	public static void main(String[] args) {
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		int [][] processo = new int [20][2];
		 
		for (int IdThread = 0; IdThread < 20; IdThread ++) {
			int tempo = (int) (Math.random() * 116 + 4);
			processo[IdThread][0] = IdThread;
			processo[IdThread][1] = tempo;
//			System.out.println("geracao = tread " + processo[IdThread][0] + " tempo " + processo[IdThread][1]);
			Thread IDT = new CalculoSJF(processo,semaforo);
			IDT.start();
		} // fim for
	}  // fim main
	
} // fim classe
