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
		int size = Integer.parseInt(readLn());
		
		while (size != 0) {
			
			int[][] matriz = new int[size][size];
			
			for (int i = 0; i < size; i++) {
				String linha = readLn();
				StringTokenizer tks = new StringTokenizer(linha);
				
				for (int j = 0; j < size; j++) {
					int valor = Integer.parseInt(tks.nextToken());
					
					matriz[i][j] = valor;
				}
			}
			
			// soma linhas e colunas
			int[] somaLinhas = somaLinhas(matriz);
			int[] somaColunas = somaColunas(matriz);
			
			if (isOk(somaLinhas, somaColunas)) {
				System.out.println("OK");
			} else if (isCorrupt(somaLinhas, somaColunas)) {
				System.out.println("Corrupt");
			} else {
				int nLinha = -1;
				int nColuna = -1;
				
				for (int i = 0; i < somaLinhas.length; i++) {
					if (somaLinhas[i] % 2 != 0) {
						nLinha = i + 1;
						break;
					}
				}
				
				for (int i = 0; i < somaColunas.length; i++) {
					if (somaColunas[i] % 2 != 0) {
						nColuna = i + 1;
						break;
					}
				}
				
				System.out.println("Change bit (" + nLinha + "," + nColuna + ")");
			}
			
			
			
			
			size = Integer.parseInt(readLn());
		}
	}
	
	static boolean isOk(int[] somaLinhas, int[] somaColunas) {
		for (int i = 0; i < somaLinhas.length; i++) {
			if (somaLinhas[i] % 2 != 0) return false;
		}
		
		for (int i = 0; i < somaColunas.length; i++) {
			if (somaColunas[i] % 2 != 0) return false;
		}
		
		return true;
	}
	
	static boolean isCorrupt(int[] somaLinhas, int[] somaColunas) {
		int cont = 0;
		for (int i = 0; i < somaLinhas.length; i++) {
			if (somaLinhas[i] % 2 != 0) cont++;
			if (cont > 1) return true;
		}
		
		cont = 0;
		for (int i = 0; i < somaColunas.length; i++) {
			if (somaColunas[i] % 2 != 0) cont++;
			if (cont > 1) return true;
		}
		
		return false;
	}
	
	static int[] somaLinhas(int[][] matriz) {
		int[] array = new int[matriz.length];
		
		for (int i = 0; i < matriz.length; i++) {
			int soma = 0;
			for (int j = 0; j < matriz.length; j++) {
				soma += matriz[i][j];
			}
			array[i] = soma;
		}
		
		return array;
	}
	
	static int[] somaColunas(int[][] matriz) {
		int[] array = new int[matriz.length];
		
		for (int j = 0; j < matriz.length; j++) {
			int soma = 0;
			for (int i = 0; i < matriz.length; i++) {
				soma += matriz[i][j];
			}
			array[j] = soma;
		}
		
		return array;
	}
	
}
