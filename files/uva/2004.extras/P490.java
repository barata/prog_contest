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
		
		char[][] matriz = new char[101][101];
		int cont = 0;
		int maxLength = 0;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = ' ';
			}
		}
		
		while (linha != null) {
			
			maxLength = Math.max(maxLength, linha.length());
			char[] temp = new char[101];
			linha.getChars(0, linha.length(), matriz[cont++], 0);
			
			
			
			linha = readLn();
		}
		
		for (int j = 0; j < maxLength; j++) {
			for (int i = cont - 1; i >= 0; i--) {
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
	}
}
