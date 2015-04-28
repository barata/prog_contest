import java.io.IOException;
import java.util.StringTokenizer;

class Main {

	static String readLn(int maxLg) { // utility function to read from stdin
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;

		try {
			while (lg < maxLg) {
				car = System.in.read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}

		if ((car < 0) && (lg == 0))
			return (null); // eof
		return (new String(lin, 0, lg)).trim();
	}

	void solucao() {
	
		String linha = readLn(255);
		StringTokenizer tokens = new StringTokenizer(linha);
		int numeroDeCasos = Integer.parseInt(tokens.nextToken());
		
		for (int m = 0; m < numeroDeCasos; m++) {
		
			// pega o tamanho da matriz
			linha = readLn(255);
			tokens = new StringTokenizer(linha);
			int tamanhoDaMatriz = Integer.parseInt(tokens.nextToken());
		
			// cria matriz
			int[][] matriz = new int[ tamanhoDaMatriz ][ tamanhoDaMatriz ];

			// le a matriz
			for (int a = 0; a < tamanhoDaMatriz; a++) {
				linha = readLn(1000);
				tokens = new StringTokenizer(linha);
				for (int b = 0; b < tamanhoDaMatriz; b++) {
				
					int termo = Integer.parseInt(tokens.nextToken());
					matriz[ a ][ b ] = termo;
				
				}
			}
		
			// pega o numero de quadrados
			int numeroDeQuadrados = (tamanhoDaMatriz / 2) + (tamanhoDaMatriz % 2);
		
			// processa operacoes com os quadrados
			for (int a = 0; a < numeroDeQuadrados; a++) {
			
				linha = readLn(300);
				tokens = new StringTokenizer(linha);
				int numeroDeOperacoes = Integer.parseInt(tokens.nextToken());
				
				for (int b = 0; b < numeroDeOperacoes; b++) {
				
					int operacao = Integer.parseInt(tokens.nextToken());
					
					// realiza operacao
					switch (operacao) {
						// upside-down
						case 1:
							for (int l = 0; l < tamanhoDaMatriz / 2; l++) {
								for (int c = 0; c < tamanhoDaMatriz; c++) {
								
									if (l >= a && c >= a &&
										l <= tamanhoDaMatriz - a - 1 && c <= tamanhoDaMatriz - a - 1 &&
										(
										l <= a || c <= a ||
										l >= tamanhoDaMatriz - a - 1 || c >= tamanhoDaMatriz - a - 1
										)) {
										
										int aux = matriz[ l ][ c ];
										matriz[ l ][ c ] = matriz[ tamanhoDaMatriz - l - 1 ][ c ];
										matriz[ tamanhoDaMatriz - l - 1 ][ c ] = aux;
	
									}
								}
							}
							break;
						
						// left-right
						case 2:
							for (int l = 0; l < tamanhoDaMatriz; l++) {
								for (int c = 0; c < tamanhoDaMatriz / 2; c++) {
								
									if (l >= a && c >= a &&
										l <= tamanhoDaMatriz - a - 1 && c <= tamanhoDaMatriz - a - 1 &&
										(
										l <= a || c <= a ||
										l >= tamanhoDaMatriz - a - 1 || c >= tamanhoDaMatriz - a - 1
										)) {
										
										int aux = matriz[ l ][ c ];
										matriz[ l ][ c ] = matriz[ l ][ tamanhoDaMatriz - c - 1 ];
										matriz[ l ][ tamanhoDaMatriz - c - 1 ] = aux;
	
									}
								}
							}
							break;
						
						// main diagonal
						case 3:
							for (int l = 0; l < tamanhoDaMatriz; l++) {
								for (int c = 0; c < tamanhoDaMatriz; c++) {
								
									if (l >= a && c >= a &&
										l <= tamanhoDaMatriz - a - 1 && c <= tamanhoDaMatriz - a - 1 &&
										(
										l <= a || c <= a ||
										l >= tamanhoDaMatriz - a - 1 || c >= tamanhoDaMatriz - a - 1
										) &&
										l > c) {
										
										int aux = matriz[ l ][ c ];
										matriz[ l ][ c ] = matriz[ c ][ l ];
										matriz[ c ][ l ] = aux;
	
									}
								}
							}
							break;
						
						// main inverse diagonal
						case 4:
							for (int l = 0; l < tamanhoDaMatriz; l++) {
								for (int c = 0; c < tamanhoDaMatriz; c++) {
								
									if (l >= a && c >= a &&
										l <= tamanhoDaMatriz - a - 1 && c <= tamanhoDaMatriz - a - 1 &&
										(
										l <= a || c <= a ||
										l >= tamanhoDaMatriz - a - 1 || c >= tamanhoDaMatriz - a - 1
										) &&
										l > tamanhoDaMatriz - c - 1) {
										
										int aux = matriz[ l ][ c ];
										matriz[ l ][ c ] = matriz[ tamanhoDaMatriz - c - 1 ][ tamanhoDaMatriz - l - 1 ];
										matriz[ tamanhoDaMatriz - c - 1 ][ tamanhoDaMatriz - l - 1 ] = aux;

									}
								}
							}
							break;
					
					}
				
				}

			}

			// imprime matriz
			for (int a = 0; a < tamanhoDaMatriz; a++) {
				for (int b = 0; b < tamanhoDaMatriz; b++) {

					System.out.print(matriz[ a ][ b ]);
					
					if (b < tamanhoDaMatriz - 1) System.out.print(" ");
				
				}
				System.out.println();
			}
		}

	}
	
	public static void main(String args[]) {
		Main app = new Main();
		app.solucao();
	}

}