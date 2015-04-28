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
            if (car == newLine.charAt(0)) 
            System.in.skip(newLine.length() - 1); 
        } catch (java.io.IOException e) { return (null);} 
        if ((car < 0) && (buffer.length() == 0)) return (null); 
        return (buffer.toString()).trim(); 
    }
	
	static int delta;
	static int cont;

	public static void main(String[] args) {
		String palavra1 = readLn();
		boolean devePularLinha = false;
		
		while (palavra1 != null) {
			String palavra2 = readLn();
			
			int[][] array = distanciaEdicaoMinima(palavra1, palavra2);
			
			delta = 0;
			cont = 0;
			
			if (devePularLinha) System.out.println();
			System.out.println(array[array.length - 1][array[0].length - 1]);
			imprimeOperacoes(array, array.length - 1, array[0].length - 1, palavra1, palavra2);
			devePularLinha = true;
			
			
			palavra1 = readLn();
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
			System.out.println((++cont) + " Delete " + (j+delta));
			delta--;
		} else if (i > 0 && j > 0 && matriz[i - 1][j - 1] + 1 == matriz[i][j]) {
			imprimeOperacoes(matriz, i - 1, j - 1, palavra1, palavra2);
			System.out.println((++cont) + " Replace " + (j+delta) + "," + palavra2.charAt(i - 1));
		} else if (i > 0 && matriz[i - 1][j] + 1 == matriz[i][j]) {
			imprimeOperacoes(matriz, i - 1, j, palavra1, palavra2);
			System.out.println((++cont) + " Insert " + (j+1+delta) + "," + palavra2.charAt(i - 1));
			delta++;
		} else if (i > 0 && j > 0) {
			imprimeOperacoes(matriz, i - 1, j - 1, palavra1, palavra2);
		}
	}

}
