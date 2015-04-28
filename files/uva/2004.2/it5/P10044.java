import java.io.IOException;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;

class Main {

	static String readLn(int maxLg) { // utility function to read from stdin
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;

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
	
	static final String ERDOS_NAME = "Erdos, P.";
	
	static Hashtable grafo = new Hashtable();

	public static void main(String[] args) {
		String linha;
		StringTokenizer tks;

		linha = readLn(10);

		int nTestes = Integer.parseInt(linha);
		
		for (int g = 1; g <= nTestes; g++) {
			linha = readLn(20);
			tks = new StringTokenizer(linha);
			
			int numeroDeObras = Integer.parseInt(tks.nextToken());
			int numeroDeAutores = Integer.parseInt(tks.nextToken());
			
			grafo.clear();
			Nodo erdosNodo = new Nodo(ERDOS_NAME);
			grafo.put(ERDOS_NAME, erdosNodo);

			// monta o grafo
			for (int i = 0; i < numeroDeObras; i++) {
				linha = readLn(500);
				
				Vector autores = getAutores(linha);

				// conecta todos a Erdos
				if (autores.contains(ERDOS_NAME)) {
					
					for (int j = 0; j < autores.size(); j++) {
						String autorNome = (String) autores.elementAt(j);
						if (autorNome.equals(ERDOS_NAME)) continue;
						
						Nodo autorNodo = getAutorNodo(autorNome);
						if (autorNodo == null) {
							autorNodo = new Nodo(autorNome);
							grafo.put(autorNome, autorNodo);
						}
						
						if (!erdosNodo.adj.contains(autorNodo)) erdosNodo.adj.addElement(autorNodo);
						if (!autorNodo.adj.contains(erdosNodo)) autorNodo.adj.addElement(erdosNodo);
					}

				} else { // conecta o grafo
					
					conectaGrafo(autores);

				}
			}

			buscaAmplitude(erdosNodo, linha);
			
			System.out.println("Scenario " + g);
			
			// processa cada autor
			for (int i = 0; i < numeroDeAutores; i++) {
				linha = readLn(30);
				
				Nodo autorNodo = getAutorNodo(linha);
				
				int numero = -1;
				if (autorNodo != null) numero = autorNodo.d;

				if (numero <= 0) System.out.println(linha + " infinity");
				else System.out.println(linha + " " + numero);
			}

		}
	}
	
	static void buscaAmplitude(Nodo inicio, String key) {
		Vector lista = new Vector();
		inicio.d = 0;
		inicio.visitado = true;
		lista.addElement(inicio);
		
		while (!lista.isEmpty()) {
			Nodo elemento = (Nodo) lista.firstElement();
			lista.removeElementAt(0);

			for (int i = 0; i < elemento.adj.size(); i++) {
				Nodo nodo = (Nodo) elemento.adj.elementAt(i);
				if (! nodo.visitado ) {
					nodo.d = elemento.d + 1;
					nodo.visitado = true;
					lista.addElement(nodo);
				}
			}
			
		}
	}

	static void conectaGrafo(Vector nomes) {
		// insere os nodos que ainda não estao no grafo
		for (int i = 0; i < nomes.size(); i++) {
			String autorNome = (String) nomes.elementAt(i);
			
			Nodo autorNodo = getAutorNodo(autorNome);
			if (autorNodo == null) {
				autorNodo = new Nodo(autorNome);
				grafo.put(autorNome, autorNodo);
			}
		}
		
		// conecta nodos
		for (int i = 0; i < nomes.size() - 1; i++) {
			Nodo n1 = getAutorNodo((String) nomes.elementAt(i));
			for (int j = i + 1; j < nomes.size(); j++) {
				Nodo n2 = getAutorNodo((String) nomes.elementAt(j));
				
				if (!n1.adj.contains(n2)) n1.adj.addElement(n2);
				if (!n2.adj.contains(n1)) n2.adj.addElement(n1);
			}
		}
	}

	static Nodo getAutorNodo(String nome) {
		return (Nodo) grafo.get(nome);
	}
	
	static Vector getAutores(String linha) {
		Vector resultado = new Vector();
		String autor;
		int tamanho;

		linha = linha.substring(0, linha.lastIndexOf(':'));

		do {
			
			tamanho = linha.indexOf(',', linha.indexOf(',') + 1);
			if (tamanho >= 0) {
				autor = linha.substring(0, tamanho);
				linha = linha.substring(tamanho + 1).trim();
			} else {
				autor = linha;
			}
			
			resultado.addElement(autor.trim());
			
		} while (tamanho >= 0);
		
		return resultado;
	}
}
class Nodo {
	public String valor;
	public Vector adj;
	public int d;
	public boolean visitado;
	
	public Nodo(String valor) {
		this.valor = valor;
		this.adj = new Vector();
		this.d = 0;
		this.visitado = false;
	}
	
	public boolean equals(Object o) {
		if (! (o instanceof Nodo)) return false;
		
		Nodo other = (Nodo) o;
		return this.valor.equals(other.valor);
	}
	
	public String toString() {
		return this.valor;
	}
}