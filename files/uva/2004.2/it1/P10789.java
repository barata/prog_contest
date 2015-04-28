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
		String linha;
		
		for (int c = 0; c < nTestes; c++) {
			linha = readLn(2001);
			
			int[] letras = new int[256];
			boolean achou = false;
			
			for (int i = 0; i < linha.length(); i++) {
				letras[linha.charAt(i)]++;
			}
			
			String result = "Case " + (c + 1) + ": ";
			for (int i = 0; i < letras.length; i++) {
				if (letras[i] != 0) {
					if (ehPrimo(letras[i])) {
						result += (char) i;
						achou = true;
					}
				}
			}
			
			if (!achou) result += "empty";
			
			System.out.println(result);
		}
	}

	static boolean ehPrimo(int numero) {
		if (numero == 1) return false;
		for (int i = 2; i <= Math.round(Math.sqrt(numero)); i++) {
			if (numero % i == 0) return false;
		}
		return true;
	}
}
