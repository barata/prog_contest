import java.io.IOException;

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

	private static char[][] mapa = new char[102][102];
	private static int xAxis = 0;
	private static int yAxis = 50;

	private static void init() {
		xAxis = 0;
		yAxis = 50;

		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				mapa[i][j] = ' ';
			}
		}
	}

	public static void main(String[] args) {
		int nTestes = Integer.parseInt(readLn(255));
		String comando;
		
		// le cada teste
		for (int i = 0; i < nTestes; i++) {
			init();

			comando = readLn(60);
			
			// le cada comando
			for (int j = 0; j < comando.length(); j++) {
				char digito = comando.charAt(j);
				char traco = converte(digito);
				marca(traco, (j == 0 ? ' ' : converte(comando.charAt(j - 1))));
			}
			
			// processa
			System.out.println("Case #" + (i + 1) + ":");
			processa();
			System.out.println();
		}
	}

	private static void processa() {
		int maiorLinha = -1;

		for (int i = mapa.length - 1; i >= 0; i--) {
			int valor = imprimeLinha(mapa[i]);
			if (valor > maiorLinha) maiorLinha = valor;
		}
		System.out.print("+-");
		for (int i = 0; i <= maiorLinha; i++) System.out.print("-");
		System.out.println("-");
	}
	
	private static int imprimeLinha(char[] linha) {
		boolean deveImprimir = false;
		int tamanho = 0;
		
		for (int i = 0; i < linha.length; i++) {
			if (linha[i] != ' ') {
				deveImprimir = true;
				tamanho = i;
			}
		}
		
		if (deveImprimir) {
			System.out.print("| ");
			for (int i = 0; i <= tamanho; i++) {
				System.out.print(linha[i]);
			}
			System.out.println();
		}
		
		return tamanho;
	}

	private static char converte(char digito) {
		return (digito == 'R' ? '/' : (digito == 'F' ? '\\' : '_'));
	}
	
	private static int getInc(char anterior, char atual) {
		if (anterior == '/') {
			if (atual == '/') return 1;
			if (atual == '_') return 1;
		}
		if (atual == '\\') {
			if (anterior == '_') return -1;
			if (anterior == '\\') return -1;
		}
		return 0;
	}
	
	private static void marca(char traco, char anterior) {
			if (xAxis == 0) {
				mapa[yAxis][xAxis] = traco;
				xAxis++;
			} else {
				yAxis += getInc(anterior, traco);;
				mapa[yAxis][xAxis] = traco;
				xAxis++;
			}
	}
}
