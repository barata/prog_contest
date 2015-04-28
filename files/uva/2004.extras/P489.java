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
		int nTeste = Integer.parseInt(readLn());
		
		while (nTeste != -1) {
			String palavra = readLn();
			String letras = readLn();
			
			boolean[] palavraArray = new boolean[palavra.length()];
			boolean[] controle = new boolean[256];
			int erros = 0;
			
			for (int i = 0; i < letras.length(); i++) {
				char ch = letras.charAt(i);
				
				if (!controle[ch] && erros < 7) {
					
					boolean marcou = false;
					for (int j = 0; j < palavra.length(); j++) {
						char ch2 = palavra.charAt(j);
						
						if (ch2 == ch) {
							palavraArray[j] = true;
							marcou = true;
						}
					}
					
					if (!marcou) erros++;
					
					controle[ch] = true;
				}
				
			}
			
			// imprime resultado
			System.out.println("Round " + nTeste);
			if (erros >= 7) System.out.println("You lose.");
			else if (isCompleted(palavraArray)) System.out.println("You win.");
			else System.out.println("You chickened out.");
			
			
			
			nTeste = Integer.parseInt(readLn());
		}
	}
	
	static boolean isCompleted(boolean[] array) {
		for (int i = 0; i < array.length; i++) {
			if (!array[i]) return false;
		}
		return true;
	}
}
