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
		int n = Integer.parseInt(readLn());
		StringTokenizer tks = new StringTokenizer(readLn());
		
		int[] padrao = new int[n];
		for (int i = 0; i < n; i++) {
			padrao[i] = Integer.parseInt(tks.nextToken());
		}
		padrao = organiza(padrao);

		String linha = readLn();
		
		while (linha != null) {
			tks = new StringTokenizer(linha);
			
			int[] teste = new int[n];
			for (int i = 0; i < n; i++) {
				teste[i] = Integer.parseInt(tks.nextToken());
			}
			teste = organiza(teste);
			
			System.out.println(LCS_LENGTH(padrao, teste));
			
			
			linha = readLn();
		}
	}
	
	static int[] organiza(int[] array) {
		int[] aux = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			aux[array[i] - 1] = i + 1;
		}
		
		return aux;
	}

	static int LCS_LENGTH(int[] array1, int[] array2) {
		int m = array1.length;
		int n = array2.length;
		
		int[][] c = new int[m + 1][n + 1];
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
			
				if (array1[i - 1] == array2[j - 1]) {
					c[i][j] = c[i - 1][j - 1] + 1;
				} else {
					c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
				}
				
			}
		}
		
		return c[m][n];
	}

}
