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
        return (buffer.toString()); 
    }

	public static void main(String[] args) {
		String linha = readLn();
		
		while (linha != null) {
			
			boolean p1 = p1(linha);
			
			if (!p1) {
				System.out.println("FFFFFFF The solution is not accepted");
			} else {
				String resultado = "T";
				
				StringTokenizer tks = new StringTokenizer(linha);
				String palavra1 = tks.nextToken();
				int numero = Integer.parseInt(tks.nextToken());
				String palavra2 = tks.nextToken();
				
				resultado += ehPalindromo(palavra2) ? "T" : "F";
				
				int[] freq1 = getFrequencia(palavra1);
				int[] freq2 = getFrequencia(palavra2);
				
				resultado += contem(freq1, freq2) ? "T" : "F";
				
				resultado += compara(freq1, freq2) ? "T" : "F";
				
				resultado += subsequencia(palavra1, palavra2) ? "T" : "F";
				
				resultado += p6(palavra1, palavra2, numero) ? "T" : "F";
				
				resultado += p7(palavra1, numero) ? "T" : "F";
				
				
				
				boolean homogeneo = homogeneo(resultado, 'T');
				resultado += " The solution is";
				if (!homogeneo) resultado += " not";
				resultado += " accepted";
				
				System.out.println(resultado);
			}
			
			
			
			
			
			linha = readLn();
		}
	}
	
	static boolean homogeneo(String linha, char ch) {
		for (int i = 0; i < linha.length(); i++) {
			if (linha.charAt(i) != ch) return false;
		}
		return true;
	}
	
	static boolean p1(String linha) {
		
		int contEsp = 0;
		for (int i = 0; i < linha.length(); i++) {
			char ch = linha.charAt(i);
			
			if (ch == ' ') {
				contEsp++;
				if (contEsp > 2) return false;
			} else {
				if (contEsp != 1 && (ch < 'a' || ch > 'z')) return false;
			}
		}
		
		int primeiroEspaco = linha.indexOf(" ");
		int ultimoEspaco = linha.lastIndexOf(" ");
		
		int numero = -1;
		try {
			numero = Integer.parseInt(linha.substring(primeiroEspaco + 1, ultimoEspaco));
		} catch (Exception e) {
			return false;
		}
		
		String palavra1 = linha.substring(0, primeiroEspaco);
		String palavra2 = linha.substring(ultimoEspaco + 1);
		
		if (numero < 0 || numero > 1000) return false;
		
		if (palavra1.length() > 1000) return false;
		
		if (palavra2.length() > 2000) return false;
		
		return true;
	}
	
	static boolean p6(String palavra1, String palavra2, int numero) {
		return palavra2.length() == palavra1.length() + numero;
	}
	
	static boolean p7(String palavra1, int numero) {
		return numero < palavra1.length();
	}
	
	static boolean ehPalindromo(String linha) {
		for (int i = 0; i < linha.length() / 2; i++) {
			if (linha.charAt(i) != linha.charAt(linha.length() - i - 1)) return false;
		}
		return true;
	}
	
	static boolean contem(int[] freq1, int[] freq2) {
		for (int i = 0; i < freq1.length; i++) {
			if (freq1[i] > 0 && freq2[i] == 0) return false;
		}
		return true;
	}
	
	static boolean compara(int[] freq1, int[] freq2) {
		for (int i = 0; i < freq2.length; i++) {
			if (freq2[i] < freq1[i]) return false;
		}
		return true;
	}
	
	static boolean subsequencia(String palavra1, String palavra2) {
		int i = 0;
		int j = 0;
		
		while (i < palavra1.length() && j < palavra2.length()) {
			
			if (palavra1.charAt(i) == palavra2.charAt(j)) i++;
			j++;
			
		}

		return (i == palavra1.length());
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
