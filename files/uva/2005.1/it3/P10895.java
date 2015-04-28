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
		String texto = readLn();
		
		while (texto != null) {
			StringTokenizer tks = new StringTokenizer(texto);
			
			int m = Integer.parseInt(tks.nextToken());
			int n = Integer.parseInt(tks.nextToken());
			
			Vector[] matriz = new Vector[n];
			
			for(int linha = 0; linha < m; linha++) {
				tks = new StringTokenizer(readLn());
				StringTokenizer tks2 = new StringTokenizer(readLn());
				
				int numeroDeElementos = Integer.parseInt(tks.nextToken());
				
				for (int c = 0; c < numeroDeElementos; c++) {
					int coluna = Integer.parseInt(tks.nextToken());
					int elemento = Integer.parseInt(tks2.nextToken());
					
					if (matriz[coluna - 1] == null) matriz[coluna - 1] = new Vector();
					matriz[coluna - 1].addElement(new Elemento(coluna, linha + 1, elemento));
				}
			}
			
			System.out.println(n + " " + m);
			
			for (int linha = 0; linha < n; linha++) {
				if (matriz[linha] == null) {
					System.out.println("0\n");
					continue;
				}
				
				String resultado1 = String.valueOf(matriz[linha].size());
				String resultado2 = "";
				
				for (int i = 0; i < matriz[linha].size(); i++) {
					Elemento e = (Elemento) matriz[linha].elementAt(i);
					resultado1 += " " + e.coluna;
					resultado2 += " " + e.valor;
				}
				
				System.out.println(resultado1);
				System.out.println(resultado2.trim());
			}
			
			texto = readLn();
		}
	}

}
class Elemento {
	public int linha;
	public int coluna;
	public int valor;
	
	public Elemento(int linha, int coluna, int valor) {
		this.linha = linha;
		this.coluna = coluna;
		this.valor = valor;
	}

}