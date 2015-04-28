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
	
	static final int[] moedas = { 1, 5, 10, 25, 50 };
	
	static final int MAX = 10000;
	
	static long[] nWays = new long[MAX + 1];
	
	static {
		nWays[0] = 1;

		for (int i = 0; i < moedas.length; i++) {
			int valorMoeda = moedas[i];
			
			for (int j = valorMoeda; j <= MAX; j++) {
				nWays[j] += nWays[j - valorMoeda];
			}
		}
	}

	public static void main(String[] args) {
		String linha = readLn(10);
		
		while (linha != null && !linha.equals("")) {
			int numero = Integer.parseInt(linha);
			
			System.out.println(nWays[numero]);
			
			linha = readLn(10);
		}
	}

}
