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
        return (buffer.toString().trim()); 
    }
	
	public static void main(String[] args) {
		String palavra1 = readLn();
		
		int nTestes = 0;
		
		while (palavra1 != null) {
			String palavra2 = readLn();
			
			if (palavra1.equals("") || palavra2.equals("")) {
				System.out.println(formata(++nTestes, 2) + ". Blank!");
			} else {
				int lcs = LCS_LENGTH(palavra1, palavra2);
				
				System.out.println(formata(++nTestes, 2) + ". Length of longest match: " + lcs);
			}
			
			
			palavra1 = readLn();
		}
	}
	
	static String formata(int numero, int espaco) {
		String n = "" + numero;
		
		return str(' ', espaco - n.length()) + n;
	}
	
	static String str(char ch, int n) {
		String resultado = "";
		n = Math.max(0, n);
		for (int i = 0; i < n; i++) {
			resultado += ch;
		}
		return resultado;
	}
	
	static int LCS_LENGTH(String palavra1, String palavra2) {
		String[] tks1 = preparaPalavras(palavra1);
		String[] tks2 = preparaPalavras(palavra2);
		
		int m = tks1.length;
		int n = tks2.length;
		
		int[][] c = new int[m + 1][n + 1];
		
		for (int i = 1; i <= m; i++) {
			
			for (int j = 1; j <= n; j++) {

				if (tks1[i - 1].equals(tks2[j - 1])) {
					c[i][j] = c[i - 1][j - 1] + 1;
				} else if (c[i - 1][j] >= c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
				} else {
					c[i][j] = c[i][j - 1];
				}

			}
		}
		
		return c[m][n];
	}

	static String[] preparaPalavras(String palavra) {
		char[] chars = new char[palavra.length()];
		palavra.getChars(0, chars.length, chars, 0);
		
		for (int i = 0; i < chars.length; i++) {
			if (!(Character.isLetter(chars[i]) || Character.isDigit(chars[i]))) {
				chars[i] = ' ';
			}
		}
		
		StringTokenizer tks = new StringTokenizer(new String(chars));
		String[] resultado = new String[tks.countTokens()];
		int cont = 0;
		while (tks.hasMoreTokens()) {
			resultado[cont++] = tks.nextToken();
		}
		
		return resultado;
	}
}
