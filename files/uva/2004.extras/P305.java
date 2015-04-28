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
	
	static int[] respostas = { -1, 2, 7, 5, 30, 169, 441, 1872, 7632, 1740, 93313, 459901, 1358657, 2504881 };

	public static void main(String[] args) {
		String linha = readLn();
		int numero = Integer.parseInt(linha);
		
		while (numero != 0) {
			
			/*boolean[] garotos = new boolean[numero * 2 + 1];
			
			int m = numero * 2 - 1;
			int seta = (m - 1) % (numero * 2) + 1;
			garotos[m] = true;
			
			
			while (true) {
				
				boolean ehValido = seta > numero;
			
				for (int i = 1; ehValido && i < numero; i++) {
					int cont = 0;
					
					while (cont < m) {
						seta++;
						if (seta > numero * 2) seta = 1;
						
						if (garotos[seta] == false) {
							cont++;
						}
					}
					
					garotos[seta] = true;
					if (seta <= numero) ehValido = false;
				}


				if (ehValido) {
					break;
				} else {
					// reset
					for (int i = 0; i < garotos.length; i++) garotos[i] = false;
					m++;
					seta = (m - 1) % (numero * 2) + 1;
					garotos[seta] = true;
				}
			}
			
			System.out.println(m);*/
			
			System.out.println(respostas[numero]); // pre-calculo
			
			
			linha = readLn();
			numero = Integer.parseInt(linha);
		}
	}

}
