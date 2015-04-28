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
	
	static final float[] moedas = { 0.05f, 0.1f, 0.2f, 0.5f, 1, 2, 5, 10, 20, 50, 100 };
	
	static final int MAX = 300 * 100;
	
	static long[] nWays = new long[MAX + 1];
	
	static {
		nWays[0] = 1;

		for (int i = 0; i < moedas.length; i++) {
			int valorMoeda = Math.round(moedas[i] * 100);
			
			for (int j = valorMoeda; j <= MAX; j += 5) {
				nWays[j] += nWays[j - valorMoeda];
			}
		}
	}

	public static void main(String[] args) {
		String linha = readLn(10);
		
		while (linha != null && !linha.equals("0.00")) {
			float numero = Float.valueOf(linha).floatValue();
			
			System.out.println(rightJustify(linha, 6) + rightJustify(String.valueOf(nWays[Math.round(numero * 100)]), 17));
			
			
			linha = readLn(10);
		}
	}
	
	static String rightJustify(String linha, int n) {
		return str(' ', n - linha.length()) + linha;
	}
	
	static String str(char ch, int n) {
		String resultado = "";

		for (int i = 0; i < n; i++) {
			resultado += ch;
		}
		
		return resultado;
	}
}
