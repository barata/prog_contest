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
		String linha;
		
		Vector palavras = new Vector();
		
		// reads the input dictionary
		linha = readLn();
		
		while (!linha.equals("#")) {
			palavras.addElement(linha);
			
			linha = readLn();
		}
		
		// process each case
		linha = readLn();
		
		while (!linha.equals("#")) {
			StringTokenizer tks = new StringTokenizer(linha);
			char[] letras = new char[tks.countTokens()];
			
			for (int i = 0; i < letras.length; i++) {
				letras[i] = tks.nextToken().charAt(0);
			}
			
			int cont = 0;
			
			for (int i = 0; i < palavras.size(); i++) {
				String palavra = (String) palavras.elementAt(i);
				boolean[] mask = new boolean[letras.length];
				
				boolean possivel = true;
				
				for (int j = 0; j < palavra.length(); j++) {
					int indice = canUse(letras, palavra.charAt(j), mask);

					if (indice < 0) {
						possivel = false;
						break;
					} else {
						mask[indice] = true;
					}
				}
				
				if (possivel) cont++;
			}
			
			System.out.println(cont);
			
			linha = readLn();
		}
	}
	
	static int canUse(char[] array, char c, boolean[] mask) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == c && !mask[i]) return i;
		}
		return -1;
	}

}
