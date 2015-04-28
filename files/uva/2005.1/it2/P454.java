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
        return (buffer.toString());
    }

	public static void main(String[] args) {
		String linha = readLn();
		int nTestes = Integer.parseInt(linha);
		
		readLn();
		
		for (int g = 0; g < nTestes; g++) {
			linha = readLn();
			
			Vector palavras = new Vector();
			
			while (linha != null && !linha.trim().equals("")) {
				palavras.addElement(linha);
				
				linha = readLn();
			}
			
			ordena(palavras);
			
			for (int i = 0; i < palavras.size() - 1; i++) {
				String s1 = (String) palavras.elementAt(i);
				
				Vector respostas = new Vector();
				
				for (int j = i + 1; j < palavras.size(); j++) {
					String s2 = (String) palavras.elementAt(j);

					if (ehAnagrama(s1, s2)) respostas.addElement(s2);
				}

				for (int j = 0; j < respostas.size(); j++) {
					System.out.println(s1 + " = " + respostas.elementAt(j));
				}
			}
			
			if (g < nTestes - 1) System.out.println();
			
		}
	}
	
	private static boolean ehAnagrama(String palavra1, String palavra2) {
		int[] freq1 = new int[256];
		int[] freq2 = new int[256];
		
		// conta frequencias
		for (int i = 0; i < palavra1.length(); i++) {
			char ch = palavra1.charAt(i);
			if (ch != ' ') freq1[ch]++;
		}
		
		for (int i = 0; i < palavra2.length(); i++) {
			char ch = palavra2.charAt(i);
			if (ch != ' ') freq2[ch]++;
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

}
