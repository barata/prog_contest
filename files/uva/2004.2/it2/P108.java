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
	
	static int[][] matriz;
	static int[][] somaLinhas;

	public static void main(String[] args) {
		String linha = readLn(5);
		StringTokenizer tks;
		int size = Integer.parseInt(linha);
		
		matriz = new int[size + 1][size + 1];
		somaLinhas = new int[size + 1][size + 1];
		int count = 0;
		
		// carrega matriz
		while (count < size * size) {
			linha = readLn(500);
			tks = new StringTokenizer(linha);
			
			while (tks.hasMoreTokens()) {
				short valor = Short.parseShort(tks.nextToken());
				matriz[count / size + 1][count % size + 1] = valor;
				count++;
			}
		}

		// inicia matriz acumulativas
		init();

		// calcula maior soma
		int maiorSoma = 0;
		
		for (int a = 1; a <= size; a++) {
			for (int b = 1; b <= size; b++) {
				
				for (int j = b; j <= size; j++) {
					int somaTemp = 0;
					for (int i = a; i <= size; i++) {
						somaTemp += somaLinha(i, b, j);
						
						if (somaTemp > maiorSoma) maiorSoma = somaTemp;
					}
				}
			}
		}
		
		// resultado
		System.out.println(maiorSoma);
	}
	
	static void init() {
		for (int j = 1; j < matriz.length; j++) {
			for (int i = 1; i < matriz.length; i++) {
				somaLinhas[i][j] = somaLinhas[i][j - 1] + matriz[i][j];
			}
		}
	}
	
	static int somaLinha(int nLinha, int inicio, int fim) {
		return somaLinhas[nLinha][fim] - somaLinhas[nLinha][inicio - 1];
	}

	static void imprime(int[][] m) {
		for (int i= 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(" " + m[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
