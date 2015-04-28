
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
		String linha = readLn();
		
		int nTestes = Integer.parseInt(linha);
		
		for (int g = 0; g < nTestes; g++) {
			readLn();
			
			String linha1 = readLn();
			String linha2 = readLn();
			
			int[] freq1 = getFrequencia(linha1);
			int[] freq2 = getFrequencia(linha2);
			
			char[] conversor = new char[256];
			
			int indice1 = getIndiceDoMaior(freq1);
			int indice2 = getIndiceDoMaior(freq2);
			
			while (indice1 != -1 && indice2 != -1) {
				
				conversor[indice2] = (char) indice1;
				
				freq1[indice1] = 0;
				freq2[indice2] = 0;
				
				
				
				indice1 = getIndiceDoMaior(freq1);
				indice2 = getIndiceDoMaior(freq2);
			}
			
			StringBuffer resultado = new StringBuffer();
			
			for (int i = 0; i < linha2.length(); i++) {
				resultado.append(conversor[linha2.charAt(i)]);
			}
			
			System.out.println(resultado);
			if (g < nTestes - 1) System.out.println();
			
		}
	}
	
	static int getIndiceDoMaior(int[] freq) {
		int indice = -1;
		int valor = 0;
		
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > valor) {
				valor = freq[i];
				indice = i;
			}
		}
		
		return indice;
	}
	
	static int[] getFrequencia(String texto) {
		int[] resultado = new int[256];
		
		for (int i = 0; i < texto.length(); i++) {
			char ch = texto.charAt(i);
			
			resultado[ch]++;
		}
		
		return resultado;
	}

}
