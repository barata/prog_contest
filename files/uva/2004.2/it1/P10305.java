import java.io.IOException;
import java.util.Enumeration;
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
	
	static void dfs(Nodo[] grafo) {
		for (int i = 1; i < grafo.length; i++) {
			if (grafo[i].cor == Nodo.BRANCO) {
				dfsVisit(grafo[i]);
			}
		}
	}
	
	static void dfsVisit(Nodo nodo) {
		nodo.cor = Nodo.CINZA;
		
		Enumeration enum  = nodo.adj.elements();
		while (enum.hasMoreElements()) {
			Nodo aux = (Nodo) enum.nextElement();
			if (aux.cor == Nodo.BRANCO) {
				dfsVisit(aux);
			}
		}
		
		nodo.cor = Nodo.PRETO;
		resultado.addElement(nodo);
	}
	
	static Vector resultado;

	public static void main(String[] args) {
		String linha;
		StringTokenizer tks;
		
		linha = readLn(255);
		
		while (linha != null && !linha.equals("0 0")) {
			
			tks = new StringTokenizer(linha);
			int numeroDeNodos = Integer.parseInt(tks.nextToken());
			int numeroDeArestas = Integer.parseInt(tks.nextToken());
			
			Nodo[] nodos = new Nodo[numeroDeNodos + 1];
			for (int i = 1; i < nodos.length; i++) {
				nodos[i] = new Nodo(i);
			}
			
			for (int i = 0; i < numeroDeArestas; i++) {
				linha = readLn(255);
				tks = new StringTokenizer(linha);
				
				int origem = Integer.parseInt(tks.nextToken());
				int destino = Integer.parseInt(tks.nextToken());
				Nodo nodoOrigem = nodos[origem];
				Nodo nodoDestino = nodos[destino];
				
				nodoOrigem.adj.addElement(nodoDestino);
			}
			
			resultado = new Vector();
			dfs(nodos);
			
			imprime();
			
			linha = readLn(255);
		}
	}
	
	static void imprime() {
		for (int i = resultado.size() -1; i >= 0; i--) {
			System.out.print(resultado.elementAt(i));
			if (i > 0) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}
class Nodo {
	
	public static final int BRANCO = 0;
	public static final int CINZA = 1;
	public static final int PRETO = 2;
	
	public int valor;
	
	public int cor;
	
	public Vector adj;

	public Nodo(int valor) {
		this.valor = valor;
		this.cor = BRANCO;
		this.adj = new Vector();
	}
	
	public String toString() {
		return "" + valor;
	}
}
