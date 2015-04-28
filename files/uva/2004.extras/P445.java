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
		
		boolean deveImprimir = false;
		
		while (linha != null) {
			
			// <-- inicio de um caso
			StringBuffer sb = new StringBuffer();
			
			if (deveImprimir) sb.append("\n");
			
			while (linha != null && !linha.equals("")) {
				
				int tam = 0;
				
				for (int i = 0; i < linha.length(); i++) {
					char ch = linha.charAt(i);
					
					switch (ch) {
						case '!':
							sb.append("\n");
							break;
						case '0': case '1': case '2': case '3': case '4': case '5':
							case '6': case '7': case '8': case '9':
							tam += Character.getNumericValue(ch);
							break;
						default:
							if (ch == 'b') ch = ' ';
							sb.append(str(ch, tam));
							tam = 0;
					}
				}
				
				sb.append("\n");
				
				linha = readLn();
			}
			
			deveImprimir = true;
			
			// <-- fim de um caso
			System.out.print(sb);
			
			
			linha = readLn();
		}
	}
	
	static String str(char ch, int n) {
		String resultado = "";
		for (int i = 0; i < n; i++) {
			resultado += ch;
		}
		return resultado;
	}

}
