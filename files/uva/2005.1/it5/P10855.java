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
		StringTokenizer tks = new StringTokenizer(linha);
		
		int N = Integer.parseInt(tks.nextToken());
		int n = Integer.parseInt(tks.nextToken());
		
		while (N != 0 || n != 0) {
			
			char[][] grande = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				linha = readLn();
				linha.getChars(0, N, grande[i], 0);
			}
			
			char[][] pequeno1 = new char[n][n];
			
			for (int i = 0; i < n; i++) {
				linha = readLn();
				linha.getChars(0, n, pequeno1[i], 0);
			}
			
			char[][] pequeno2 = rotate(pequeno1);
			char[][] pequeno3 = rotate(pequeno2);
			char[][] pequeno4 = rotate(pequeno3);
			
			int cont1 = conta(grande, pequeno1);
			int cont2 = conta(grande, pequeno2);
			int cont3 = conta(grande, pequeno3);
			int cont4 = conta(grande, pequeno4);
			
			System.out.println(cont1 + " " + cont2 + " " + cont3 + " " + cont4);
			
			
			
			
			
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			N = Integer.parseInt(tks.nextToken());
			n = Integer.parseInt(tks.nextToken());
		}
	}

	static int conta(char[][] grande, char[][] pequeno) {
		int cont = 0;
		
		int N = grande.length;
		int n = pequeno.length;
		
		for (int a = 0; a <= N - n; a++) {
			for (int b = 0; b <= N - n; b++) {
				boolean igual = true;
				
				for (int c = 0; igual && c < n; c++) {
					for (int d = 0; igual && d < n; d++) {
						if (grande[c + a][d + b] != pequeno[c][d]) {
							igual = false;
						}
					}
				}
				
				if (igual) cont++;
			}
		}
		
		return cont;
	}
	
	static char[][] rotate(char[][] array) {
		char[][] retorno = new char[array[0].length][array.length];
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				retorno[j][array.length - i - 1] = array[i][j];
			}
		}
		
		return retorno;
	}

}
