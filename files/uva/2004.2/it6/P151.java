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
		int numero = Integer.parseInt(linha);
		
		while (numero != 0) {
			
			boolean[] cidades = new boolean[numero + 1];
			cidades[1] = true;
			int m = 1;
			int seta = 1;
			
			int ultimoMarcado = 1;
			
			while (true) {
			
				for (int i = 1; i < numero; i++) {
					int cont = 0;
					
					while (cont < m) {
						seta++;
						if (seta > numero) seta = 1;
						
						if (cidades[seta] == false) {
							cont++;
						}
					}
					
					cidades[seta] = true;
					ultimoMarcado = seta;
				}
	
	
				if (ultimoMarcado == 13) {
					break;
				} else {
					// reset
					for (int i = 0; i < cidades.length; i++) cidades[i] = false;
					cidades[1] = true;
					m++;
					seta = 1;
					ultimoMarcado = 1;
				}
			}
			
			System.out.println(m);
			
			
			linha = readLn();
			numero = Integer.parseInt(linha);
		}
	}
}
