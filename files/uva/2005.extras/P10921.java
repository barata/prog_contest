
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
	
	static char[] table = new char[256];
	
	static {
		table['-'] = '-';
		table['0'] = '0';
		table['1'] = '1';
		
		table['A'] = '2';
		table['B'] = '2';
		table['C'] = '2';
		
		table['D'] = '3';
		table['E'] = '3';
		table['F'] = '3';
		
		table['G'] = '4';
		table['H'] = '4';
		table['I'] = '4';
		
		table['J'] = '5';
		table['K'] = '5';
		table['L'] = '5';
		
		table['M'] = '6';
		table['N'] = '6';
		table['O'] = '6';
		
		table['P'] = '7';
		table['Q'] = '7';
		table['R'] = '7';
		table['S'] = '7';
		
		table['T'] = '8';
		table['U'] = '8';
		table['V'] = '8';
		
		table['W'] = '9';
		table['X'] = '9';
		table['Y'] = '9';
		table['Z'] = '9';
	}
	
	public static void main(String[] args) {
		String linha = readLn();
		
		while (linha != null) {
			
			System.out.println(convert(linha));
			
			
			linha = readLn();
		}
	}
	
	static String convert(String text) {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			sb.append(table[ch]);
		}
		
		return sb.toString();
	}

}
