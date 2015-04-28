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
        return (buffer.toString()); 
    }

	public static void main(String[] args) {
		int nTestes = Integer.parseInt(readLn());
		
		char[][] array = new char[33][81];
		boolean[][] mark = new boolean[33][81];
		
		for (int g = 0; g < nTestes; g++) {
			String linha;
			int cont = 0;
			
			init(array, mark);

			do {
				linha = readLn();
				
				for (int i = 0; i < linha.length(); i++) {
					array[cont][i] = linha.charAt(i);
					mark[cont][i] = linha.charAt(i) != ' ';
				}
				
				cont++;
				
			} while (!linha.startsWith("_"));

			processa(array, mark);

			StringBuffer sb = new StringBuffer();
			
			for (int i = 0; i < array.length; i++) {
				sb.append(ltrim(new String(array[i])));
				sb.append('\n');
				if (array[i][0] == '_') break;
			}
			
			System.out.print(sb);
		}

	}
	
	static String ltrim(String string) {
		int i;
		for (i = string.length() - 1; i >= 0; i--) {
			if (string.charAt(i) != ' ') break;
		}
		return string.substring(0, i + 1);
	}

	static void init(char[][] array, boolean[][] mark) {
		for (int i = 0; i < mark.length; i++) {
			for (int j = 0; j < mark[i].length; j++) {
				array[i][j] = ' ';
				mark[i][j] = false;
			}
		}
	}

	static void processa(char[][] array, boolean[][] mark) {
		Coordenada coord = temAsterisco(array);
		
		while (coord.linha >= 0) {
			array[coord.linha][coord.coluna] = ' ';
			mark[coord.linha][coord.coluna] = false;
			preenche(array, mark, coord.linha, coord.coluna);
			
			coord = temAsterisco(array);
		}
	}
	
	static void preenche(char[][] array, boolean[][] mark, int linha, int coluna) {
		if (linha >= 0 && linha < array.length && coluna >= 0 && coluna < array[linha].length) {
			if (mark[linha][coluna] == false) {
				mark[linha][coluna] = true;

				if (linha > 0 && array[linha - 1].length > coluna && array[linha - 1][coluna] != ' ' && array[linha - 1][coluna] != '#' && array[linha - 1][coluna] != '_') array[linha][coluna] = '#';
				if (linha < array.length - 1 && array[linha + 1].length > coluna && array[linha + 1][coluna] != ' ' && array[linha + 1][coluna] != '#' && array[linha + 1][coluna] != '_') array[linha][coluna] = '#';
				if (coluna > 0 && array[linha][coluna - 1] != ' ' && array[linha][coluna - 1] != '#' && array[linha][coluna - 1] != '_') array[linha][coluna] = '#';
				if (coluna < array[linha].length - 1 && array[linha][coluna + 1] != ' ' && array[linha][coluna + 1] != '#' && array[linha][coluna + 1] != '_') array[linha][coluna] = '#';
				
				preenche(array, mark, linha - 1, coluna);
				preenche(array, mark, linha, coluna + 1);
				preenche(array, mark, linha + 1, coluna);
				preenche(array, mark, linha, coluna - 1);
			}
		}
	}
	
	static Coordenada temAsterisco(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == '*') return new Coordenada(i, j);
			}
			if (array[i][0] == '_') break;
		}
		return new Coordenada(-1, -1);
	}

}
class Coordenada {
	public int linha;
	public int coluna;

	public Coordenada(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
}