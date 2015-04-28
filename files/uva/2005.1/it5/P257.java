import java.util.Hashtable;
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
		
		while (linha != null) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			while (tks.hasMoreTokens()) {
				String aux = tks.nextToken();
				if (ehPalinword(aux)) System.out.println(aux);
			}
			
			
			
			linha = readLn();
		}
	}
	
	static boolean ehPalinword(String palavra) {
		Hashtable tabela = new Hashtable();
		for (int i = 1; i < palavra.length() - 1; i++) {
			if (palavra.charAt(i - 1) == palavra.charAt(i + 1)) {
				String aux = palavra.substring(i - 1, i + 2);
				tabela.put(aux, aux);
				if (tabela.size() == 2) return true;
			} else if (i < palavra.length() - 2 &&
					palavra.charAt(i) == palavra.charAt(i + 1) && palavra.charAt(i - 1) == palavra.charAt(i + 2)) {
				String aux = palavra.substring(i - 1, i + 3);
				tabela.put(aux, aux);
				if (tabela.size() == 2) return true;
			}
		}
		return false;
	}

}
