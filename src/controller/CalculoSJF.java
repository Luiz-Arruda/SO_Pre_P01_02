package controller;

import java.util.concurrent.Semaphore;

public class CalculoSJF extends Thread {
	
//	private int IdThread;
	private int [][] processo = new int [20][2];
	private int IdThread;
	private Semaphore semaforo;
	static int [][] ordem = new int [20][2];

	
	
	public CalculoSJF(int [][] processo, Semaphore semaforo) {
		this.processo = processo;
		this.semaforo = semaforo;
	} // fim classe SJF

		public void run() {
			
			Ordenacao(processo);
		}  // fim run
	
		public void Ordenacao(int [][] processo){
			int [][]aux = new int [1][2];
	

				for (int i =0 ; i<processo.length; i++) {                                //declarando o primeiro laço de repetição
					for (int j =i+1; j<processo.length;j++)                              //declarando um segundo laço de repetição para que possa ser realizada a comparação dos valores armazenados no vetor
					{
		
						if (processo[i][1]> processo[j][1]) {                            //se o conteúdo da posição do vetor for maior que o conteúdo da anterior, as variáveis serão tratadas para que ocorra uma ordenação dos valores
							aux[0][0]= processo[i][0];
							aux[0][1]= processo[i][1];                                      //caso ela seja verdadeira, a variável aux recebe o conteúdo de vetor[i]
							processo[i][0]=processo[j][0];
							processo[i][1]=processo[j][1];
							processo[j][0]=aux[0][0];                                      //agora o conteúdo da posição posterior ficou vago então ela recebe o conteúdo da posição anterior da variável vetor[i], que está armazenada na variável aux para que possa ocorrer a substituição e ordenação dos valores
							processo[j][1]=aux[0][1];                                      //agora o conteúdo da posição posterior ficou vago então ela recebe o conteúdo da posição anterior da variável vetor[i], que está armazenada na variável aux para que possa ocorrer a substituição e ordenação dos valores
						} // if
					} // fim for
				} // fim for
				try {
					semaforo.acquire();
					for (int i = 0; i < processo.length; i++) {
					System.out.println("matriz bublle sort2 " + processo[i][0] + " "+ processo[i][1]);
					}
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			semaforo.release();
			
			
			} // fim ordenacao
} // fim classe calcul SJF
