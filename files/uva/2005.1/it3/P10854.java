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
		int nTestes = Integer.parseInt(readLn());
		
		for(int g = 0; g < nTestes; g++) {
			String linha = readLn();
			
			No raiz = new No();
			No pont = raiz;
			
			while (!linha.equals("ENDPROGRAM")) {
				No aux = null;
				
				if (linha.equals("IF")) {
					aux = new No();
					aux.pai = pont;
					pont.adj.addElement(aux);
					pont = aux;
				} else if (linha.equals("ELSE")) {
					pont = pont.pai;
					aux = new No();
					aux.pai = pont;
					pont.adj.addElement(aux);
					pont = aux;
				} else if (linha.equals("END_IF")) {
					pont = pont.pai;
				}
				
				
				
				linha = readLn();
			}
			
			int resposta = contaFolhas(raiz);
			
			System.out.println(resposta);
		}
	}

	static int contaFolhas(No raiz) {
		if (raiz == null) return 0;
		if (raiz.adj.size() == 0) {
			raiz.valor = 1;
			return 1;
		}
		
		int cont = 1;
		
		for (int i = 0; i < raiz.adj.size() / 2; i++) {
			cont *= contaFolhas((No) raiz.adj.elementAt(2 * i)) + contaFolhas((No) raiz.adj.elementAt(2 * i + 1));
		}
		
		raiz.valor = cont;
		return cont;
	}

}
class No {
	public int valor = 0;
	
	public No pai = null;
	public Vector adj = new Vector();
}