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
		int qntNumeros = Integer.parseInt(readLn());
		
		while (qntNumeros != 0) {
			
			StringBuffer resultado = new StringBuffer();
			
			// le os numeros
			for (int i = 0; i < qntNumeros; i++) {
				String valor = readLn();
				
				if (!valor.equals("0")) resultado.append(valor).append(" ");
			}

			// imprime
			if (resultado.length() > 0) System.out.println(resultado.toString().trim());
			else System.out.println("0");
			
			
			qntNumeros = Integer.parseInt(readLn());
		}
	}
}
