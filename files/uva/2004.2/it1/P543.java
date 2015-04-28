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
	
	private static final int MAX = 1000000;
	
	private static boolean primos[] = new boolean[MAX + 1];

	static {
		for (int i = primos.length - 1; i >= 0; i--) {
			primos[i] = true;
		}
		
		for (int i = 2; i <= Math.round(Math.sqrt(MAX)); i++) {
			for (int j = i; j <= MAX / i; j++) {
				primos[i * j] = false;
			}
		}
	}

	public static void main(String[] args) {
		String linha = readLn(255);
		
		while (linha != null && !linha.equals("0")) {
			int numero = Integer.parseInt(linha);
			boolean acabou = false;
			
			if (numero < 6) {
				System.out.println("Goldbach's conjecture is wrong.");
			} else {
				for (int i = 3; !acabou && i <= numero / 2; i++) {
					if (ehPrimo(i) && ehPrimo(numero - i)) {
						System.out.println(numero + " = " + i + " + " + (numero - i));
						acabou = true;
					}
				}
				if (!acabou) {
					System.out.println("Goldbach's conjecture is wrong.");
				}
			}
			
			linha = readLn(255);
		}
	}

	private static boolean ehPrimo(int numero) {
		return primos[numero];
	}
}
