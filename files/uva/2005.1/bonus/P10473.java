
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
		
		while (ehHexa(linha) || Integer.parseInt(linha) >= 0) {
			
			if (ehHexa(linha)) {
				System.out.println(hexToDecimal(linha.substring(2).toUpperCase()));
			} else {
				System.out.println("0x" + Integer.toHexString(Integer.parseInt(linha)).toUpperCase());
			}
			
			
			
			linha = readLn();
		}
	}
	
	private static int hexToDecimal(String linha) {
		int tabela[] = new int[256];
		tabela['0'] = 0;
		tabela['1'] = 1;
		tabela['2'] = 2;
		tabela['3'] = 3;
		tabela['4'] = 4;
		tabela['5'] = 5;
		tabela['6'] = 6;
		tabela['7'] = 7;
		tabela['8'] = 8;
		tabela['9'] = 9;
		tabela['A'] = 10;
		tabela['B'] = 11;
		tabela['C'] = 12;
		tabela['D'] = 13;
		tabela['E'] = 14;
		tabela['F'] = 15;
		
		int resultado = 0;
		
		for (int i = linha.length() - 1; i >= 0; i--) {
			resultado += tabela[linha.charAt(i)] * Math.pow(16, linha.length() - (i + 1));
		}
		
		return resultado;
	}

	static boolean ehHexa(String linha) {
		return linha.startsWith("0x");
	}

}
