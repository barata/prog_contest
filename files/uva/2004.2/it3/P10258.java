import java.io.IOException;
import java.util.StringTokenizer;

class Main {

	static String readLn(int maxLg) { // utility function to read from stdin
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		String line = "";

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

		int numeroDeCasos = Integer.parseInt(readLn(255));

		readLn(5);
		for (int k = 0; k < numeroDeCasos; k++) {

			String linha;
			int[][] pessoas = new int[101][];

			// a leitura da linha em branco eh feita no cabecalho
			// do while

			// le um caso
			linha = readLn(255);
			
			while (linha != null && !linha.equals("")) {

				StringTokenizer tokens = new StringTokenizer(linha);
				int contestante = Integer.parseInt(tokens.nextToken());
				int problema = Integer.parseInt(tokens.nextToken());
				int tempo = Integer.parseInt(tokens.nextToken());
				char status = tokens.nextToken().charAt(0);

				// processa
				if (pessoas[contestante] == null) {
					pessoas[contestante] = new int[11]; // posicao 10 guarda o indice
					pessoas[contestante][10] = contestante; // e a 0 guarda o tempo
				}
				if (pessoas[contestante][problema] >= 0) {

					if (status == 'I') {
						pessoas[contestante][problema]++;
					}
					else if (status == 'C') {
						pessoas[contestante][0] += tempo + 20 * pessoas[contestante][problema];
						pessoas[contestante][problema] = -1;
					}

				}
				
				linha = readLn(255);
			}
			
			// array com as pessoas que submeteram problemas
			int[][] novoArray = new int[100][3];
			int indice = 0;

			for (int i = 1; i < pessoas.length; i++) {

				if (pessoas[i] != null) {
					int acertos = 0;
					for (int j = 1; j < pessoas[i].length; j++) {
						if (pessoas[i][j] == -1)
							acertos++;
					}
					novoArray[indice][0] = i;
					novoArray[indice][1] = acertos;
					novoArray[indice++][2] = pessoas[i][0];
				}
			}
			// ordena
			for (int i = 1; i < indice; i++) {
				for (int j = indice - 1; j >= i; j--) {
					// ordena pelos acertos
					if (novoArray[j][1] > novoArray[j - 1][1]) {
						int[] aux;
						aux = novoArray[j];
						novoArray[j] = novoArray[j - 1];
						novoArray[j - 1] = aux;
					}
					else if (novoArray[j][1] == novoArray[j - 1][1]) {
						// ordena pelo tempo
						if (novoArray[j][2] < novoArray[j - 1][2]) {
							int[] aux;
							aux = novoArray[j];
							novoArray[j] = novoArray[j - 1];
							novoArray[j - 1] = aux;
						}
						else if (novoArray[j][2] == novoArray[j - 1][2]) {
							// ordena pelo indice
							if (novoArray[j][0] < novoArray[j - 1][0]) {
								int[] aux;
								aux = novoArray[j];
								novoArray[j] = novoArray[j - 1];
								novoArray[j - 1] = aux;
							}
						}
					}
				}
			}
			// imprime resultado ordenado
			for (int i = 0; i < indice; i++) {
				System.out.println(novoArray[i][0] + " " + novoArray[i][1] + " " + novoArray[i][2]);
			}
			if (k < numeroDeCasos - 1) System.out.println("");

		}
	}

	public static void main(String args[]) {

		Main app = new Main();
		app.solucao();

	}

}