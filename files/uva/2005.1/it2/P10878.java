
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
		readLn();
		
		String linha = readLn();
		
		while (!linha.startsWith("_")) {
			
			linha = linha.substring(1, 6) + linha.substring(7, 10);
			
			System.out.print(traduz(linha));
			
			
			
			linha = readLn();
		}
	}
	
	static char traduz(String palavra) {
		int resultado = 0;

		for (int i = palavra.length() - 1; i >= 0; i--) {
			int aux = (palavra.charAt(i) == 'o' ? 1 : 0);
			resultado += aux * Math.pow(2, palavra.length() - (i + 1));
		}

		return (char) resultado;
	}

}
