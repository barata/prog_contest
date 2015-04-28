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
		String linha = readLn(1000);
		
		while (linha != null) {
			int[] freq = new int[256];
			
			for (int i = 0; i < linha.length(); i++) {
				char chr = linha.charAt(i);
				if ((chr >= 'A' && chr <= 'Z') || (chr >= 'a' && chr <= 'z')) {
					freq[chr]++;
				}
			}
			
			int maiorFreq = 0;
			for (int i = 0; i < freq.length; i++) {
				if (freq[i] > maiorFreq) maiorFreq = freq[i];
			}

			for (int i = 0; i < freq.length; i++) {
				if (freq[i] == maiorFreq) System.out.print((char) i);
			}
			System.out.println(" " + maiorFreq);
			
			linha = readLn(1000);
		}
	}
}
