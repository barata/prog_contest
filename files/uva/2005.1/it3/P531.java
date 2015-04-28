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
		String linha = readLn();
		
		while (linha != null) {
			
			Vector lista1 = new Vector();
			Vector lista2 = new Vector();
			
			while (!"#".equals(linha)) {
				StringTokenizer tks = new StringTokenizer(linha);
				
				while (tks.hasMoreTokens()) {
					lista1.addElement(tks.nextToken());
				}
				
				
				linha = readLn();
			}
			
			linha = readLn();
			
			while (!"#".equals(linha)) {
				StringTokenizer tks = new StringTokenizer(linha);
				
				while (tks.hasMoreTokens()) {
					lista2.addElement(tks.nextToken());
				}
				
				
				linha = readLn();
			}
			
			System.out.println(PRINT_LCS(LCS_LENGTH(lista1, lista2), lista1, lista1.size(), lista2.size()).trim());
			
			
			linha = readLn();
		}
	}

	static int[][] LCS_LENGTH(Vector lista1, Vector lista2) {
		int m = lista1.size();
		int n = lista2.size();
		
		int[][] c = new int[m + 1][n + 1];
		int[][] b = new int[m + 1][n + 1];
		
		for (int i = 1; i <= m; i++) {
			
			for (int j = 1; j <= n; j++) {
				if (lista1.elementAt(i - 1).equals(lista2.elementAt(j - 1))) {
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = 1;
				} else if (c[i][j - 1] > c[i - 1][j]) {
					c[i][j] = c[i][j - 1];
					b[i][j] = 2;
				} else {
					c[i][j] = c[i - 1][j];
					b[i][j] = 3;
				}

			}
		}
		
		return b;
	}
	
	static String PRINT_LCS(int[][] matriz, Vector lista, int i, int j) {
		if (i == 0 || j == 0) return "";
		
		String resultado = "";
		
		if (matriz[i][j] == 1) {
			resultado += PRINT_LCS(matriz, lista, i - 1, j - 1) + " " + lista.elementAt(i - 1);
		} else if (matriz[i][j] == 3) {
			resultado += PRINT_LCS(matriz, lista, i - 1, j);
		} else {
			resultado += PRINT_LCS(matriz, lista, i, j - 1);
		}
		
		return resultado;
	}

}
