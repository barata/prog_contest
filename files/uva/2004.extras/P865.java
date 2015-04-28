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
try{
		int nTestes = Integer.parseInt(readLn());
		
		readLn();
		
		for (int g = 0; g < nTestes; g++) {
			String plainText = readLn();
			String substitution = readLn();
			
			System.out.println(substitution);;
			System.out.println(plainText);
			
			String linha = readLn();
			
			while (linha != null && !linha.equals("")) {
				
				StringBuffer resultado = new StringBuffer();
				
				for (int i = 0; i < linha.length(); i++) {
					char ch = linha.charAt(i);
					
					int indice = plainText.indexOf(ch);
					
					if (indice >= 0) {
						resultado.append(substitution.charAt(indice));
					} else {
						resultado.append(ch);
					}
					
				}
				
				System.out.println(resultado);
				
				linha = readLn();
			}
			
			if (g < nTestes - 1) System.out.println();
		}
}catch(Exception e){while(true);}
	}
}
