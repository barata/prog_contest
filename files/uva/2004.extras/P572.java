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
		String linha = readLn();
		StringTokenizer tks = new StringTokenizer(linha);
		
		int m = Integer.parseInt(tks.nextToken());
		int n = Integer.parseInt(tks.nextToken());
		
		while (m != 0) {
			
			char[][] array = new char[m][n];
			
			for (int i = 0; i < m; i++) {
				linha = readLn();
				
				for (int j = 0; j < n; j++) {
					array[i][j] = linha.charAt(j);
				}
			}
			
			System.out.println(processa(array));
			
			
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			m = Integer.parseInt(tks.nextToken());
			n = Integer.parseInt(tks.nextToken());
		}
		
	}

	static int processa(char[][] array) {
		int cont = 0;
		
		Coordenada coord = temOil(array);
		
		while (coord.linha >= 0) {
			cont++;
			enterraOil(array, coord.linha, coord.coluna);
			
			coord = temOil(array);
		}
		
		return cont;
	}
	
	static void enterraOil(char[][] array, int linha, int coluna) {
		if (linha >= 0 && linha < array.length && coluna >= 0 && coluna < array[linha].length) {
			if (array[linha][coluna] == '@') {
				array[linha][coluna] = '*';
				
				enterraOil(array, linha - 1, coluna - 1);
				enterraOil(array, linha - 1, coluna);
				enterraOil(array, linha - 1, coluna + 1);
				enterraOil(array, linha, coluna + 1);
				enterraOil(array, linha + 1, coluna + 1);
				enterraOil(array, linha + 1, coluna);
				enterraOil(array, linha + 1, coluna - 1);
				enterraOil(array, linha, coluna - 1);
			}
		}
	}
	
	static Coordenada temOil(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == '@') return new Coordenada(i, j);
			}
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