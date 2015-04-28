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

	public static void main(String[] args) {
		String linha = readLn();
		
		int nTestes = Integer.parseInt(linha);
		
		for (int g = 0; g < nTestes; g++) {
			readLn();
			linha = readLn();
			
			int n = Integer.parseInt(linha);
			
			boolean[][] mapa = new boolean[n + 2][n + 2];
			char[][] mask = new char[n + 2][n + 2];
			
			// preenche campo
			for (int i = 0; i < n; i++) {
				linha = readLn();
				
				for (int j = 0; j < n; j++) {
					if (linha.charAt(j) == '*') mapa[i + 1][j + 1] = true;
				}
			}
			
			// inicia mask
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= n; j++) {
					mask[i][j] = '.';
				}
			}
			
			// marca pontos
			boolean explodiu = false;
			for (int i = 0; i < n; i++) {
				linha = readLn();
				
				for (int j = 0; j < n; j++) {
					if (linha.charAt(j) == 'x') {
						
						if (!explodiu && mapa[i + 1][j + 1]) {
							for (int a = 0; a <= n; a++) {
								for (int b = 0; b <= n; b++) {
									if (mapa[a + 1][b + 1]) {
										mask[a + 1][b + 1] = '*';
									}
								}
							}
							
							explodiu = true;
						}
						
						if (! mapa[i + 1][j + 1] ) {
							mask[i + 1][j + 1] = String.valueOf(getNumeroDeBombas(mapa, i + 1, j + 1)).charAt(0);
						}
						
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(mask[i + 1][j + 1]);
				}
				System.out.println();
			}
			
			if (g < nTestes - 1) System.out.println();
		}
	}
	
	static int getNumeroDeBombas(boolean[][] array, int linha, int coluna) {
		int cont = 0;
		
		if (array[linha][coluna - 1]) cont++;
		if (array[linha - 1][coluna - 1]) cont++;
		if (array[linha - 1][coluna]) cont++;
		if (array[linha - 1][coluna + 1]) cont++;
		if (array[linha][coluna + 1]) cont++;
		if (array[linha + 1][coluna + 1]) cont++;
		if (array[linha + 1][coluna]) cont++;
		if (array[linha + 1][coluna - 1]) cont++;
		
		return cont;
	}
}
