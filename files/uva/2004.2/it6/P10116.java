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
            if (car == newLine.charAt(0)) 
            System.in.skip(newLine.length() - 1); 
        } catch (java.io.IOException e) { return (null);} 
        if ((car < 0) && (buffer.length() == 0)) return (null); 
        return (buffer.toString()).trim(); 
    }

	public static void main(String[] args) {
		String linha;
		StringTokenizer tks;
		
		linha = readLn();
		tks = new StringTokenizer(linha);
		
		int nLinhas = Integer.parseInt(tks.nextToken());
		int nColunas = Integer.parseInt(tks.nextToken());
		int colunaInicial =  Integer.parseInt(tks.nextToken());
		
		while (! (nLinhas == 0 && nColunas == 0 && colunaInicial == 0) ) {
			
			char[][] mapa = new char[nLinhas][nColunas];
			
			for (int i = 0; i < nLinhas; i++) {
				linha = readLn();

				for (int j = 0; j < nColunas; j++) {
					mapa[i][j] = linha.charAt(j);
				}
			}
			
			int[][] mask = new int[nLinhas][nColunas];
			for (int i = 0; i < nLinhas; i++) {
				for (int j = 0; j < nColunas; j++) {
					mask[i][j] = -1;
				}
			}

			int l = 0;
			int c = colunaInicial - 1;
			
			mask[l][c] = 0;
			
			int deltaLinha = getDeltaLinha(mapa[l][c]);
			int deltaColuna = getDeltaColuna(mapa[l][c]);
			
			int codigo = 0;
			
			if (l + deltaLinha < 0 || l + deltaLinha >= nLinhas || c + deltaColuna < 0 || c + deltaColuna >= nColunas) {
				codigo = 1;
			} else if (mask[l + deltaLinha][c + deltaColuna] != -1) {
				codigo = 2;
			}
			
			while (codigo == 0) {
				mask[l + deltaLinha][c + deltaColuna] = mask[l][c] + 1;
				l += deltaLinha;
				c += deltaColuna;
				
				deltaLinha = getDeltaLinha(mapa[l][c]);
				deltaColuna = getDeltaColuna(mapa[l][c]);

				if (l + deltaLinha < 0 || l + deltaLinha >= nLinhas || c + deltaColuna < 0 || c + deltaColuna >= nColunas) {
					codigo = 1;
				} else if (mask[l + deltaLinha][c + deltaColuna] != -1) {
					codigo = 2;
				}
			}
			
			if (codigo == 1) {
				System.out.println((mask[l][c] + 1) + " step(s) to exit");
			} else {
				System.out.println((mask[l + deltaLinha][c + deltaColuna]) + " step(s) before a loop of " + (mask[l][c] + 1 - mask[l + deltaLinha][c + deltaColuna]) + " step(s)");
			}
			
			
			
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			nLinhas = Integer.parseInt(tks.nextToken());
			nColunas = Integer.parseInt(tks.nextToken());
			colunaInicial =  Integer.parseInt(tks.nextToken());
		}
	}

	private static void imprime(int[][] mask) {
		for (int i = 0; i < mask.length; i++) {
			for (int j = 0; j < mask[i].length; j++) {
				System.out.print(" " + mask[i][j]);
			}
			System.out.println();
		}
	}

	static int getDeltaLinha(char valor) {
		switch (valor) {
			case 'N': return -1;
			case 'S': return 1;
			default: return 0;
		}
	}
	
	static int getDeltaColuna(char valor) {
		switch (valor) {
			case 'W': return -1;
			case 'E': return 1;
			default: return 0;
		}
	}

}
