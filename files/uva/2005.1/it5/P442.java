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
	
	static Hashtable tabela;

	public static void main(String[] args) {
		int n = Integer.parseInt(readLn());
		tabela = new Hashtable();
		
		for (int g = 0; g < n; g++) {
			StringTokenizer tks = new StringTokenizer(readLn());
			
			String nome = tks.nextToken();
			int i = Integer.parseInt(tks.nextToken());
			int j = Integer.parseInt(tks.nextToken());
			
			tabela.put(nome, new Node(nome, i, j));
		}
		
		String linha = readLn();
		
		while (linha != null) {
			
			try {
				System.out.println(calculaCusto(monta(linha)));
			} catch (RuntimeException e) {
				System.out.println("error");
			}
			
			
			
			
			
			linha = readLn();
		}
	}

	static int calculaCusto(Node raiz) {
		if (raiz.valor.equals("")) {
			int soma = calculaCusto(raiz.esq) + calculaCusto(raiz.dir);
			
			if (raiz.esq.j != raiz.dir.i) throw new RuntimeException();
			
			raiz.i = raiz.esq.i;
			raiz.j = raiz.dir.j;
			
			return soma + raiz.esq.i * raiz.esq.j * raiz.dir.j;
		} else {
			return 0;
		}
	}
	
	static Node monta(String linha) {
		if (linha.length() == 1) return (Node) tabela.get(linha);
		
		int p1, p2, p3, p4;
		
		if (Character.isUpperCase(linha.charAt(1))) {
			p1 = 1;
			p2 = p1;
			p3 = p2 + 1;
			p4 = linha.length() - 2;
		} else if (Character.isUpperCase(linha.charAt(linha.length() - 1))) {
			p1 = 1;
			p2 = linha.length() - 3;
			p3 = p2 + 1;
			p4 = p3;
		} else {
			p1 = 1;
			p2 = encontraPar(linha, p1);
			p3 = p2 + 1;
			p4 = linha.length() - 2;
		}
		
		Node no = new Node("", 0, 0);
		
		no.esq = monta(linha.substring(p1, p2 + 1));
		no.dir = monta(linha.substring(p3, p4 + 1));
		
		return no;
	}
	
	static int encontraPar(String linha, int pos) {
		int cont = 0;
		
		for (int i = pos; i < linha.length(); i++) {
			char ch = linha.charAt(i);
			
			if (ch == '(') cont++;
			else if (ch == ')') cont--;
			
			if (cont == 0) return i;
		}
		
		return -1;
	}

}
class Node {
	public String valor;
	public int i;
	public int j;
	
	public Node esq;
	public Node dir;
	
	public Node(String valor, int i, int j) {
		this.valor = valor;
		this.i = i;
		this.j = j;
	}
	
	public String toString() {
		return valor;
	}
}