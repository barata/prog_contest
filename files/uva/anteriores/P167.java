import java.io.*;
import java.util.*;

class Main {

	static String readLn (int maxLg)  // utility function to read from stdin
	{
		byte lin[] = new byte [maxLg];
		int lg = 0, car = -1;
		String line = "";

		try
		{
			while (lg < maxLg)
			{
				car = System.in.read();
				if ((car < 0) || (car == '\n')) break;
				lin [lg++] += car;
			}
		}
		catch (IOException e)
		{
			return (null);
		}

		if ((car < 0) && (lg == 0)) return (null);  // eof
		return (new String (lin, 0, lg)).trim();
	}

	static int soma;
	static int[][] matriz;

	public static void main(String[] args) {

		String linha;
		StringTokenizer tks;
		
		linha = readLn(255);
		int nTestes = Integer.parseInt(linha);
		
		for (int i = 0; i < nTestes; i++) {
		
			matriz = new int[8][8];
			soma = 0;
		
			for (int a = 0; a < 8; a++) {
			
				linha = readLn(255);
				tks = new StringTokenizer(linha);

				for (int b = 0; b < 8; b++) {
					matriz[a][b] = Integer.parseInt(tks.nextToken());
				}

			}

			montaArvore(new Nodo(), 1);
			
			System.out.println(str(' ', 5 - String.valueOf(soma).length()) + soma);

		}

	}

	static final int SIZE = 8;

	static void montaArvore(Nodo raiz, int nivel) {
	
		if (nivel <= SIZE) {
		
			for (int i = 0; i < SIZE; i++) {
			
				Nodo novoNodo = new Nodo();
				novoNodo.valores = (Vector) raiz.valores.clone();
				novoNodo.valores.addElement(new Integer(raiz.adj.size()));
			
				raiz.adj.addElement(novoNodo);
				
				if ( satisfaz(novoNodo) ) {
					montaArvore(novoNodo, nivel + 1);
				}

			}
			
		}
		else atualizaSoma(raiz.valores);
	
	}

	static boolean satisfaz(Nodo nodo) {
	
		for (int i = 0; i < nodo.valores.size() - 1; i++) {
			for (int j = i + 1; j < nodo.valores.size(); j++) {

				Integer valor1 = (Integer) nodo.valores.elementAt(i);
				Integer valor2 = (Integer) nodo.valores.elementAt(j);

				// mesma coluna
				if (valor1.equals(valor2)) {
					return false;
				}

				// mesma diagonal principal
				if (valor1.intValue() - i == valor2.intValue() - j) {
					return false;
				}

				// mesma diagonal secundaria
				if (valor1.intValue() + i == valor2.intValue() + j) {
					return false;
				}

			}
		}
		
		return true;
	
	}

	static void atualizaSoma(Vector valores) {
		int maiorSoma = 0;
		
		for (int i = 0; i < SIZE; i++) {
			
			int coluna = ((Integer) valores.elementAt(i)).intValue();
			maiorSoma += matriz[i][coluna];
			
		}
		
		if (maiorSoma > soma) {
			soma = maiorSoma;
		}
	}

	static String str(char ch, int numeroDeCaracteres) {
	
		String aux = "";
		
		for (int i = 0; i < numeroDeCaracteres; i++) {
			aux += ch;
		}
	
		return aux;
	}
}

class Nodo {

	Vector valores;
	Vector adj;
	
	public Nodo() {

		valores = new Vector();
		adj = new Vector();
	
	}

}