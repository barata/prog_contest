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
		int nTestes = Integer.parseInt(readLn());
		
		for (int g = 0; g < nTestes; g++) {
			String linha = readLn();
			StringTokenizer tks = new StringTokenizer(linha);
			
			int m = Integer.parseInt(tks.nextToken());
			int n = Integer.parseInt(tks.nextToken());
			
			char[][] matriz = new char[m][n];
			boolean[][] mask = new boolean[m][n];
			
			for (int i = 0; i < m; i++) {
				linha = readLn();

				linha.getChars(0, n, matriz[i], 0);
			}
			
			String res = busca(matriz, mask);
			System.out.println(res.trim());
		}
	}

	static String busca(char[][] matriz, boolean[][] mask) {
		int linha = matriz.length - 1;
		int coluna;
		
		for (coluna = 0; coluna < matriz[linha].length && matriz[linha][coluna] != '@'; coluna++);
		
		return busca(matriz, mask, linha, coluna, '@');
	}

	static String busca(char[][] matriz, boolean[][] mask, int linha, int coluna, char ch) {
		if (ch == '-' || matriz[linha][coluna] != ch) {
			return "";
		}
		
		mask[linha][coluna] = true;
		
		StringBuffer resultado1 = new StringBuffer();
		StringBuffer resultado2 = new StringBuffer();
		StringBuffer resultado3 = new StringBuffer();
		char nextChar = getNextChar(ch);

		if (linha >= 0 && linha < matriz.length && coluna > 0 && coluna < matriz[linha].length)
			if (!mask[linha][coluna - 1] && matriz[linha][coluna - 1] == nextChar)
				resultado1.append(" left" + busca(matriz, mask, linha, coluna - 1, nextChar));
		if (linha >= 0 && linha < matriz.length && coluna >= 0 && coluna < matriz[linha].length - 1)
			if (!mask[linha][coluna + 1] && matriz[linha][coluna + 1] == nextChar)
				resultado2.append(" right" + busca(matriz, mask, linha, coluna + 1, nextChar));
		if (linha > 0 && linha < matriz.length && coluna >= 0 && coluna < matriz[linha].length)
			if (!mask[linha - 1][coluna] && matriz[linha - 1][coluna] == nextChar)
				resultado3.append(" forth" + busca(matriz, mask, linha - 1, coluna, nextChar));

		int len1 = resultado1.length();
		int len2 = resultado2.length();
		int len3 = resultado3.length();
		
		if (len1 > len2 && len1 > len3) return resultado1.toString();
		if (len2 > len1 && len2 > len3) return resultado2.toString();
		return resultado3.toString();
	}
	
	static char getNextChar(char atual) {
		switch (atual) {
			case '@': return 'I';
			case 'I': return 'E';
			case 'E': return 'H';
			case 'H': return 'O';
			case 'O': return 'V';
			case 'V': return 'A';
			case 'A': return '#';
			default: return '-';
		}
	}

}
