import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;

class Main {
	
	static boolean bool;

	public static void main(String[] args) {
		Scanner sc = new Scanner();
		
		int nTeste = 0;
		
		int origem = sc.getInt();
		int destino = sc.getInt();
		
		while (origem >= 0 || destino >= 0) {
			
			Hashtable grafo = new Hashtable();
			
			while (origem != 0 || destino != 0) {
				Integer a = new Integer(origem);
				Integer b = new Integer(destino);
				
				Node nodeOrigem;
				Node nodeDestino;
				
				if (!grafo.containsKey(a)) grafo.put(a, new Node(a.intValue()));
				if (!grafo.containsKey(b)) grafo.put(b, new Node(b.intValue()));
					
				nodeOrigem = (Node) grafo.get(a);
				nodeDestino = (Node) grafo.get(b);
				
				// liga os nodes
				nodeOrigem.adj.addElement(nodeDestino);
				nodeDestino.pai.addElement(nodeOrigem);
				
				origem = sc.getInt();
				destino = sc.getInt();
			}
			

			
			System.out.print("Case "+(++nTeste)+" is");
			if (!isATree(grafo)) System.out.print(" not");
			System.out.println(" a tree.");
			
			
			origem = sc.getInt();
			destino = sc.getInt();
		}
	}
	
	static boolean isATree(Hashtable grafo) {
		if (grafo.isEmpty()) return true;
		
		Node raiz = condicoes_1e2(grafo.elements());
		if (raiz == null) return false;

		bool = true;
		condicao_3(raiz);
		return bool && condicao_4(grafo.elements());
	}
	
	static Node condicoes_1e2(Enumeration e) {
		Node raiz = null;
		
		while (e.hasMoreElements()) {
			Node n = (Node) e.nextElement();
			
			if (n.pai.isEmpty()) {
				if (raiz != null) return null;
				raiz = n;
			}
			else if (n.pai.size() != 1) return null;
		}
		
		return raiz;
	}
	
	static void condicao_3(Node raiz) {
		
		raiz.visitado = true;
		
		for (int i = 0; i < raiz.adj.size(); i++) {
			Node aux = (Node) raiz.adj.elementAt(i);
			if (aux.visitado) {
				bool = false;
				return;
			}
			condicao_3(aux);
		}
		
	}
	
	static boolean condicao_4(Enumeration e) {
		while (e.hasMoreElements()) {
			Node n = (Node) e.nextElement();
			
			if (!n.visitado) return false;
		}
		return true;
	}

}

class Node {
	public int valor;
	public Vector adj;
	public Vector pai;
	public boolean visitado;
	
	public Node(int valor) {
		this.valor = valor;
		this.adj = new Vector();
		this.pai = new Vector();
		this.visitado = false;
	}
	
	public String toString() {
		return "" + this.valor;
	}
}

class Scanner {

	StringTokenizer st = null;

	int getInt() {
		if (st == null)
			st = new StringTokenizer(Reader.readLn());
		while (!st.hasMoreTokens())
			st = new StringTokenizer(Reader.readLn());
		return Integer.parseInt(st.nextToken());
	}
	
	Integer getInteger() {
		if (st == null)
			st = new StringTokenizer(Reader.readLn());
		while (!st.hasMoreTokens())
			st = new StringTokenizer(Reader.readLn());
		return new Integer(st.nextToken());
	}

}

class Reader {
	static String readLn() {
		String newLine = System.getProperty("line.separator");
		StringBuffer buffer = new StringBuffer();
		int car = -1;
		try {
			car = System.in.read();
			while ((car > 0) && (car != newLine.charAt(0))) {
				buffer.append((char) car);
				car = System.in.read();
			}
			if (car == newLine.charAt(0))
				System.in.skip(newLine.length() - 1);
		} catch (java.io.IOException e) {
			return (null);
		}
		if ((car < 0) && (buffer.length() == 0))
			return (null);
		return (buffer.toString()).trim();
	}
}