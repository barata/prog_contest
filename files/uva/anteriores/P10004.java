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
		StringTokenizer tokens;
		
		linha = readLn(255);
		
		while (! linha.equals("0") ) {
		
			int numeroDeNodos = Integer.parseInt(linha);
			linha = readLn(255);
			int numeroDeArestas = Integer.parseInt(linha);
			
			Nodo[] grafo = new Nodo[ numeroDeNodos ];
			
			for (int i = 0; i < numeroDeArestas; i++) {
			
				linha = readLn(255);
				tokens = new StringTokenizer(linha);
			
				int valor1 = Integer.parseInt(tokens.nextToken());
				int valor2 = Integer.parseInt(tokens.nextToken());
				
				if (grafo[valor1] == null) {
					grafo[valor1] = new Nodo(valor1);
				}
				if (grafo[valor2] == null) {
					grafo[valor2] = new Nodo(valor2);
				}
				
				grafo[valor1].adj.addElement(grafo[valor2]);
				grafo[valor2].adj.addElement(grafo[valor1]);
			
			}
			
			boolean ehBicolor = preparaGrafo(grafo[0]);

			if (ehBicolor) {
				System.out.println("BICOLORABLE.");
			} else {
				System.out.println("NOT BICOLORABLE.");
			}
			
			
			linha = readLn(255);
		}
	
	}

	public static final int BRANCO = 0;
	public static final int CINZA = 1;
	public static final int PRETO  = 2;

	static boolean preparaGrafo(Nodo nodo) {

		nodo.cor = CINZA;
		nodo.dist = 0;
		
		Stack pilha = new Stack();
		
		pilha.push(nodo);
		
		while (pilha.size() != 0) {
		
			Nodo u = (Nodo) pilha.pop();
			
			for (int i = 0; i < u.adj.size(); i++) {
				Nodo aux = (Nodo) u.adj.elementAt(i);
				
				if (aux.cor == BRANCO) {
					aux.cor = CINZA;
					aux.dist = (u.dist + 1) % 2;
					pilha.push(aux);
				}
				
				if (aux.dist == u.dist) return false;
			}
			
			u.cor = PRETO;
		}

		return true;
	}
}

class Nodo {

	public int valor;
	public Vector adj;
	public int cor;
	public int dist;
	
	public Nodo(int valor) {
		this.valor = valor;
		this.cor = Main.BRANCO;
		this.adj = new Vector();
		this.dist = Integer.MAX_VALUE;
	}

}