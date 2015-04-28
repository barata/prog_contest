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
			readLn();
			
			int amplitude = Integer.parseInt(readLn());
			int frequencia = Integer.parseInt(readLn());
			
			String wave = montaOnda(amplitude);
			
			for (int i = 0; i < frequencia; i++) {
				System.out.print(wave);
				
			    if (i < frequencia - 1) System.out.println();
			}
			
			if (g < nTestes - 1) System.out.println();
		}
	}
	
    private static String montaOnda(int amplitude) {
        StringBuffer sb = new StringBuffer();
        int cont = 1;
		int delta = 1;
		
		while (cont > 0) {
			sb.append(str(cont, cont)).append("\n");
			
			if (cont == amplitude) delta *= -1;
			
			cont += delta;
		}
		
        return sb.toString();
    }

    static String str(int ch, int n) {
		StringBuffer resultado = new StringBuffer();
		for (int i = 0; i < n; i++) {
			resultado.append(ch);
		}
		return resultado.toString();
	}

}
