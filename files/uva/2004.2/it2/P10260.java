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
	
	static int mapa[] = new int[256];
	
	static {
		
		for (int i = 0; i < mapa.length; i++) {
			mapa[i] = -1;
		}
		
		mapa['B'] = 1;
		mapa['F'] = 1;
		mapa['P'] = 1;
		mapa['V'] = 1;
		
		mapa['C'] = 2;
		mapa['G'] = 2;
		mapa['J'] = 2;
		mapa['K'] = 2;
		mapa['Q'] = 2;
		mapa['S'] = 2;
		mapa['X'] = 2;
		mapa['Z'] = 2;
		
		mapa['D'] = 3;
		mapa['T'] = 3;
		
		mapa['L'] = 4;
		
		mapa['M'] = 5;
		mapa['N'] = 5;
		
		mapa['R'] = 6;
	}

	public static void main(String[] args) {
		String linha = readLn(21);
		
		while (linha != null && !linha.equals("")) {
			
			String result = "";
			
			for (int i = 0; i < linha.length(); i++) {
				if (mapa[linha.charAt(i)] != -1) {
					if (i == 0) result += mapa[linha.charAt(0)];
					if (i > 0 && mapa[linha.charAt(i - 1)] != mapa[linha.charAt(i)]) {
						result += mapa[linha.charAt(i)];
					}
				}
			}
			
			System.out.println(result);
			
			linha = readLn(21);
		}
	}
}
