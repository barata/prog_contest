import java.io.IOException;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

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
	
	static Nodo[] nodos;

	public static void main(String[] args) {
		String linha;
		StringTokenizer tks;
		
        int numeroDeNodos = Integer.parseInt(readLn(255));
        
        while (numeroDeNodos != 0) {

	        	nodos = new Nodo[numeroDeNodos + 1];
	        	for (int i = 1; i <= numeroDeNodos; i++) {
	        		nodos[i] = new Nodo(i);
	        	}
	        	
	        	linha = readLn(255);
	        	tks = new StringTokenizer(linha);
	        	int auxNodo = Integer.parseInt(tks.nextToken());
	        	
	        	while (auxNodo != 0) {
	        		Nodo nodo1 = nodos[auxNodo];
	
	        		while (tks.hasMoreTokens()) {
	        			int auxAdj = Integer.parseInt(tks.nextToken());
	        			
	        			Nodo nodo2 = nodos[auxAdj];
	        			
	        			nodo1.adj.addElement(nodo2);
	        			nodo2.adj.addElement(nodo1);
	        		}
	        		
	        		linha = readLn(255);
	            	tks = new StringTokenizer(linha);
	        		auxNodo = Integer.parseInt(tks.nextToken());
	        	}
	        	
	        	
	        	// processa
	        	int cont = 0;
	        	
	        	for (int i = 1; i <= numeroDeNodos; i++) {
	        		desliga(i);
	        		
	        		Nodo nodo = nodos[getProximoIndice(i)];
	        		busca(nodo);
	        		if (! verifica(i) ) cont++;
	        		
	        		liga(i);
	        		reset();
	        	}
	        	
	        	// resultado
	        	System.out.println(cont);
	        	
	        	numeroDeNodos = Integer.parseInt(readLn(255));
        }
    }
	
	static void busca(Nodo inicio) {
		inicio.visitado = true;
		
		for (int i = 0; i < inicio.adj.size(); i++) {
			Nodo nodo = (Nodo) inicio.adj.elementAt(i);
			if (! nodo.visitado ) busca(nodo);
		}
	}
	
	static boolean verifica(int invalido) {
		for (int i = 1; i < nodos.length; i++) {
			if (i == invalido) continue;
			
			if (nodos[i].visitado == false) return false;
		}
		return true;
	}
	
	static int getProximoIndice(int inicio) {
		inicio++;
		if (inicio == nodos.length) return 1;
		return inicio;
	}
	
	static void desliga(int indice) {
		Nodo nodo = nodos[indice];
		Enumeration enum = nodo.adj.elements();
		
		while (enum.hasMoreElements()) {
			Nodo aux = (Nodo) enum.nextElement();
			
			aux.adj.removeElement(nodo);
		}
	}
	
	static void liga(int indice) {
		Nodo nodo = nodos[indice];
		Enumeration enum = nodo.adj.elements();
		
		while (enum.hasMoreElements()) {
			Nodo aux = (Nodo) enum.nextElement();
			
			aux.adj.addElement(nodo);
		}
	}
	
	static void reset() {
		for (int i = 1; i < nodos.length; i++) {
    		nodos[i].visitado = false;
    	}
	}

}
class Nodo {
	public int valor;
	public Vector adj;
	public boolean visitado;
	
	public Nodo(int valor) {
		this.valor = valor;
		this.adj = new Vector();
		this.visitado = false;
	}
	
	public String toString() {
		return "" + this.valor;
	}
}