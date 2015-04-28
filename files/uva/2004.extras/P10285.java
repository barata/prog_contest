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
		
		for (int g = 0; g< nTestes; g++) {
			String linha = readLn();
			StringTokenizer tks = new StringTokenizer(linha);
			
			String cidade = tks.nextToken();
			int nLinhas = Integer.parseInt(tks.nextToken());
			int nColunas = Integer.parseInt(tks.nextToken());
			
			int[][] matriz = new int[nLinhas][nColunas];
			
			for (int i = 0; i < nLinhas; i++) {
				linha = readLn();
				tks = new StringTokenizer(linha);
				
				for (int j = 0; j < nColunas; j++) {
					int valor = Integer.parseInt(tks.nextToken());
					
					matriz[i][j] = valor;
				}
			}
			
			System.out.println(cidade + ": " + calculaMaiorDistancia(matriz));
		}
	}
	
	static int calculaMaiorDistancia(int[][] m) {
		int max = 0;
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				max = Math.max(max, calculaDistancia(m, Integer.MAX_VALUE, i, j));
			}
		}
		
		return max;
	}
	
	static int calculaDistancia(int[][] m, int altura, int linha, int coluna) {
		
		if (linha < 0 || linha > m.length - 1 || coluna < 0 || coluna > m[linha].length - 1) return 0;
		
		if (altura > m[linha][coluna]) {
			int cima = calculaDistancia(m, m[linha][coluna], linha - 1, coluna);
			int baixo = calculaDistancia(m, m[linha][coluna], linha + 1, coluna);
			int esquerda = calculaDistancia(m, m[linha][coluna], linha, coluna - 1);
			int direita = calculaDistancia(m, m[linha][coluna], linha, coluna + 1);
			
			return 1 + Math.max(Math.max(Math.max(cima, baixo), esquerda), direita);
		} else {
			return 0;
		}
		
	}

}
