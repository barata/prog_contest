
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
		
		System.out.println("SLURPYS OUTPUT");
		
		for (int g = 0; g < nTestes; g++) {
			String linha = readLn();
			
			int i;
			
			for (i = 0; i < linha.length() - 1; i++) {
				char ch1 = linha.charAt(i);
				char ch2 = linha.charAt(i + 1);
				
				if ((ch1 == 'C' || ch1 == 'H') && (ch2 == 'D' || ch2 == 'E')) break;
			}

			String parte1 = linha.substring(0, i + 1);
			String parte2 = linha.substring(i + 1);

			if (isSlimp(parte1) && isSlump(parte2)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
		System.out.println("END OF OUTPUT");
	}
	
	static boolean isSlump(String texto) {
		if (texto.length() < 3) return false;
		if (texto.charAt(0) != 'D' && texto.charAt(0) != 'E') return false;
		if (texto.charAt(1) != 'F') return false;
		
		int i;
		
		for (i = 2; i < texto.length(); i++) {
			char ch = texto.charAt(i);
			if (ch != 'F') break;
		}
		
		return (i == texto.length() - 1 && texto.charAt(i) == 'G') || isSlump(texto.substring(i));
	}
	
	static boolean isSlimp(String texto) {
		if (texto.length() < 2) return false;
		if (texto.charAt(0) != 'A') return false;
		if (texto.length() == 2) return texto.charAt(1) == 'H';
		
		return texto.charAt(texto.length() - 1) == 'C' && ((texto.charAt(1) == 'B' && isSlimp(texto.substring(2, texto.length() - 1))) || (isSlump(texto.substring(1, texto.length() - 1))));
	}

}
