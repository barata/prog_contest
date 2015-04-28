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
		
		while (!"XXXXXX".equals(linha)) {
			insereOrdenado(dicionario, linha);
			
			linha = readLn();
		}
		
		linha = readLn();
		
		while (!"XXXXXX".equals(linha)) {
			
			boolean achou = false;
			
			for (int i = 0; i < dicionario.size(); i++) {
				String aux = (String) dicionario.elementAt(i);
				
				if (ehAnagrama(linha, aux)) {
					achou = true;
					System.out.println(aux);
				}
			}
			
			if (!achou) System.out.println("NOT A VALID WORD");
			
			System.out.println("******");
			
			
			linha = readLn();
		}
	}
	
	static void insereOrdenado(Vector lista, String valor) {
		boolean inseriu = false;
		for (int i = 0; !inseriu && i < lista.size(); i++) {
			String aux = (String) lista.elementAt(i);
			
			if (aux.compareTo(valor) >= 0) {
				lista.insertElementAt(valor, i);
				inseriu = true;
			}
		}
		
		if (!inseriu) lista.addElement(valor);
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

}
