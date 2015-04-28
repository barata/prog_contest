import java.io.IOException;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

class Main {

	static String readLn(int maxLg) { // utility function to read from stdin
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		String line = "";

		try {
			while (lg < maxLg) {
				car = System.in.read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}

		if ((car < 0) && (lg == 0))
			return (null); // eof
		return (new String(lin, 0, lg)).trim();
	}

	public static void main(String[] args) {
		String linha = readLn(255);
		StringTokenizer tks;
		Vector dic = new Vector();
		
		while (linha != null) {
			
			linha = preProcessa(linha);
			tks = new StringTokenizer(linha);
			
			while (tks.hasMoreTokens()) {
				String palavra = tks.nextToken();
				if (! dic.contains(palavra) ) {
					dic.addElement(palavra);
				}
			}
			
			
			linha = readLn(255);
		}
		
		ordena(dic);
		
		Enumeration enum = dic.elements();
		while (enum.hasMoreElements()) {
			System.out.println(enum.nextElement());
		}
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
	
	static String preProcessa(String linha) {
		String resultado = "";
		linha = linha.toLowerCase();
		for (int i = 0; i < linha.length(); i++) {
			if (isValid(linha.charAt(i))) {
				resultado += linha.charAt(i);
			} else {
				resultado += ' ';
			}
		}
		return resultado;
	}
	
	static boolean isValid(char caractere) {
		return caractere >= 'a' && caractere <= 'z' || caractere == ' ';
	}
}
