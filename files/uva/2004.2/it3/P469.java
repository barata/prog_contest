import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

class Main {

	static String readLn(int maxLg) { // utility function to read from stdin
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		String line = "";

		try {
			while (lg < maxLg) {
				car = System.in.read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}

		if ((car < 0) && (lg == 0))
			return (null); // eof
		return (new String(lin, 0, lg)).trim();
	}
	
	static char mapa[][] = new char[100][100];
	static int mask[][] = new int[100][100];
	static int nLinhas;
	static int nColunas;

	public static void main(String[] args) {
		int nTestes = Integer.parseInt(readLn(255));
		String linha;
		
		readLn(5);
		
		for (int f = 0; f < nTestes; f++) {
			
			nLinhas = 0;
			nColunas = 0;
			
			linha = readLn(110);
			while (linha.charAt(0) == 'L' || linha.charAt(0) == 'W') {
				
				nLinhas++;
				nColunas = linha.length();
				for (int i = 0; i < nColunas; i++) {
					mapa[nLinhas][i + 1] = linha.charAt(i);
				}
				
				linha = readLn(110);
			}
			
			reset(mask);

			do {
				StringTokenizer tks = new StringTokenizer(linha);
				int l = Integer.parseInt(tks.nextToken());
				int c = Integer.parseInt(tks.nextToken());
				
				System.out.println(calcula(l, c));
				
				linha = readLn(110);
			} while (linha != null && !linha.equals(""));
			
			if (f < nTestes - 1) System.out.println();

		}

	}
	
	static int calcula(int l, int c) {
		
		if (mask[l][c] == 0) {
			int cont = 0;
			
			Vector list = new Vector();
			list.addElement(new Termo(l, c));
			mask[l][c] = -1;
			
			while (! list.isEmpty() ) {
				Termo aux = (Termo) list.elementAt(0);
				list.removeElement(aux);
				
				if (mapa[aux.linha][aux.coluna] != 'W') continue;
				cont++;
				
				if (aux.linha > 1 && mask[aux.linha - 1][aux.coluna] == 0 && mapa[aux.linha - 1][aux.coluna] == 'W') {
					list.addElement(new Termo(aux.linha - 1, aux.coluna));
					mask[aux.linha - 1][aux.coluna] = -1;
				}
				if (aux.linha > 1 && aux.coluna < nColunas && mask[aux.linha - 1][aux.coluna + 1] == 0 && mapa[aux.linha - 1][aux.coluna + 1] == 'W') {
					list.addElement(new Termo(aux.linha - 1, aux.coluna + 1));
					mask[aux.linha - 1][aux.coluna + 1] = -1;
				}
				if (aux.coluna < nColunas && mask[aux.linha][aux.coluna + 1] == 0 && mapa[aux.linha][aux.coluna + 1] == 'W') {
					list.addElement(new Termo(aux.linha, aux.coluna + 1));
					mask[aux.linha][aux.coluna + 1] = -1;
				}
				if (aux.linha < nLinhas && aux.coluna < nColunas && mask[aux.linha + 1][aux.coluna + 1] == 0 && mapa[aux.linha + 1][aux.coluna + 1] == 'W') {
					list.addElement(new Termo(aux.linha + 1, aux.coluna + 1));
					mask[aux.linha + 1][aux.coluna + 1] = -1;
				}
				if (aux.linha < nLinhas && mask[aux.linha + 1][aux.coluna] == 0 && mapa[aux.linha + 1][aux.coluna] == 'W') {
					list.addElement(new Termo(aux.linha + 1, aux.coluna));
					mask[aux.linha + 1][aux.coluna] = -1;
				}
				if (aux.linha < nLinhas && nColunas > 1 && mask[aux.linha + 1][aux.coluna - 1] == 0 && mapa[aux.linha + 1][aux.coluna - 1] == 'W') {
					list.addElement(new Termo(aux.linha + 1, aux.coluna - 1));
					mask[aux.linha + 1][aux.coluna - 1] = -1;
				}
				if (nColunas > 1 && mask[aux.linha][aux.coluna - 1] == 0 && mapa[aux.linha][aux.coluna - 1] == 'W') {
					list.addElement(new Termo(aux.linha, aux.coluna - 1));
					mask[aux.linha][aux.coluna - 1] = -1;
				}
				if (nLinhas > 1 && nColunas > 1 && mask[aux.linha - 1][aux.coluna - 1] == 0 && mapa[aux.linha - 1][aux.coluna - 1] == 'W') {
					list.addElement(new Termo(aux.linha - 1, aux.coluna - 1));
					mask[aux.linha - 1][aux.coluna - 1] = -1;
				}
	
			}
			
			// preenche a mascara
			for (int i = 1; i <= nLinhas; i++) {
				for (int j = 1; j <= nColunas; j++) {
					if (mask[i][j] == -1) {
						mask[i][j] = cont;
					}
				}
			}
			
			return cont;
		}

		return mask[l][c];
	}
	
	static void reset(int mask[][]) {
		for (int i = 1; i <= nLinhas; i++) {
			for (int j = 1; j <= nColunas; j++) {
				mask[i][j] = 0;
			}
		}
	}

}
class Termo {
	public int linha;
	public int coluna;
	
	public Termo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
}