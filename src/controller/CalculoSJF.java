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
	

				for (int i =0 ; i<processo.length; i++) {                                //declarando o primeiro la�o de repeti��o
					for (int j =i+1; j<processo.length;j++)                              //declarando um segundo la�o de repeti��o para que possa ser realizada a compara��o dos valores armazenados no vetor
					{
		
						if (processo[i][1]> processo[j][1]) {                            //se o conte�do da posi��o do vetor for maior que o conte�do da anterior, as vari�veis ser�o tratadas para que ocorra uma ordena��o dos valores
							aux[0][0]= processo[i][0];
							aux[0][1]= processo[i][1];                                      //caso ela seja verdadeira, a vari�vel aux recebe o conte�do de vetor[i]
							processo[i][0]=processo[j][0];
							processo[i][1]=processo[j][1];
							processo[j][0]=aux[0][0];                                      //agora o conte�do da posi��o posterior ficou vago ent�o ela recebe o conte�do da posi��o anterior da vari�vel vetor[i], que est� armazenada na vari�vel aux para que possa ocorrer a substitui��o e ordena��o dos valores
							processo[j][1]=aux[0][1];                                      //agora o conte�do da posi��o posterior ficou vago ent�o ela recebe o conte�do da posi��o anterior da vari�vel vetor[i], que est� armazenada na vari�vel aux para que possa ocorrer a substitui��o e ordena��o dos valores
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
