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
	
	static int delta;

	public static void main(String[] args) {
		String line = readLn();
		
		while (!"#".equals(line)) {
			StringTokenizer tks = new StringTokenizer(line);
			
			String source = tks.nextToken();
			String destination = tks.nextToken();
			
			int[][] array = distanciaEdicaoMinima(source, destination);
			
			delta = 0;
			
			imprimeOperacoes(array, array.length - 1, array[0].length - 1, source, destination);
			System.out.println("E");
			
			line = readLn();
		}
	}

	static int[][] distanciaEdicaoMinima(String palavra1, String palavra2) {
		/*
		 * cria matriz de processamento
		 */
		int[][] matriz = new int[palavra2.length() + 1][palavra1.length() + 1];
		
		/*
		 * preenche casos base
		 */
		for (int i = 0; i < matriz[0].length; i++) {
			matriz[0][i] = i;
		}
		
		for (int i = 0; i < matriz.length; i++) {
			matriz[i][0] = i;
		}
		
		/*
		 * preenche a tabela
		 */
		for (int i = 1; i < matriz.length; i++) {
			for (int j = 1; j < matriz[i].length; j++) {
				char ch1 = palavra1.charAt(j - 1);
				char ch2 = palavra2.charAt(i - 1);
				
				if (ch1 == ch2)
					matriz[i][j] = matriz[i - 1][j - 1];
				else
					matriz[i][j] = Math.min(Math.min(matriz[i][j - 1], matriz[i - 1][j]), matriz[i - 1][j - 1]) + 1;
			}
		}
		
		return matriz;
	}

	static void imprimeOperacoes(int[][] matriz, int i, int j, String palavra1, String palavra2) {
		if (j > 0 && matriz[i][j - 1] + 1 == matriz[i][j]) {
			imprimeOperacoes(matriz, i, j - 1, palavra1, palavra2);
			System.out.print("D" + palavra1.charAt(i - delta) + formata(j + delta));
			delta--;
		} else if (i > 0 && matriz[i - 1][j] + 1 == matriz[i][j]) {
			imprimeOperacoes(matriz, i - 1, j, palavra1, palavra2);
			System.out.print("I" + palavra2.charAt(i - 1) + formata(j + 1 + delta));
			delta++;
		} else if (i > 0 && j > 0 && matriz[i - 1][j - 1] + 1 == matriz[i][j]) {
			imprimeOperacoes(matriz, i - 1, j - 1, palavra1, palavra2);
			System.out.print("C" + palavra2.charAt(i - 1) + formata(j + delta));
		} else if (i > 0 && j > 0) {
			imprimeOperacoes(matriz, i - 1, j - 1, palavra1, palavra2);
		}
	}

	static String formata(int i) {
		String valor = String.valueOf(i);
		if (valor.length() == 2) return valor;
		return "0" + valor;
	}

}
