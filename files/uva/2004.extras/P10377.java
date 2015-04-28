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
        return (buffer.toString()); 
    }

	public static void main(String[] args) {

		int nTestes = Integer.parseInt(readLn());
		
		String linha;
		StringTokenizer tks;
		
		readLn();
		
		for (int g = 0; g < nTestes; g++) {
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			int m = Integer.parseInt(tks.nextToken());
			int n = Integer.parseInt(tks.nextToken());
			
			char[][] matriz = new char[m + 2][n + 2];
			
			for (int i = 0; i < matriz[0].length; i++) matriz[0][i] = '*';
			for (int i = 0; i < matriz[0].length; i++) matriz[m + 1][i] = '*';
			for (int i = 0; i < matriz.length; i++) matriz[i][0] = '*';
			for (int i = 0; i < matriz.length; i++) matriz[i][n + 1] = '*';
			
			for (int i = 1; i <= m; i++) {
				linha = readLn();
				for (int j = 1; j <= n; j++) {
					matriz[i][j] = linha.charAt(j - 1);
				}
			}
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			int l = Integer.parseInt(tks.nextToken());
			int c = Integer.parseInt(tks.nextToken());
			
			int direcao = 1;
			boolean acabou = false;
			
			linha = readLn();
			
			while (!acabou && linha != null) {
				
				for (int i = 0; !acabou && i < linha.length(); i++) {
					
					switch (linha.charAt(i)) {
						case 'R':
							direcao = (direcao - 1 + 4) % 4;
							break;
						case 'L':
							direcao = (direcao + 1) % 4;
							break;
						case 'F':
							int deltaLinha = - (int) Math.round(Math.sin(Math.PI * direcao / 2));
							int deltaColuna = (int) Math.round(Math.cos(Math.PI * direcao / 2));

							if (matriz[l + deltaLinha][c + deltaColuna] != '*') {
								l += deltaLinha;
								c += deltaColuna;
							}
							break;
						case 'Q':
							acabou = true;
							break;
					}
					
				}
				
				linha = readLn();
			}
			
			System.out.print(l + " " + c + " ");
			switch (direcao) {
				case 0:
					System.out.println('E');
					break;
				case 1:
					System.out.println('N');
					break;
				case 2:
					System.out.println('W');
					break;
				case 3:
					System.out.println('S');
					break;
			}
			
			if (g < nTestes - 1) System.out.println();
			
		}

	}

}
