
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
	
	static char[] tabela = new char[256];
	
	static {
		tabela['A'] = 'A';
		tabela['E'] = '3';
		tabela['H'] = 'H';
		tabela['I'] = 'I';
		tabela['J'] = 'L';
		tabela['L'] = 'J';
		tabela['M'] = 'M';
		tabela['O'] = 'O';
		tabela['S'] = '2';
		tabela['T'] = 'T';
		tabela['U'] = 'U';
		tabela['V'] = 'V';
		tabela['W'] = 'W';
		tabela['X'] = 'X';
		tabela['Y'] = 'Y';
		tabela['Z'] = '5';
		tabela['1'] = '1';
		tabela['2'] = 'S';
		tabela['3'] = 'E';
		tabela['5'] = 'Z';
		tabela['8'] = '8';
	}
	
	public static void main(String[] args) {
		String linha = readLn();
		
		while (linha != null) {
			
			boolean p1 = ehPalindromo(linha);
			boolean p2 = ehMirrored(linha);
			
			if (p1 && p2) System.out.println(linha + " -- is a mirrored palindrome.");
			if (p1 && !p2) System.out.println(linha + " -- is a regular palindrome.");
			if (!p1 && p2) System.out.println(linha + " -- is a mirrored string.");
			if (!p1 && !p2) System.out.println(linha + " -- is not a palindrome.");
			
			System.out.println();
			
			
			
			linha = readLn();
		}
	}
	
	static boolean ehPalindromo(String linha) {
		for (int i = 0; i < linha.length() / 2; i++) {
			if (linha.charAt(i) != linha.charAt(linha.length() - i - 1)) return false;
		}
		return true;
	}
	
	static boolean ehMirrored(String linha) {
		for (int i = 0; i <= linha.length() / 2; i++) {
			char ch1 = linha.charAt(i);
			if (tabela[ch1] == 0) return false;
			
			char ch2 = linha.charAt(linha.length() - i - 1);
			if (tabela[ch1] != ch2) return false;
		}
		return true;
	}

}
