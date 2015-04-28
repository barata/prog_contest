import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;

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
		String linha = readLn();
		int nTestes = Integer.parseInt(linha);
		
		readLn();
		
		for (int g = 0; g < nTestes; g++) {
			
			int numeroDeNodes = Integer.parseInt(readLn());
			int sim = 0;
			int nao = 0;
			
			Node[] nodes = new Node[numeroDeNodes + 1];
			Hashtable[] grupos = new Hashtable[numeroDeNodes + 1];
			
			for (int i = 1; i <= numeroDeNodes; i++) {
				nodes[i] = new Node(i, i);
				grupos[i] = new Hashtable();
				grupos[i].put(nodes[i], nodes[i]);
			}
			
			linha = readLn();
			
			while (linha != null && !linha.equals("")) {
				StringTokenizer tks = new StringTokenizer(linha);
				
				char comando = tks.nextToken().charAt(0);
				Node n1 = nodes[Integer.parseInt(tks.nextToken())];
				Node n2 = nodes[Integer.parseInt(tks.nextToken())];
				
				switch (comando) {
					case 'c':
						if (n1.grupo != n2.grupo) {
							int codMenor = grupos[n1.grupo].size() < grupos[n2.grupo].size() ? n1.grupo : n2.grupo;
							int codMaior = grupos[n1.grupo].size() >= grupos[n2.grupo].size() ? n1.grupo : n2.grupo;
							
							Hashtable origem = grupos[codMenor];
							Hashtable destino = grupos[codMaior];
							
							Enumeration e = origem.keys();
							while (e.hasMoreElements()) {
								Node n = (Node) e.nextElement();
								
								n.grupo = codMaior;
								destino.put(n, n);
							}
							
							origem.clear();
						}
						
						break;
					case 'q':
						
						if (n1.grupo == n2.grupo) sim++;
						else nao++;
						
						break;
				}
				
				
				linha = readLn();
			}
			
			System.out.println(sim + "," + nao);
			if (g < nTestes - 1) System.out.println();
		}
	}

}

class Node {
	public int valor;
	public int grupo;
	
	public Node(int valor, int grupo) {
		this.valor = valor;
		this.grupo = grupo;
	}
	
	public int hashCode() {
		return valor;
	}
	
}