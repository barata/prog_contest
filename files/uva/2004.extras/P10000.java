import java.util.*;
import java.io.*;

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

	public static void main(String[] args) {

		String linha;
		StringTokenizer tks;
		
		int nCase = 0;

		linha = readLn(255);

		while (! linha.equals("0") ) {
		
			int numeroDeVertices = Integer.parseInt(linha);
			int origem = Integer.parseInt(readLn(255));

			Vector grafo = new Vector();
			for (int i = 0; i <= numeroDeVertices; i++) {
				grafo.addElement(new Nodo(i));
			}

			Nodo nodoOrigem = (Nodo) grafo.elementAt(origem);
			nodoOrigem.dist = 0;
			
			linha = readLn(255);
			while (! linha.equals("0 0") ) {
				tks = new StringTokenizer(linha);

				int valor1 = Integer.parseInt(tks.nextToken());
				int valor2 = Integer.parseInt(tks.nextToken());
				Nodo nodo1 = (Nodo) grafo.elementAt(valor1);
				Nodo nodo2 = (Nodo) grafo.elementAt(valor2);
				
				nodo1.adj.addElement(nodo2);

				linha = readLn(255);
			}
			
			calculaMaiorDistancia(nodoOrigem);
			
			int max = -1;
			int ultimoValor = Integer.MAX_VALUE;
			
			for (int i = 1; i < grafo.size(); i++) {
				Nodo auxNodo = (Nodo) grafo.elementAt(i);

				if (auxNodo.dist > max) {
					max = auxNodo.dist;
					ultimoValor = auxNodo.valor;
				} else if (auxNodo.dist == max) {
					if (auxNodo.valor < ultimoValor) {
						ultimoValor = auxNodo.valor;
					}
				}
			}

			System.out.println("Case " + (++nCase) + ": The longest path from " + origem + " has length " + max + ", finishing at " + ultimoValor + ".");
			System.out.println();

			linha = readLn(255);

		}

	}
	
	static void calculaMaiorDistancia(Nodo inicio) {
		
		for (int i = 0; i < inicio.adj.size(); i++) {
			Nodo nodo = (Nodo) inicio.adj.elementAt(i);
			
			if (inicio.dist + 1 > nodo.dist) {
				nodo.dist = inicio.dist + 1;
				calculaMaiorDistancia(nodo);
			}
		}
		
	}

}

class Nodo {

	public int valor;
	public Vector adj;

	public int dist;
	
	public Nodo(int valor) {
		this.valor = valor;
		this.adj = new Vector();

		this.dist = -1;
	}

	public String toString() {
		return String.valueOf(valor);
	}
}