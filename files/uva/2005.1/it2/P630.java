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
		
		int nTestes = Integer.parseInt(linha);
		
		for (int g = 0; g < nTestes; g++) {
			readLn();
			
			int numeroDePalavras = Integer.parseInt(readLn());
			String[] dicionario = new String[numeroDePalavras];
			
			for (int i = 0; i < numeroDePalavras; i++) {
				dicionario[i] = readLn();
			}
			
			linha = readLn();
			
			while (!linha.equals("END")) {
				Vector respostas = new Vector();
				
				for (int i = 0; i < dicionario.length; i++) {
					if (ehAnagrama(dicionario[i], linha)) {
						respostas.addElement(dicionario[i]);
					}
				}
				
				System.out.println("Anagrams for: " + linha);
				
				if (respostas.isEmpty()) {
					System.out.println("No anagrams for: " + linha);
				} else {
					for (int i = 0; i < respostas.size(); i++) {
						System.out.println(formata(i + 1, 3) + ") " + respostas.elementAt(i));
					}
				}
				
				
				linha = readLn();
			}
			
			if (g < nTestes - 1) System.out.println();
		}
	}

	private static boolean ehAnagrama(String palavra1, String palavra2) {
		int[] freq1 = new int[256];
		int[] freq2 = new int[256];
		
		// conta frequencias
		for (int i = 0; i < palavra1.length(); i++) {
			freq1[palavra1.charAt(i)]++;
		}
		
		for (int i = 0; i < palavra2.length(); i++) {
			freq2[palavra2.charAt(i)]++;
		}
		
		// compara
		for (int i = 0; i < 256; i++) {
			if (freq1[i] != freq2[i]) return false;
		}
		
		return true;
	}
	
	static String formata(int numero, int espaco) {
		String n = "" + numero;
		
		return str(' ', espaco - n.length()) + n;
	}
	
	static String str(char ch, int n) {
		String resultado = "";
		n = Math.max(0, n);
		for (int i = 0; i < n; i++) {
			resultado += ch;
		}
		return resultado;
	}
}
