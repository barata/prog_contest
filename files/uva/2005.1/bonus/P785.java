import java.util.Vector;

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
	
	static char delim = 'X';

	public static void main(String[] args) {
		
		String linha;
		String linha2 = readLn();
		
		while (linha2 != null) {
			
			int cont = 0;
			
			char[][] matriz = new char[35][];
		
			do {
				linha = linha2;
				
				matriz[cont] = new char[linha.length()];

				for (int i = 0; i < matriz[cont].length; i++) {
					matriz[cont][i] = linha.charAt(i);
				}

				cont++;
				
				if (!linha.startsWith("_")) linha2 = readLn();
				
			} while (!linha.startsWith("_"));
			
			setDelim(matriz);
			
			processa(matriz);
			
			StringBuffer sb = new StringBuffer();
			
			for (int i = 0; i < matriz.length; i++) {
				if (matriz[i].length > 0) {
					for (int j = 0; j < matriz[i].length; j++) {
						sb.append(matriz[i][j]);
					}
					sb.append("\n");
					if (matriz[i][0] == '_') break;
				} else {
					sb.append("\n");
				}
			}
			
			System.out.print(sb);
			
			
			linha2 = readLn();
		}
	}
	
	static void processa(char[][] array) {
		Vector marcas = getMarcas(array);
		
		while (! marcas.isEmpty() ) {
			Coordenada coord = (Coordenada) marcas.firstElement();
			marcas.removeElementAt(0);
			
			array[coord.linha][coord.coluna] = ' ';
			
			preenche(array, coord.linha, coord.coluna, coord.simbolo);
		}
	}
	
	static void preenche(char[][] array, int linha, int coluna, char simbolo) {
		if (linha >= 0 && linha < array.length && coluna >= 0 && coluna < array[linha].length) {
			if (array[linha][coluna] == ' ') {
				array[linha][coluna] = simbolo;
				
				preenche(array, linha - 1, coluna, simbolo);
				preenche(array, linha, coluna + 1, simbolo);
				preenche(array, linha + 1, coluna, simbolo);
				preenche(array, linha, coluna - 1, simbolo);
			}
		}
	}
	
	static Vector getMarcas(char[][] array) {
		Vector lista = new Vector();
		
		for (int i = 0; i < array.length; i++) {
			if (array[i].length > 0) {
				if (array[i][0] == '_') break;
				for (int j = 0; j < array[i].length; j++) {
					if (array[i][j] != ' ' && array[i][j] != delim) lista.addElement(new Coordenada(i, j, array[i][j]));
				}
			}
		}
		
		return lista;
	}

	static void setDelim(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].length > 0) {
				for (int j = 0; j < array[i].length; j++) {
					if (array[i][j] != ' ') {
						delim = array[i][j];
						return;
					}
				}
				if (array[i][0] == '_') break;
			}
		}
	}
}

class Coordenada {
	public int linha;
	public int coluna;
	public char simbolo;

	public Coordenada(int linha, int coluna, char simbolo) {
		this.linha = linha;
		this.coluna = coluna;
		this.simbolo = simbolo;
	}
	
	public String toString() {
		return "L = " + this.linha + ", C = " + this.coluna + ", CH = " + this.simbolo;
	}
}