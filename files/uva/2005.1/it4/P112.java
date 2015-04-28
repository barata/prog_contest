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
	
	static boolean temNegativo = false;

	public static void main(String[] args) throws Exception {
		String linha = readLn();
		
		while (linha != null) {
			
			StringTokenizer tks = new StringTokenizer(linha);
			int numero = Integer.parseInt(tks.nextToken());
			linha = tks.nextToken("\n");

			StringBuffer linhaFinal = new StringBuffer();
			int cont = 0;
			boolean comecouLer = false;
			
			while (!comecouLer || cont != 0) {
				for (int i = 0; i < linha.length(); i++) {
					char ch = linha.charAt(i);
					
					if (ch != ' ') {
						linhaFinal.append((char) ch);
						
						if (ch == '-') temNegativo = true;
						
						if (ch == '(') {
							cont++;
							comecouLer = true;
						} else if (ch == ')') {
							cont--;
						}
					}
				}
					
				if (comecouLer && cont != 0) linha = readLn();
			}

			No raiz = extraiNo(linhaFinal.toString(), null, 0);
			
			if (busca(raiz, numero, null)) System.out.println("yes");
			else System.out.println("no");
			
			
			temNegativo = false;
			
			linha = readLn();
		}
	}
	
	private static boolean busca(No raiz, int numero, No pai) {
		if (raiz == null) {
			return numero == 0 && pai != null && pai.esq == null && pai.dir == null;
		}
		if (!temNegativo && numero < raiz.valor) return false;
		
		return busca(raiz.esq, numero - raiz.valor, raiz) || busca(raiz.dir, numero - raiz.valor, raiz);
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
	
	static No extraiNo(String linha, No pai, int i) {
		if (linha.charAt(i + 1) == ')') return null;
		
		int pos1 = linha.indexOf("(", i + 1);
		int pos2 = encontraPar(linha, pos1);
		int pos3 = pos2 + 1;
		
		int valor = Integer.parseInt(linha.substring(i + 1, pos1));
		No no = new No(valor);
		no.pai = pai;
		
		no.esq = extraiNo(linha, no, pos1);
		no.dir = extraiNo(linha, no, pos3);
		
		return no;
	}

}
class No {
	public int valor;
	public No pai;
	public No esq;
	public No dir;
	
	public No(int valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return "" + valor;
	}
}