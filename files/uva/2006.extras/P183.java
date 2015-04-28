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
            if (car == newLine.charAt(0)) System.in.skip(newLine.length() - 1);
        } catch (java.io.IOException e) { return (null); }
        if ((car < 0) && (buffer.length() == 0)) return (null);
        return (buffer.toString()).trim();
    }

	public static void main(String[] args) {
		String linha = readLn();
		
		while (!"#".equals(linha)) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			String tipo = tks.nextToken();
			int nLinhas = Integer.parseInt(tks.nextToken());
			int nColunas = Integer.parseInt(tks.nextToken());
			
			StringBuffer sb = new StringBuffer();
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			while (!"#".equals(linha) && tks.countTokens() != 3) {
				sb.append(linha);
				
				linha = readLn();
				tks = new StringTokenizer(linha);
			}
			
			char[][] matriz = new char[nLinhas][nColunas];
            String resultado = "";
			
			if ("B".equals(tipo)) {
				preencheMatriz(matriz, sb.toString());
				
				resultado = converteB(matriz, 0, 0, matriz.length - 1, matriz[0].length - 1);
			} else if ("D".equals(tipo)) {
				converteD(matriz, sb.toString(), 0, 0, 0, matriz.length - 1, matriz[0].length - 1);
                
                resultado = preencheResultado(matriz);
			}
            
            System.out.println(("B".equals(tipo) ? "D" : "B") + formata(Integer.toString(nLinhas), 4) + formata(Integer.toString(nColunas), 4));
			System.out.println(split(resultado, 50));
		}
	}
	
    static void preencheMatriz(char[][] matriz, String s) {
		int nColunas = matriz[0].length;
		
		for (int i = 0; i < s.length(); i++) {
			matriz[i / nColunas][i % nColunas] = s.charAt(i);
		}
	}
    
    private static String preencheResultado(char[][] matriz) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sb.append(matriz[i][j]);
            }
        }
        return sb.toString();
    }

	static String converteB(char[][] matriz, int l1, int c1, int l2, int c2) {
		int status = status(matriz, l1, c1, l2, c2);
		
		if (status == 0) return "0";
		else if (status == 1) return "1";
		
		if (l1 == l2) {
			return "D" + converteB(matriz, l1, c1, l2, (c1 + c2) / 2) + converteB(matriz, l1, (c1 + c2) / 2 + 1, l2, c2);
		}
		if (c1 == c2) {
			return "D" + converteB(matriz, l1, c1, (l1 + l2) / 2, c2) + converteB(matriz, (l1 + l2) / 2 + 1, c1, l2, c2);
		}
		
		return "D" + converteB(matriz, l1, c1, (l1 + l2) / 2, (c1 + c2) / 2) + converteB(matriz, l1, (c1 + c2) / 2 + 1, (l1 + l2) / 2, c2)
			+ converteB(matriz, (l1 + l2) / 2 + 1, c1, l2, (c1 + c2) / 2) + converteB(matriz, (l1 + l2) / 2 + 1, (c1 + c2) / 2 + 1, l2, c2);
	}
	
	static int status(char[][] matriz, int l1, int c1, int l2, int c2) {
		char status = matriz[l1][c1];
		
		for (int i = l1; i <= l2; i++) {
			for (int j = c1; j <= c2; j++) {
				if (matriz[i][j] != status) return 2;
			}
		}
		
		return Character.getNumericValue(status);
	}

	static int converteD(char[][] matriz, String s, int indiceInicial, int l1, int c1, int l2, int c2) {
		char ch = s.charAt(indiceInicial);

        if (ch =='D') {
            int cont = 1;
            
            if (l1 == l2) {
                cont += converteD(matriz, s, indiceInicial + cont, l1, c1, l2, (c1 + c2) / 2);
                cont += converteD(matriz, s, indiceInicial + cont, l1, (c1 + c2) / 2 + 1, l2, c2);
                return cont;
            } else if (c1 == c2) {
                cont += converteD(matriz, s, indiceInicial + cont, l1, c1, (l1 + l2) / 2, c2);
                cont += converteD(matriz, s, indiceInicial + cont, (l1 + l2) / 2 + 1, c1, l2, c2);
                return cont;
            } else {
                cont += converteD(matriz, s, indiceInicial + cont, l1, c1, (l1 + l2) / 2, (c1 + c2) / 2);
                cont += converteD(matriz, s, indiceInicial + cont, l1, (c1 + c2) / 2 + 1, (l1 + l2) / 2, c2);
                cont += converteD(matriz, s, indiceInicial + cont, (l1 + l2) / 2 + 1, c1, l2, (c1 + c2) / 2);
                cont += converteD(matriz, s, indiceInicial + cont, (l1 + l2) / 2 + 1, (c1 + c2) / 2 + 1, l2, c2);
                return cont;
            }
        } else {
            fill(matriz, l1, c1, l2, c2, ch);
            return 1;
        }
	}
	
	static void fill(char[][] matriz, int l1, int c1, int l2, int c2, char ch) {
		for (int i = l1; i <= l2; i++) {
			for (int j = c1; j <= c2; j++) {
				matriz[i][j] = ch;
			}
		}
	}
    
    static String formata(String text, int size) {
        return str(" ", size - text.length()) + text;
    }
    
    static String str(String ch, int n) {
        StringBuffer resultado = new StringBuffer();
        for (int i = 0; i < n; i++) {
            resultado.append(ch);
        }
        return resultado.toString();
    }
    
    static String split(String s, int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (i < s.length() - 1 && (i + 1) % length == 0) sb.append("\n");
        }
        return sb.toString();
    }
    
}