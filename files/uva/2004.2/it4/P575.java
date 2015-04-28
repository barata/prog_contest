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
		String linha = readLn(255);
		
		while (! linha.equals("0") ) {
			
			System.out.println(converte(linha, 2));
			
			
			linha = readLn(255);
		}
	}
	
	static long converte(String numero, int base) {
		long resultado= 0;
		
		for (int i = numero.length() - 1; i >= 0; i--) {
			int valor = Character.getNumericValue(numero.charAt(i));
			
			resultado += valor * (Math.pow(base, numero.length() - i) - 1);
		}
		
		return resultado;
	}

}
