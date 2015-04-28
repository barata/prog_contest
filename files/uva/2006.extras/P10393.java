import java.util.Enumeration;
import java.util.Hashtable;
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
            if (car == newLine.charAt(0)) System.in.skip(newLine.length() - 1);
        } catch (java.io.IOException e) { return (null); }
        if ((car < 0) && (buffer.length() == 0)) return (null);
        return (buffer.toString()).trim();
    }
	
	static String[] dedos = new String[11];
	
	static {
		dedos[1] = "qaz";
		dedos[2] = "wsx";
		dedos[3] = "edc";
		dedos[4] = "rfvtgb";
		dedos[5] = " ";
		dedos[6] = " ";
		dedos[7] = "yhnujm";
		dedos[8] = "ik,";
		dedos[9] = "ol.";
		dedos[10] = "p;/";
	}
	
	public static void main(String[] args) {
		String linha = readLn();
		
		while (linha != null) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			int f = Integer.parseInt(tks.nextToken());
			int n = Integer.parseInt(tks.nextToken());
			
			boolean[] letras = new boolean[256];
			
			if (f > 0) {
				tks = new StringTokenizer(readLn());
				
				for (int i = 0; i < f; i++) {
					int dedo = Integer.parseInt(tks.nextToken());
					
					for (int j = 0; j < dedos[dedo].length(); j++) {
						letras[dedos[dedo].charAt(j)] = true;
					}
				}
			}
			
			Hashtable[] palavras = new Hashtable[51];
			for (int i = 0; i < palavras.length; i++) {
				palavras[i] = new Hashtable();
			}
			
			for (int i = 0; i < n; i++) {
				linha = readLn();
				if (podeDigitar(linha, letras)) {
					palavras[linha.length()].put(linha, linha);
				}
			}
			
			Vector resultado = new Vector();
			
			for (int i = palavras.length - 1; i >= 0; i--) {
				if (!palavras[i].isEmpty()) {
					Enumeration en = palavras[i].keys();
					while (en.hasMoreElements()) {
						resultado.addElement(en.nextElement());
					}
					
					break;
				}
			}
			
			ordena(resultado);
			
			System.out.println(resultado.size());
			
			for (int i = 0; i < resultado.size(); i++) {
				System.out.println(resultado.elementAt(i));
			}
			
			
			
			linha = readLn();
		}
	}

	static boolean podeDigitar(String linha, boolean[] letras) {
		for (int i = 0; i < linha.length(); i++) {
			if (letras[linha.charAt(i)]) return false;
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
