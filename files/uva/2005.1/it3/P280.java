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

	public static void main(String[] args) {
		int qntNodos = Integer.parseInt(readLn());
		
		while (qntNodos != 0) {
			No[] grafo = new No[qntNodos + 1];
			
			for (int i = 1; i <= qntNodos; i++) {
				grafo[i] = new No(i);
			}
			
			String linha = readLn();
			StringTokenizer tks = new StringTokenizer(linha);
			
			int valor = Integer.parseInt(tks.nextToken());
			
			while (valor != 0) {
				
				// liga grafo
				int aux = Integer.parseInt(tks.nextToken());
				while (aux != 0) {
					grafo[valor].adj.addElement(grafo[aux]);
					
					aux = Integer.parseInt(tks.nextToken());
				}
				
				
				
				linha = readLn();
				tks = new StringTokenizer(linha);
				
				valor = Integer.parseInt(tks.nextToken());
			}
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			int total = Integer.parseInt(tks.nextToken());

			for (int i = 0; i < total; i++) {
				valor = Integer.parseInt(tks.nextToken());

				preenche(grafo[valor]);
				imprime(grafo);
			}
			
			
			
			qntNodos = Integer.parseInt(readLn());
		}
	}

	static void imprime(No[] grafo) {
		StringBuffer sb = new StringBuffer();
		int cont = 0;
		
		for (int i = 1; i < grafo.length; i++) {
			if (!grafo[i].visitado) {
				cont++;
				sb.append(" ");
				sb.append(grafo[i]);
			} else {
				grafo[i].visitado = false;
			}
		}
		
		System.out.println(cont + sb.toString());
	}

	static void preenche(No no) {
		for (int i = 0; i < no.adj.size(); i++) {
			No aux = (No) no.adj.elementAt(i);
			
			if (!aux.visitado) {
				aux.visitado = true;
				preenche(aux);
			}
		}
	}

}

class No {
	public int valor;
	public Vector adj;
	public boolean visitado;
	
	public No(int valor) {
		this.valor = valor;
		adj = new Vector();
		visitado = false;
	}
	
	public String toString() {
		return "" + this.valor;
	}
}