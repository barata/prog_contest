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
		
		for (int g = 0; g < nTestes; g++) {
			
			char[][] mat = new char[3][3];
			
			for (int i = 0; i < 3; i++) {
				String linha = readLn();
				for (int j = 0; j < 3; j++) {
					mat[i][j] = linha.charAt(j);
				}
			}
			
			int contX = conta(mat, 'X');
			int contO = conta(mat, 'O');

			if (contX == contO + 1) {
				if (ganhou(mat, 'O')) System.out.println("no");
				else System.out.println("yes");
			} else if (contX == contO) {
				if (ganhou(mat, 'X')) System.out.println("no");
				else System.out.println("yes");
			} else {
				System.out.println("no");
			}
			
			
			if (g < nTestes - 1) readLn();
			
		}
	}
	
	static boolean ganhou(char[][] mat, char ch) {
		if (mat[0][0] == ch && mat[1][1] == ch && mat[2][2] == ch) return true;
		if (mat[0][2] == ch && mat[1][1] == ch && mat[2][0] == ch) return true;
		
		for (int i = 0; i < 3; i++) {
			if (mat[i][0] == ch && mat[i][1] == ch && mat[i][2] == ch) return true;
			if (mat[0][i] == ch && mat[1][i] == ch && mat[2][i] == ch) return true;
		}
		
		return false;
	}
	
	static int conta(char[][] mat, char ch) {
		int cont = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (mat[i][j] == ch) cont++;
			}
		}
		
		return cont;
	}

}
