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
		
		for (int g = 0; g < nTestes; g++) {
			String linha;
			int cont = 0;
			
			char[][] array = new char[31][];
		
			do {
				linha = readLn();
				array[cont] = new char[linha.length()];
				
				for (int i = 0; i < array[cont].length; i++) {
					array[cont][i] = linha.charAt(i);
				}
				
				cont++;
				
			} while (!linha.startsWith("_"));
			
			processa(array);
			
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					System.out.print(array[i][j]);
				}
				System.out.println();
				if (array[i][0] == '_') break;
			}
		}
	}
	
	static void processa(char[][] array) {
		Coordenada coord = temAsterisco(array);
		
		while (coord.linha >= 0) {
			preenche(array, coord.linha, coord.coluna);
			
			coord = temAsterisco(array);
		}
	}
	
	static void preenche(char[][] array, int linha, int coluna) {
		if (linha >= 0 && linha < array.length && coluna >= 0 && coluna < array[linha].length) {
			if (array[linha][coluna] == ' ' || array[linha][coluna] == '*') {
				array[linha][coluna] = '#';
				
				preenche(array, linha - 1, coluna);
				preenche(array, linha, coluna + 1);
				preenche(array, linha + 1, coluna);
				preenche(array, linha, coluna - 1);
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