import java.io.IOException;

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
		
		String linha = readLn(21);
		
		System.out.println("         NAME                     SOUNDEX CODE");
		
		 while (linha != null) {
		 	
		 	String codigo = "";
		 	codigo += linha.charAt(0);
		 	
		 	for (int i = 1; i < linha.length(); i++) {
		 		char ch = linha.charAt(i);
		 		char ant = linha.charAt(i - 1);
		 		
		 		if (getCodigo(ch) == -1 || getCodigo(ch) == getCodigo(ant)) continue;
		 		
		 		codigo += getCodigo(ch);
		 	}
		 	
		 	codigo = formataCodigo(codigo);
		 	
		 	System.out.print("         ");
		 	System.out.print(linha + str(' ', 25 - linha.length()));
		 	System.out.println(codigo);
		 	
		 	
		 	
		 	linha = readLn(21);
		 }
		 
		 System.out.println("                   END OF OUTPUT");
	}
	
	static String formataCodigo(String codigo) {
		if (codigo.length() > 4) return codigo.substring(0, 4);
		
		return codigo + str('0', 4 - codigo.length());
	}
	
	static String str(char ch, int n) {
		String resultado = "";
		
		for (int i = 0; i < n; i++) {
			resultado += ch;
		}
		
		return resultado;
	}
	
	static int getCodigo(char ch) {
		switch (ch) {
			case 'B': case 'P': case 'F': case 'V':
				return 1;
			case 'C': case 'S': case 'K': case 'G':
			case 'J': case 'Q': case 'X': case 'Z':
				return 2;
			case 'D': case 'T':
				return 3;
			case 'L':
				return 4;
			case 'M': case 'N':
				return 5;
			case 'R':
				return 6;
			default:
				return -1;
		}
	}
}
