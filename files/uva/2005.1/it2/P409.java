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
		String linha = readLn();
		
		int nTeste = 0;
		
		while (linha != null) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			int k = Integer.parseInt(tks.nextToken());
			int e = Integer.parseInt(tks.nextToken());
			
			String[] dicionario = new String[k];
			
			for (int i = 0; i < dicionario.length; i++) {
				dicionario[i] = readLn();
			}
			
			String[] frases = new String[e];
			int[] cont = new int[e];
			
			for (int i = 0; i < frases.length; i++) {
				frases[i] = readLn();
			}
			
			int max = processa(frases, cont, dicionario);
			
			
			System.out.println("Excuse Set #" + (++nTeste));
			
			for (int i = 0; i < cont.length; i++) {
				if (cont[i] == max) System.out.println(frases[i]);
			}
			
			System.out.println();
			
			
			
			linha = readLn();
		}
	}

	static int processa(String[] frases, int[] cont, String[] dicionario) {
		int max = 0;
		for (int i = 0; i < frases.length; i++) {
			cont[i] = contaPalavras(frases[i], dicionario);
			max = Math.max(max, cont[i]);
		}
		return max;
	}
	
	static int contaPalavras(String frase, String[] dicionario) {
		char[] array = new char[frase.length()];
		frase.getChars(0, frase.length(), array, 0);
		
		for (int i = 0; i < array.length; i++) {
			char ch = array[i];

			if ((ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z')) {
				array[i] = ' ';
			}
		}
		
		String novaFrase = new String(array);
		StringTokenizer tks = new StringTokenizer(novaFrase);
		
		int cont = 0;
		
		while (tks.hasMoreTokens()) {
			String token = tks.nextToken().toLowerCase();
			for (int i = 0; i < dicionario.length; i++) {
				if (dicionario[i].toLowerCase().equals(token)) {
					cont++;
				}
			}
		}
		
		return cont;
	}

}
