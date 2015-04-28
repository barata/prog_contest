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
		int nTestes = Integer.parseInt(readLn(255));
		
		for (int c = 0; c < nTestes; c++) {
			long numero = Integer.parseInt(readLn(255));

			processa(numero);
		}
	}
	
	static void processa(long numero) {
		long numeroInvertido = 0;
		int count = 0;
		
		while (count < 1000) {
			numeroInvertido = getPalindromo(numero);
			numero += numeroInvertido;
			count++;
			if (ehPalindromo(numero)) break;
		}
		System.out.println(count + " " + numero);
	}
	
	static long getPalindromo(long numero) {
		String valor = String.valueOf(numero);
		String result = "";
		
		for (int i = valor.length() - 1; i >= 0; i--) {
			result += valor.charAt(i);
		}
		
		return Long.parseLong(result);
	}
	
	static boolean ehPalindromo(long numero) {
		String valor = String.valueOf(numero);
		
		for (int i = 0; i < valor.length() / 2; i++) {
			if (valor.charAt(i) != valor.charAt(valor.length() - (i + 1))) {
				return false;
			}
		}
		
		return true;
	}
}
