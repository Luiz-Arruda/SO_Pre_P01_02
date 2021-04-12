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
				for (int i =0 ; i<ordem.length; i++) {                                //declarando o primeiro la�o de repeti��o
					for (int j =i+1; j<ordem.length;j++)                              //declarando um segundo la�o de repeti��o para que possa ser realizada a compara��o dos valores armazenados no vetor
					{
		
						if (ordem[i][1]> ordem[j][1]) {                            //se o conte�do da posi��o do vetor for maior que o conte�do da anterior, as vari�veis ser�o tratadas para que ocorra uma ordena��o dos valores
							aux[0][0]= ordem[i][0];
							aux[0][1]= ordem[i][1];                                      //caso ela seja verdadeira, a vari�vel aux recebe o conte�do de vetor[i]
							ordem[i][0]=ordem[j][0];
							ordem[i][1]=ordem[j][1];
							ordem[j][0]=aux[0][0];                                      //agora o conte�do da posi��o posterior ficou vago ent�o ela recebe o conte�do da posi��o anterior da vari�vel vetor[i], que est� armazenada na vari�vel aux para que possa ocorrer a substitui��o e ordena��o dos valores
							ordem[j][1]=aux[0][1];                                      //agora o conte�do da posi��o posterior ficou vago ent�o ela recebe o conte�do da posi��o anterior da vari�vel vetor[i], que est� armazenada na vari�vel aux para que possa ocorrer a substitui��o e ordena��o dos valores
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
