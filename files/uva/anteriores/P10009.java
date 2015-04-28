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
		
		linha = readLn(255);
		int nTestes = Integer.parseInt(linha);
		
		for (int k = 0; k < nTestes; k++) {
		
			readLn(255);
			
			linha = readLn(255);
			tks = new StringTokenizer(linha);
			
			int numeroDeArestas = Integer.parseInt(tks.nextToken());
			int numeroDeQueries = Integer.parseInt(tks.nextToken());
			Hashtable grafo = new Hashtable();
			
			for (int i = 0; i < numeroDeArestas; i++) {

				linha = readLn(255);
				tks = new StringTokenizer(linha);
				
				Character vertice1 = new Character(tks.nextToken().charAt(0));
				Character vertice2 = new Character(tks.nextToken().charAt(0));

				Nodo nodo1 = (Nodo) grafo.get(vertice1);
				Nodo nodo2 = (Nodo) grafo.get(vertice2);

				if (nodo1 == null) {
					nodo1 = new Nodo(vertice1.charValue());
					grafo.put(vertice1, nodo1);
				}
				if (nodo2 == null) {
					nodo2 = new Nodo(vertice2.charValue());
					grafo.put(vertice2, nodo2);
				}
				
				nodo1.adj.addElement(nodo2);
				nodo2.adj.addElement(nodo1);

			}

			for (int i = 0; i < numeroDeQueries; i++) {

				linha = readLn(255);
				tks = new StringTokenizer(linha);
				
				Character vertice1 = new Character(tks.nextToken().charAt(0));
				Character vertice2 = new Character(tks.nextToken().charAt(0));

				Nodo nodo1 = (Nodo) grafo.get(vertice1);
				Nodo nodo2 = (Nodo) grafo.get(vertice2);

				dijkstra(grafo, nodo1);

				imprimeResultado(grafo, nodo2);
				System.out.println();

			}

			if (k != nTestes - 1) {
				System.out.println();
			}

		}
	
	}

	static void imprimeResultado(Hashtable grafo, Nodo nodo) {

		if (nodo.pred != null) {
			imprimeResultado(grafo, nodo.pred);
		}
		System.out.print(nodo);

	}

	static Vector createVector(Enumeration enum) {
	
		Vector lista = new Vector();
		
		while (enum.hasMoreElements()) {
			lista.addElement(enum.nextElement());
		}
		
		return lista;
	
	}

	static void dijkstra(Hashtable grafo, Nodo inicio) {

		Vector listaDeNodos = createVector(grafo.elements());

		inicializa(grafo, inicio);

		while (! listaDeNodos.isEmpty() ) {

			Nodo u = removeMinimo(listaDeNodos);

			Enumeration it = u.adj.elements();
			while (it.hasMoreElements()) {
				Nodo nodo = (Nodo) it.nextElement();

				relaxe(u, nodo);
			}

		}

	}

	static Nodo removeMinimo(Vector lista) {

		Nodo menorNodo = new Nodo(' ');
		menorNodo.dist = Integer.MAX_VALUE;
		Enumeration it = lista.elements();

		while (it.hasMoreElements()) {

			Nodo nodo = (Nodo) it.nextElement();

			if (nodo.dist < menorNodo.dist) {
				menorNodo = nodo;
			}

		}

		lista.removeElement(menorNodo);

		return (Nodo) menorNodo;

	}

	static void relaxe(Nodo u, Nodo v) {
		if (v.dist > u.dist + 1) {
			v.dist = u.dist + 1;
			v.pred = u;
		}
	}

	static void inicializa(Hashtable grafo, Nodo inicio) {

		Enumeration it = grafo.elements();

		while (it.hasMoreElements()) {

			Nodo nodo = (Nodo) it.nextElement();

			nodo.dist = Integer.MAX_VALUE;
			nodo.pred = null;

		}

		inicio.dist = 0;

	}

}

class Nodo {

	public char valor;
	public Vector adj;

	public int dist;
	public Nodo pred;
	
	public Nodo(char valor) {
		this.valor = valor;
		this.adj = new Vector();

		this.dist = 0;
		this.pred = null;
	}

	public String toString() {
		return String.valueOf(valor);
	}
}