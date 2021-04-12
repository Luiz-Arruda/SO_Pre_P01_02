package controller;

import java.util.concurrent.Semaphore;

public class CalculoSJF extends Thread {
	
//	private int IdThread;
	private int [][] processo = new int [20][2];
	private int IdThread;
	private boolean cont;
	private Semaphore semaforo;
	static int [][] ordem = new int [20][2];

	
	
	public CalculoSJF(int [][] processo, boolean cont, Semaphore semaforo) {
		this.processo = processo;
		this.cont = cont;
		this.semaforo = semaforo;
	} // fim classe SJF

		public void run() {
			if (cont == true) {
			Ordenacao(processo);
			}
		}  // fim run
	
		public void Ordenacao(int [][] ordem){
			int [][]aux = new int [1][2];
				for (int i =0 ; i<ordem.length; i++) {                                //declarando o primeiro laço de repetição
					for (int j =i+1; j<ordem.length;j++)                              //declarando um segundo laço de repetição para que possa ser realizada a comparação dos valores armazenados no vetor
					{
		
						if (ordem[i][1]> ordem[j][1]) {                            //se o conteúdo da posição do vetor for maior que o conteúdo da anterior, as variáveis serão tratadas para que ocorra uma ordenação dos valores
							aux[0][0]= ordem[i][0];
							aux[0][1]= ordem[i][1];                                      //caso ela seja verdadeira, a variável aux recebe o conteúdo de vetor[i]
							ordem[i][0]=ordem[j][0];
							ordem[i][1]=ordem[j][1];
							ordem[j][0]=aux[0][0];                                      //agora o conteúdo da posição posterior ficou vago então ela recebe o conteúdo da posição anterior da variável vetor[i], que está armazenada na variável aux para que possa ocorrer a substituição e ordenação dos valores
							ordem[j][1]=aux[0][1];                                      //agora o conteúdo da posição posterior ficou vago então ela recebe o conteúdo da posição anterior da variável vetor[i], que está armazenada na variável aux para que possa ocorrer a substituição e ordenação dos valores
						} // if
					} // fim for
				} // fim for
				try {
					semaforo.acquire();
					for (int i = 0; i < ordem.length; i++) {
					System.out.println("matriz bublle sort2 " + ordem[i][0] + " "+ ordem[i][1]);
					}
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			semaforo.release();
			
			
			} // fim ordenacao
} // fim classe calcul SJF
