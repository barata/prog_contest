import java.io.IOException;

class Main {

	static String readLn(int maxLg) { // utility function to read from stdin
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;

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
		String numero = readLn(200);
		
		while (! numero.equals("0") ) {
			for (int i = getMenorBase(numero); i < 100; i++) {
				
				long decimal = converte(numero, i);

				if (decimal == Math.round(Math.sqrt(decimal)) * Math.round(Math.sqrt(decimal))) {
					System.out.println(i);
					break;
				}
				
			}
			
			
			numero = readLn(200);
		}
	}
	
	static long converte(String numero, int base) {
		long resultado= 0;
		
		for (int i = numero.length() - 1; i >= 0; i--) {
			int valor = Character.getNumericValue(numero.charAt(i));
			
			resultado += valor * Math.pow(base, numero.length() - (i + 1));
		}
		
		return resultado;
	}
	
	static int getMenorBase(String numero) {
		int maiorTermo = -1;
		
		for (int i = 0; i < numero.length(); i++) {
			int valor = Character.getNumericValue(numero.charAt(i));
			
			maiorTermo = Math.max(maiorTermo, valor);
		}
		
		if (maiorTermo < 2) return 2;
		return maiorTermo + 1;
	}
}
