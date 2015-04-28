
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
        return (buffer.toString().trim()); 
    }

	public static void main(String[] args) {
		String linha = readLn();
		int nTestes = Integer.parseInt(linha);
		
		for (int g = 0; g < nTestes; g++) {
			
			readLn();
			
			linha = readLn();
				
			int periodo = 1;
			
			while (!checaPeriodo(linha, periodo)) {
				periodo++;
			}
			
			System.out.println(periodo);
			if (g < nTestes - 1) System.out.println();
		}
	}
	
	static boolean checaPeriodo(String linha, int periodo) {
		if (linha.length() % periodo != 0) return false;
		
		String esperado = linha.substring(0, periodo);
		
		for (int i = 1; i < linha.length() / periodo; i++) {
			String trecho = linha.substring(i * periodo, i * periodo + periodo);
			
			if (!esperado.equals(trecho)) return false;
		}
		
		return true;
	}

}
