import java.util.StringTokenizer;

class Main {

	static String readLn() {
        String newLine = System.getProperty("line.separator");
        StringBuffer buffer = new StringBuffer();
        int car = -1;
        try {
            car = System.in.read();
            while ((car > 0) && (car != newLine.charAt(0))) {
                buffer.append((char)car);
                car = System.in.read();
            }
            if (car == newLine.charAt(0)) System.in.skip(newLine.length() - 1);
        } catch (java.io.IOException e) { return (null); }
        if ((car < 0) && (buffer.length() == 0)) return (null);
        return (buffer.toString()).trim();
    }
	
	public static void main(String[] args) {
		int nTestes = Integer.parseInt(readLn());
		
		for (int g = 0; g < nTestes; g++) {
			String linha = readLn();
			StringTokenizer tks = new StringTokenizer(linha);
			
			int nLinhas = Integer.parseInt(tks.nextToken());
			int nColunas = Integer.parseInt(tks.nextToken());
			int q = Integer.parseInt(tks.nextToken());
			
			char[][] array = new char[nLinhas][nColunas];
			
			for (int i = 0; i < nLinhas; i++) {
				linha = readLn();
				linha.getChars(0, linha.length(), array[i], 0);
			}
			
			System.out.println(nLinhas + " " + nColunas + " " + q);
			
			int[][] resultado = processa(array);

			for (int i = 0; i < q; i++) {
				tks = new StringTokenizer(readLn());
				
				int l = Integer.parseInt(tks.nextToken());
				int c = Integer.parseInt(tks.nextToken());
				
				System.out.println(resultado[l][c]);
			}


		}
	}

	static int[][] processa(char[][] array) {
		int[][] resultado = new int[array.length][array[0].length];
		
		// Passo 1: inicializa com 1
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++) {
				resultado[i][j] = 1;
			}
		}
		
		// Passo 2: inicializa celulas de tamanho 3
		for (int i = 1; i < array.length - 1; i++) {
			for (int j = 1; j < array[i].length - 1; j++) {
				if (array[i][j] == array[i - 1][j - 1] &&
						array[i][j] == array[i - 1][j] &&
						array[i][j] == array[i - 1][j + 1] &&
						array[i][j] == array[i][j + 1] &&
						array[i][j] == array[i + 1][j + 1] &&
						array[i][j] == array[i + 1][j] &&
						array[i][j] == array[i + 1][j - 1] &&
						array[i][j] == array[i][j - 1]) {
					resultado[i][j] = 3;
				}
			}
		}
		
		// Passo 3: expansao do quadrado
		int fim = Math.min(array.length, array[0].length);
		if (fim % 2 == 0) fim--;
		fim /= 2;
		
		for (int k = 2; k <= fim; k++) {
			
			for (int i = k; i < array.length - k; i++) {
				for (int j = k; j < array[i].length - k; j++) {
					if (resultado[i - 1][j - 1] >= resultado[i][j] &&
							resultado[i - 1][j + 1] >= resultado[i][j] &&
							resultado[i + 1][j + 1] >= resultado[i][j] &&
							resultado[i + 1][j - 1] >= resultado[i][j] &&
							resultado[i][j] > 1) {
						resultado[i][j] += 2;
					}
				}
			}
			
		}
		
		return resultado;
	}

}
