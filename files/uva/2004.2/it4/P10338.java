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
		int nTestes = Integer.parseInt(readLn(6));
		String palavra;
		int[] freq;
		
		for (int g = 1; g <= nTestes; g++) {
			
			palavra = readLn(21);
			freq = new int[256];
			
			for (int i = 0; i < palavra.length(); i++) {
				char ch = palavra.charAt(i);
				freq[ch]++;
			}
			
			long numerador = palavra.length();
			long fat = fatorial(numerador);

			for (int i = 0; i < freq.length; i++) {
				int fValor = freq[i];
				if (fValor > 1) {
					fat /= fatorial(fValor);
				}
			}
			
			System.out.println("Data set " + g + ": " + fat);
			
		}
	}
	
	static long fatorial(long numero) {
		long result = 1;
		for (long i = numero; i > 1; i--) {
			result *= i;
		}
		return result;
	}
}
