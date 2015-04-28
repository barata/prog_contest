import java.util.StringTokenizer;

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
		StringTokenizer tks = new StringTokenizer(readLn());
		
		String m = tks.nextToken();
		String n = tks.nextToken();
		
		int cod;
		int resultado = -1;
		
		while (!"0".equals(m) || !"0".equals(n)) {
			
			if (n.length() < 7 && Integer.parseInt(n) == 0) resultado = 1;
			else {
				char ultimoDigito = m.charAt(m.length() - 1);
				
				switch (ultimoDigito) {
					case '0':
						resultado = 0;
						
						break;
						
					case '1':
						resultado = 1;
						
						break;
						
					case '2':
						cod = mod4(n);
						
						if (cod == 0) resultado = 6;
						else if (cod == 1) resultado = 2;
						else if (cod == 2) resultado = 4;
						else if (cod == 3) resultado = 8;
						
						break;
						
					case '3':
						cod = mod4(n);
						
						if (cod == 0) resultado = 1;
						else if (cod == 1) resultado = 3;
						else if (cod == 2) resultado = 9;
						else if (cod == 3) resultado = 7;
						
						break;
						
					case '4':
						cod = mod2(n);
						
						if (cod == 0) resultado = 6;
						else if (cod == 1) resultado = 4;
						
						break;
						
					case '5':
						resultado = 5;
						
						break;
						
					case '6':
						resultado = 6;
						
						break;
						
					case '7':
						cod = mod4(n);
						
						if (cod == 0) resultado = 1;
						else if (cod == 1) resultado = 7;
						else if (cod == 2) resultado = 9;
						else if (cod == 3) resultado = 3;
						
						break;
						
					case '8':
						cod = mod4(n);
						
						if (cod == 0) resultado = 6;
						else if (cod == 1) resultado = 8;
						else if (cod == 2) resultado = 4;
						else if (cod == 3) resultado = 2;
						
						break;
						
					case '9':
						cod = mod2(n);
						
						if (cod == 0) resultado = 1;
						else if (cod == 1) resultado = 9;
						
						break;
				}
			}
			
			System.out.println(resultado);
			
			
			
			tks = new StringTokenizer(readLn());
			
			m = tks.nextToken();
			n = tks.nextToken();
		}
	}
	
	static int mod4(String n) {
		int resultado;
		if (n.length() <= 2) resultado = Integer.parseInt(n);
		else resultado = Integer.parseInt(n.substring(n.length() - 2));
		return (resultado) % 4;
	}
	
	static int mod2(String n) {
		int resultado;
		if (n.length() <= 1) resultado = Integer.parseInt(n);
		else resultado = Integer.parseInt(n.substring(n.length() - 1));
		return (resultado) % 2;
	}

}
