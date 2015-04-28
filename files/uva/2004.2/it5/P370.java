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

	static int[][] bingo = new int[5][5];
	static boolean[][] mascara = new boolean[5][5];
	static int nLinha, nColuna;

	public static void main(String[] args) {
		String linha;
		StringTokenizer tks;
		
		linha = readLn();
		
		while (linha != null && !linha.equals("")) {
			int valor;
			
			reset();
			
			for (int i = 0; i < 4; i++) {
				tks = new StringTokenizer(linha);
				for (int j = 0; j < 5; j++) {
					valor = Integer.parseInt(tks.nextToken());
					
					bingo[i][j] = valor;
				}
				
				linha = readLn();
			}
			tks = new StringTokenizer(linha);
			for (int j = 0; j < 5; j++) {
				valor = Integer.parseInt(tks.nextToken());
				
				bingo[4][j] = valor;
			}
			
			valor = 0;

			boolean ganhou = false;

			do {
				if (!ganhou) {
					marca(valor);

					// verifica linhas
					for (int k = 0; k < 5; k++)
					if (ganhouLinha(k)) {
						System.out.println("BINGO #1");
							
						String aux = "" + bingo[k][0];
						if (bingo[k][0] == 0) aux = "FREE";
						System.out.println((k + 1) + ",1," + aux);
						
						aux = "" + bingo[k][1];
						if (bingo[k][1] == 0) aux = "FREE";
						System.out.println((k + 1) + ",2," + aux);
						
						aux = "" + bingo[k][2];
						if (bingo[k][2] == 0) aux = "FREE";
						System.out.println((k + 1) + ",3," + aux);
						
						aux = "" + bingo[k][3];
						if (bingo[k][3] == 0) aux = "FREE";
						System.out.println((k + 1) + ",4," + aux);
						
						aux = "" + bingo[k][4];
						if (bingo[k][4] == 0) aux = "FREE";
						System.out.println((k + 1) + ",5," + aux);
						
						ganhou = true;
					}
					
					// verifica colunas
					for (int k = 0; k < 5; k++)
					if (ganhouColuna(k)) {
						System.out.println("BINGO #2");

						String aux = "" + bingo[0][k];
						if (bingo[0][k] == 0) aux = "FREE";
						System.out.println("1," + (k + 1) + "," + aux);
						
						aux = "" + bingo[1][k];
						if (bingo[1][k] == 0) aux = "FREE";
						System.out.println("2," + (k + 1) + "," + aux);
						
						aux = "" + bingo[2][k];
						if (bingo[2][k] == 0) aux = "FREE";
						System.out.println("3," + (k + 1) + "," + aux);
						
						aux = "" + bingo[3][k];
						if (bingo[3][k] == 0) aux = "FREE";
						System.out.println("4," + (k + 1) + "," + aux);
						
						aux = "" + bingo[4][k];
						if (bingo[4][k] == 0) aux = "FREE";
						System.out.println("5," + (k + 1) + "," + aux);
						
						ganhou = true;
					}
					
					// verifica corners
					if (ganhou4Cantos()) {
						System.out.println("BINGO #3");
						String aux = "" + bingo[0][0];
						if (bingo[0][0] == 0) aux = "FREE";
						System.out.println("1,1," + aux);
						
						aux = "" + bingo[0][4];
						if (bingo[0][4] == 0) aux = "FREE";
						System.out.println("1,5," + aux);
						
						aux = "" + bingo[4][0];
						if (bingo[4][0] == 0) aux = "FREE";
						System.out.println("5,1," + aux);
						
						aux = "" + bingo[4][4];
						if (bingo[4][4] == 0) aux = "FREE";
						System.out.println("5,5," + aux);
						
						ganhou = true;
					}
					
					// verifica diagonais
					if (ganhouDiagonalPrincipal()) {
						System.out.println("BINGO #4");

						String aux = "" + bingo[0][0];
						if (bingo[0][0] == 0) aux = "FREE";
						System.out.println("1,1," + aux);
						
						aux = "" + bingo[1][1];
						if (bingo[1][1] == 0) aux = "FREE";
						System.out.println("2,2," + aux);
						
						aux = "" + bingo[2][2];
						if (bingo[2][2] == 0) aux = "FREE";
						System.out.println("3,3," + aux);
						
						aux = "" + bingo[3][3];
						if (bingo[3][3] == 0) aux = "FREE";
						System.out.println("4,4," + aux);
						
						aux = "" + bingo[4][4];
						if (bingo[4][4] == 0) aux = "FREE";
						System.out.println("5,5," + aux);
						
						ganhou = true;
					}
					if (ganhouDiagonalSecundaria()) {
						System.out.println("BINGO #4");

						String aux = "" + bingo[0][4];
						if (bingo[0][4] == 0) aux = "FREE";
						System.out.println("1,5," + aux);
						
						aux = "" + bingo[1][3];
						if (bingo[1][3] == 0) aux = "FREE";
						System.out.println("2,4," + aux);
						
						aux = "" + bingo[2][2];
						if (bingo[2][2] == 0) aux = "FREE";
						System.out.println("3,3," + aux);
						
						aux = "" + bingo[3][1];
						if (bingo[3][1] == 0) aux = "FREE";
						System.out.println("4,2," + aux);
						
						aux = "" + bingo[4][0];
						if (bingo[4][0] == 0) aux = "FREE";
						System.out.println("5,1," + aux);
						
						ganhou = true;
					}
					
				}

				linha = readLn();
				valor = Integer.parseInt(new StringTokenizer(linha).nextToken());
				
			} while (valor != 0);
			
			if (!ganhou) {
				System.out.println("No BINGO on this card.");
			}
			
			System.out.println();
			
			linha = readLn();

		}
	}

	static boolean ganhouLinha(int linha) {
		return mascara[linha][0] && mascara[linha][1] &&
			mascara[linha][2] && mascara[linha][3] && mascara[linha][4];
	}
	
	static boolean ganhouColuna(int coluna) {
		return mascara[0][coluna] && mascara[1][coluna] &&
			mascara[2][coluna] && mascara[3][coluna] && mascara[4][coluna];
	}
	
	static boolean ganhouDiagonalPrincipal() {
		return mascara[0][0] && mascara[1][1] &&
		mascara[2][2] && mascara[3][3] && mascara[4][4];
	}
	
	static boolean ganhouDiagonalSecundaria() {
		return mascara[0][4] && mascara[1][3] &&
		mascara[2][2] && mascara[3][1] && mascara[4][0];
	}
	
	static boolean ganhou4Cantos() {
		return (mascara[0][0] == true && mascara[0][4] == true &&
				mascara[4][0] == true && mascara[4][4] == true);
	}
	
	static void marca(int valor) {
		for (int i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo.length; j++) {
				if (bingo[i][j] == valor) {
					mascara[i][j] = true;
					nLinha = i;
					nColuna = j;
				}
			}
		}
	}
	
	static void reset() {
		for (int i = 0; i < mascara.length; i++) {
			for (int j = 0; j < mascara.length; j++) {
				mascara[i][j] = false;
			}
		}
	}

}
