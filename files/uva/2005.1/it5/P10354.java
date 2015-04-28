import java.util.StringTokenizer;
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
        return (buffer.toString()).trim(); 
    }
	
	static Nodo[] grafo;
	
	static int[][] pesos;

	public static void main(String[] args) {
		String linha = readLn();
		
		while (linha != null) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			int P = Integer.parseInt(tks.nextToken());
			int R = Integer.parseInt(tks.nextToken());
			int BH = Integer.parseInt(tks.nextToken());
			int OF = Integer.parseInt(tks.nextToken());
			int YH = Integer.parseInt(tks.nextToken());
			int M = Integer.parseInt(tks.nextToken());
			
			grafo = new Nodo[P + 1];
			pesos = new int[P + 1][ P + 1];
			
			for (int i = 1; i <= P; i++) {
				grafo[i] = new Nodo(i);
			}
			
			for (int i = 0; i < R; i++) {
				linha = readLn();
				tks = new StringTokenizer(linha);
				
				Nodo nodo1 = grafo[Integer.parseInt(tks.nextToken())];
				Nodo nodo2 = grafo[Integer.parseInt(tks.nextToken())];
				int peso = Integer.parseInt(tks.nextToken());
				
				nodo1.adj.addElement(nodo2);
				nodo2.adj.addElement(nodo1);
				pesos[nodo1.valor][nodo2.valor] = peso;
				pesos[nodo2.valor][nodo1.valor] = peso;
			}
			
			dijkstra1(OF);
			marca(grafo[BH]);
			
			Vector novoGrafo = new Vector();
			for (int i = 1; i < grafo.length; i++) {
				if (grafo[i].livre) novoGrafo.addElement(grafo[i]);
				else {
					while (!grafo[i].adj.isEmpty()) {
						Nodo aux = (Nodo) grafo[i].adj.elementAt(0);

						aux.adj.removeElement(grafo[i]);
						grafo[i].adj.removeElement(aux);
					}
				}
			}
			
			dijkstra2(YH, novoGrafo);

			if (!grafo[M].livre || grafo[M].d < 0 || grafo[M].d == Integer.MAX_VALUE) {
				System.out.println("MISSION IMPOSSIBLE.");
			} else {
				System.out.println(grafo[M].d);
			}
			
			
			linha = readLn();
		}
	}

	static void marca(Nodo inicio) {
		inicio.livre = false;
		
		for (int i = 0; i < inicio.prev.size(); i++) {
			Nodo aux = (Nodo) inicio.prev.elementAt(i);
			if (aux.livre) marca(aux);
		}
	}
	
	static void dijkstra1(int inicio) {
		Vector remaining = new Vector();
		
		for (int i = 1; i < grafo.length; i++) {
			grafo[i].d = Integer.MAX_VALUE;
			grafo[i].prev = new Vector();
			remaining.addElement(grafo[i]);
		}
		
		grafo[inicio].d = 0;
		
		while (! remaining.isEmpty() ) {
			Nodo u = extractMin(remaining);

			remaining.removeElement(u);
			
			for (int i = 0; i < u.adj.size(); i++) {
				Nodo v = (Nodo) u.adj.elementAt(i);
				
				relax(u, v);
			}
		}
	}
	
	static void dijkstra2(int inicio, Vector nodos) {
		
		for (int i = 1; i < grafo.length; i++) {
			grafo[i].d = Integer.MAX_VALUE;
			grafo[i].prev = new Vector();
		}
		
		grafo[inicio].d = 0;
		
		while (! nodos.isEmpty() ) {
			Nodo u = extractMin(nodos);

			nodos.removeElement(u);
			
			for (int i = 0; i < u.adj.size(); i++) {
				Nodo v = (Nodo) u.adj.elementAt(i);
				
				relax(u, v);
			}
		}
	}
	
	static void relax(Nodo u, Nodo v) {
		if (v.d > u.d + pesos[u.valor][v.valor]) {
			v.d = u.d + pesos[u.valor][v.valor];
			v.prev = new Vector();
			v.prev.addElement(u);
		} else if (v.d == u.d + pesos[u.valor][v.valor]) {
			v.prev.addElement(u);
		}
	}
	
	static Nodo extractMin(Vector list) {
		Nodo min = new Nodo(-1);
		
		for (int i = 0; i < list.size(); i++) {
			Nodo n = (Nodo) list.elementAt(i);

			if (n.d <= min.d) {
				min = n;
			}
		}
		
		return min;
	}

}
class Nodo {

	public int valor;
	public int d;
	public Vector prev;
	public Vector adj;
	public boolean livre;
	public boolean visitado;

	public Nodo(int valor) {
		this.valor = valor;
		this.d = Integer.MAX_VALUE;
		this.prev = new Vector();
		this.adj = new Vector();
		this.livre = true;
		this.visitado = false;
	}
	
	public String toString() {
		return "" + this.valor;
	}

}