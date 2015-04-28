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
        return buffer.toString(); 
    }

	public static void main(String[] args) {
		String linha = readLn();
		
		while (linha != null) {
			
			int size = linha.length();
			
			char[] palavras = getArray(size);
			char[] simbolos = getArray(size);

			for (int i = 0; i < size; i++) {
				char ch = linha.charAt(i);
				
				if (ehLetra(ch)) {
					palavras[i] = ch;
					simbolos[i] = 'x';
				} else{
					simbolos[i] = ch;
				}
				
			}
			
			StringTokenizer p = new StringTokenizer(new String(palavras));
			StringTokenizer s = new StringTokenizer(new String(simbolos), "x");
			
			// juntando palavras e simbolos
			StringBuffer resultado = new StringBuffer();
			
			if (!ehLetra(linha.charAt(0))) resultado.append(s.nextToken());
			
			while (p.hasMoreTokens()) {
				String palavra = p.nextToken();
				
				char prim = palavra.charAt(0);
				if (ehVogal(prim)) {
					palavra += "ay";
				} else {
					palavra = palavra.substring(1) + prim + "ay";
				}
				
				resultado.append(palavra);
				
				if (s.hasMoreTokens()) resultado.append(s.nextToken());
			}
			
			// imprime
			System.out.println(resultado);
			
			
			
			linha = readLn();
		}
	}
	
	static char[] getArray(int tam) {
		char[] array = new char[tam];
		
		for (int i = 0; i < tam; i++) {
			array[i] = ' ';
		}
		
		return array;
	}
	
	static boolean ehLetra(char ch) {
		return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
	}
	
	static boolean ehVogal(char ch) {
		return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
				ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
	}
}
