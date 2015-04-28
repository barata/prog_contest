import java.util.StringTokenizer;
import java.util.Vector;

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
		
		Vector dicionario = new Vector();
		
		while (! linha.equals("#") ) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			while (tks.hasMoreTokens()) {
				String palavra = tks.nextToken();
				
				dicionario.addElement(palavra);
			}

			linha = readLn();
		}
		
		boolean[] anagramas = new boolean[dicionario.size()];
		
		for (int i = 0; i < dicionario.size(); i++) {
			String p1 = (String) dicionario.elementAt(i);

			if (p1.length() == 1) {
				continue;
			} else {
				for (int j = i + 1; j < dicionario.size(); j++) {
					String p2 = (String) dicionario.elementAt(j);
					
					if (ehAnagrama(p1, p2)) {
						anagramas[i] = true;
						anagramas[j] = true;
						
						break;
					}
				}
			}
		}
		
		Vector respostas = new Vector();
		
		for (int i = 0; i < anagramas.length; i++) {
			if (! anagramas[i] ) respostas.addElement(dicionario.elementAt(i));
		}
		
		ordena(respostas);
		
		for (int i = 0; i < respostas.size(); i++) {
			System.out.println(respostas.elementAt(i));
		}
	}
	
	static boolean ehAnagrama(String palavra1, String palavra2) {
		if (palavra1.length() != palavra2.length()) return false;
		
		int[] freq1 = new int[256];
		int[] freq2 = new int[256];
		
		// conta frequencias
		for (int i = 0; i < palavra1.length(); i++) {
			char ch = Character.toLowerCase(palavra1.charAt(i));
			freq1[ch]++;
		}
		
		for (int i = 0; i < palavra2.length(); i++) {
			char ch = Character.toLowerCase(palavra2.charAt(i));
			freq2[ch]++;
		}
		
		// compara
		for (int i = 0; i < 256; i++) {
			if (freq1[i] != freq2[i]) return false;
		}
		
		return true;
	}
	
	static void ordena(Vector lista) {
		for (int i = 1; i < lista.size(); i++) {
			for (int j = lista.size() - 1; j >= i; j--) {
				String p1 = (String) lista.elementAt(j - 1);
				String p2 = (String) lista.elementAt(j);
				
				if (p1.compareTo(p2) > 0) {
					lista.setElementAt(p2, j - 1);
					lista.setElementAt(p1, j);
				}
			}
		}
	}
	
	static boolean contains(Vector dicionario, String palavra) {
		for (int i = 0; i < dicionario.size(); i++) {
			String aux = (String) dicionario.elementAt(i);
			
			if (aux.equalsIgnoreCase(palavra)) return true;
		}
		
		return false;
	}

}
